package cn.jingjie.zuo;

import java.util.PriorityQueue;

// 切金条问题
public class code_36_LessMoney {
	// Huffman树的思想，同样的节点划分，带权路径最小，花费代价最小
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
