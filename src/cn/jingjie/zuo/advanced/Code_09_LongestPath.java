package cn.jingjie.zuo.advanced;


import cn.jingjie.zuo.advanced.Code_09_MaxMInBT.Node;

// �������ϵ���Զ����
/*
 * ��߾��룬���ޣ���߾���+1
 * �ұ߾��룬����,�ұ߾���+1
 * ���Ҿ��붼�У���߾���+��ǰ�ڵ�+�ұ߾��루·�����ȣ�
 * �õ������·������
 */
public class Code_09_LongestPath {
	public static class ReturnType{
		public int distance;
		public int path;
		
		public ReturnType(int d, int p) {
			distance = d;
			path = p;
		}
	}
	
	public static ReturnType process(Node head) {
		if(head == null) {
			return new ReturnType(0, 0);
		}
		
		ReturnType leftData = process(head.left);
		ReturnType rightData = process(head.right);
		int longestPath = Math.max(Math.max(leftData.path, rightData.path), leftData.distance + rightData.distance + 1);
		return new ReturnType(Math.max(leftData.distance, rightData.distance) + 1, longestPath);
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(4);
		n1.left = new Node(2);
		n1.right = new Node(3);
//		n1.right = new Node(5);
		n1.left.left = new Node(0);
		n1.left.right = new Node(3);
		n1.right.left = new Node(5);
		n1.right.right = new Node(7);
		n1.right.left.left = new Node(6);
		
		ReturnType res = process(n1);
		System.out.println(res.path);
	}
}
