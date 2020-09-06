package cn.jingjie.zuo;

import java.util.Comparator;
import java.util.PriorityQueue;

// 实时获取中位数
public class code_35_Median {
	// 利用一个大根堆和一个小根堆，实时维护中位数
	public static class MedianHolder{
		// 小根堆用来保存大于等于中位数的数据
		public PriorityQueue<Integer> minHeap;
		// 大根堆用来保存小于等于中位数的数据
		public PriorityQueue<Integer> maxHeap;
		
		public MedianHolder() {
			minHeap = new PriorityQueue<Integer>();
			maxHeap = new PriorityQueue<Integer>(new maxHeapComparetor());
		}
	
		// 向MedianHolder中添加数据
		public void addNum(Integer data) {
			if(maxHeap.size() == 0) {
				maxHeap.add(data);
				return;
			}
			if(maxHeap.peek() > data) {
				maxHeap.add(data);
			}else {
//				if(minHeap.size() == 0) {
//					minHeap.add(data);
//					return;
//				}
//				if(minHeap.peek() < data) {
//					minHeap.add(data);
//				}else {
//					maxHeap.add(data);
//				}
				maxHeap.add(data);
			}
			modifyTwoHeaps();
		}
		
		// 调整两个堆的平衡,保证中位数在堆顶
		public void modifyTwoHeaps() {
			if(minHeap.size() - maxHeap.size() == 2) {
				maxHeap.add(minHeap.poll());
			}
			if(minHeap.size() - maxHeap.size() == -2) {
				minHeap.add(maxHeap.poll());
			}
		}
		
		// 获取中位数
		public Integer getMedian() {
			int minHeapSize = minHeap.size();
			int maxHeapSize = maxHeap.size();
			if(minHeapSize + maxHeapSize == 0) {
				return null;
			}
			Integer medianFromMinHeap = minHeap.peek();
			Integer medianFromMaxHeap = maxHeap.peek();
//			System.out.print(medianFromMinHeap);
//			System.out.print(medianFromMaxHeap);
			
			if(((minHeapSize + maxHeapSize)&1) == 0) {
				return (medianFromMinHeap + medianFromMaxHeap)/2;
			}
			return minHeapSize > maxHeapSize ? medianFromMinHeap:medianFromMaxHeap;  
		}
	}
	
	// 大根堆的比较器实现
	public static class maxHeapComparetor implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
	
	public static void main(String[] args) {
		MedianHolder mHolder = new MedianHolder();
		for(int i=0; i < 10; i++) {
			mHolder.addNum(i*2);
		}
		System.out.print(mHolder.getMedian());
	}
}
