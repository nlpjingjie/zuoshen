package cn.jingjie.zuo;

import java.util.Comparator;
import java.util.PriorityQueue;

// ʵʱ��ȡ��λ��
public class code_35_Median {
	// ����һ������Ѻ�һ��С���ѣ�ʵʱά����λ��
	public static class MedianHolder{
		// С��������������ڵ�����λ��������
		public PriorityQueue<Integer> minHeap;
		// �������������С�ڵ�����λ��������
		public PriorityQueue<Integer> maxHeap;
		
		public MedianHolder() {
			minHeap = new PriorityQueue<Integer>();
			maxHeap = new PriorityQueue<Integer>(new maxHeapComparetor());
		}
	
		// ��MedianHolder���������
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
		
		// ���������ѵ�ƽ��,��֤��λ���ڶѶ�
		public void modifyTwoHeaps() {
			if(minHeap.size() - maxHeap.size() == 2) {
				maxHeap.add(minHeap.poll());
			}
			if(minHeap.size() - maxHeap.size() == -2) {
				minHeap.add(maxHeap.poll());
			}
		}
		
		// ��ȡ��λ��
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
	
	// ����ѵıȽ���ʵ��
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
