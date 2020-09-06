package cn.jingjie.zuo.advanced;


// morris遍历,时间复杂度O(N),空间复杂度O(1)
public class Morris {
	public static class Node{
		public Node left;
		public Node right;
		public int value;
		
		public Node(int data) {
			value = data;
		}
	}
	
	public static void morris(Node head) {
		if(head == null) {
			return;
		}
		Node cur = head;
		Node leftMostRight = null;
		while(cur != null) {
			leftMostRight = cur.left;
			if(leftMostRight != null) {
				while(leftMostRight.right != null && leftMostRight.right != cur) {
					leftMostRight = leftMostRight.right;
				}
				if(leftMostRight.right == null) {
					leftMostRight.right = cur;
					cur = cur.left;
					continue;
				}else {
					leftMostRight.right = null;
				}
			}
			// System.out.print(cur.value + " ");
			cur = cur.right;
		}
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.left = new Node(2);
		n1.right = new Node(3);
		n1.left.left = new Node(4);
		n1.left.right = new Node(5);
		n1.right.left = new Node(6);
		n1.right.right = new Node(7);
		
		morris(n1);
	}
}
