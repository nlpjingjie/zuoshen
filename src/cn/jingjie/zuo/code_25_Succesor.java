package cn.jingjie.zuo;


public class code_25_Succesor {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	// 找到任何一个节点的后继节点
	public static Node succesor(Node head) {
		if(head == null) {
			return head;
		}
		if(head.right != null) {// 当前节点右子树不为空
			return succesor1(head.right);
		}else {// 当前节点右子树为空的情况
			Node parent = head.parent;
			while(parent != null && parent.left != head) {// 当前节点为右孩子
				head = parent;
				parent = head.parent;
			}
			return parent;
		}
	}

	private static Node succesor1(Node head) {
		while(head.left != null) {
			head = head.left;
		}
		return head;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(2);
		n1.left = new Node(3);
		n1.left.parent = n1;
		n1.right = new Node(4);
		n1.right.parent = n1;
		n1.left.left = new Node(5);
		n1.left.left.parent = n1.left;
		n1.left.right = new Node(6);
		n1.left.right.parent = n1.left;
		n1.right.left = new Node(7);
		n1.right.left.parent = n1.right;
		n1.right.right = new Node(8);
		n1.right.right.parent = n1.right;
		
		Node res = succesor(n1.right.right);
		if(res == null) {
			System.out.print("null");
		}else {
			System.out.print(res.value);
		}
	}
}
