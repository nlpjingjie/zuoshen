package cn.jingjie.zuo;

import java.util.PriorityQueue;

// �н�������
public class code_36_LessMoney {
	// Huffman����˼�룬ͬ���Ľڵ㻮�֣���Ȩ·����С�����Ѵ�����С
	public static int lessMoney(Integer[] arr) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		Integer sum = 0;
		Integer cur = 0;
		for(int i=0; i < arr.length; i++) {
			priorityQueue.offer(arr[i]);
		}
		while(priorityQueue.size() > 1) {
			cur = priorityQueue.poll() + priorityQueue.poll();
			sum += cur;
			priorityQueue.offer(cur);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {10, 20, 30};
		Integer r = lessMoney(arr);
		System.out.print(r);
	}
}
