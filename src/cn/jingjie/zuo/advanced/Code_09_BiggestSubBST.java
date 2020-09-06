package cn.jingjie.zuo.advanced;

import cn.jingjie.zuo.advanced.Code_09_MaxMInBT.Node;

// ��һ�������������������������������������Ĵ�С
/*
 * 1.������������������������
 * 2.������������������������
 * 3.���Ҷ��У��ǲ�������ͷ�ڵ���ɸ��������������
 * �ϲ�3��Ҫ�����ݣ�������������ͷ�ڵ㣬�����������Ĵ�С���Լ����ֵ����Сֵ
 */
public class Code_09_BiggestSubBST {
	// 
	public static class ReturnType{
		public Node head;
		public int size;
		public int max;
		public int min;
		
		public ReturnType(int size, Node head, int min, int max) {
			this.head = head;
			this.size = size;
			this.max = max;
			this.min = min;
		}
	}
	
	public static ReturnType process(Node head) {
		if(head == null) {
			return new ReturnType(0, null, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		
		Node left = head.left;
		Node right = head.right;
		// �õ�������������
		ReturnType p1 = process(head.left);
		ReturnType p2 = process(head.right);
		
		// �Ƿ����3���ϲ�
		if(p1.head == left && p2.head == right && p1.max <= head.value && p2.min >= head.value) {
			// Math.min(p1.min, head.value) ����Ϊ��ʱ���õ���ȷ������
			return new ReturnType(p1.size + p2.size +1, head, Math.min(p1.min, head.value), Math.max(p2.max, head.value));
		}
		
		if(p1.size > p2.size) {
			return p1;
		}else {
			return p2;
		}
	}
	
//	public static ReturnType process(Node head) {
//		if(head == null) {
//			return new ReturnType(0,null,Integer.MAX_VALUE, Integer.MIN_VALUE);
//		}
//		Node left = head.left;
//		ReturnType leftSubTressInfo = process(left);
//		Node right = head.right;
//		ReturnType rightSubTressInfo = process(right);
//		
//		int includeItSelf = 0;
//		if(leftSubTressInfo.head == left 
//				&&rightSubTressInfo.head == right
//				&& head.value > leftSubTressInfo.max
//				&& head.value < rightSubTressInfo.min
//				) {
//			includeItSelf = leftSubTressInfo.size + 1 + rightSubTressInfo.size;
//		}
//		int p1 = leftSubTressInfo.size;
//		int p2 = rightSubTressInfo.size;
//		int maxSize = Math.max(Math.max(p1, p2), includeItSelf);
//		
//		Node maxHead = p1 > p2 ? leftSubTressInfo.head : rightSubTressInfo.head;
//		if(maxSize == includeItSelf) {
//			maxHead = head;
//		}
//		
//		return new ReturnType(maxSize,
//				maxHead, 
//				Math.min(Math.min(leftSubTressInfo.min,rightSubTressInfo.min),head.value),
//				Math.max(Math.max(leftSubTressInfo.max,rightSubTressInfo.max),head.value));	
//	}
	
	public static void main(String[] args) {
		Node n1 = new Node(4);
		n1.left = new Node(2);
		n1.right = new Node(3);
//		n1.right = new Node(5);
		n1.left.left = new Node(0);
		n1.left.right = new Node(3);
		n1.right.left = new Node(5);
		n1.right.right = new Node(7);
		
		ReturnType res = process(n1);
		System.out.println(res.head.value);
		System.out.println(res.size);
		System.out.println(res.min);
		System.out.println(res.max);
	}
}
