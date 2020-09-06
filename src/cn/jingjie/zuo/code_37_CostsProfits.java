package cn.jingjie.zuo;

import java.util.Comparator;
import java.util.PriorityQueue;

// ̰�Ĳ��ԣ��������ܹ���������������Ŀ���ܹ���������k����Ŀ����ȡ��������
public class code_37_CostsProfits {
	// ��֯����
	public static class Node {
		public int c;
		public int p;
		
		public Node(int cost, int profit) {
			this.c = cost;
			this.p = profit;
		}
	}
	// ��������������Ŀ���ޣ������ʽ���Ŀ���ѳɱ����飬��Ŀ��������
	public static int getMostMoney(int k, int b, int[] costs, int[] profits) {
		Node[] nodes = new Node[costs.length];
		for(int i=0; i < costs.length; i++) {
			nodes[i] = new Node(costs[i], profits[i]);
		}
		PriorityQueue<Node> minCost = new PriorityQueue<>(new minCostComparator());
		PriorityQueue<Node> maxProfit = new PriorityQueue<>(new maxProfitComparator());
		
		for(int j=0; j < costs.length; j++) {
			minCost.offer(nodes[j]);
		}
		
		for(int i=0; i < k; i++) {
			while(!minCost.isEmpty() && b >= minCost.peek().c) {
				maxProfit.offer(minCost.poll());
			}
			if(maxProfit.isEmpty()) {
				return b;
			}
			b += maxProfit.poll().p;
		}
		return b;
	}
	
	public static class minCostComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}
	}
	
	public static class maxProfitComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}
	}
	
	public static void main(String[] args) {
		int[] cos = {4, 6, 3, 8, 9, 12};
		int[] pro = {2, 3, 1, 3, 4, 5};
		System.out.print(getMostMoney(5, 3, cos, pro));
	}
}
