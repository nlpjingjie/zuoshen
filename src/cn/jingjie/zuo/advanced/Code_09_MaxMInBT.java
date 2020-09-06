package cn.jingjie.zuo.advanced;

// 二叉树信息收集问题
// 09，递归套路。分析数据，组织数据，递归。
// 拿到一颗二叉树的最大值和最小值
public class Code_09_MaxMInBT {
	public static class Node{
		public Node left;
		public Node right;
		public int value;
		
		public Node(int data) {
			value = data;
		}
	}
	// 
	public static class ReturnData{
		public int max;
		public int min;
		
		public ReturnData(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}
	
	public static ReturnData process(Node head) {
		if(head == null) {
			return new ReturnData(Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		ReturnData leftReturnData = process(head.left);
		ReturnData rightReturnData = process(head.right);

		return new ReturnData(Math.max(Math.max(leftReturnData.max, rightReturnData.max), head.value),
				Math.min(Math.min(leftReturnData.min, rightReturnData.min), head.value));
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(4);
		n1.left = new Node(3);
		n1.right = new Node(5);
		n1.left.left = new Node(2);
		n1.left.right = new Node(4);
		n1.right.left = new Node(6);
		n1.right.right = new Node(7);
		
		ReturnData res = process(n1);
		System.out.println(res.min);
		System.out.println(res.max);
	}
}
