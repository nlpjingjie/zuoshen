package cn.jingjie.zuo;


public class code_29_CBTNodeNumbers {// 完全二叉树的节点个数
	public static class Node{
		public Node left;
		public Node right;
		public int value;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static int nodeNumbers(Node head) {
		if(head == null) {
			return 0;
		}
		int wh = getTreeHeight(head); // 树总高
		int yh = getTreeHeight(head.right); // 拿到右子数的高度
		if(wh == yh+1) {// 左子树为满二叉树
			return (1<<yh) + nodeNumbers(head.right);
		}else {// 右子树为满二叉树
			return (1<<yh) + nodeNumbers(head.left);
		}
	}

	private static int getTreeHeight(Node cur) {// 计算树高
		int h = 0;
		while(cur != null) {// 拿到总树高
			h++;
			cur = cur.left;
		}
		return h;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.left = new Node(2);
		n1.right = new Node(3);
		n1.left.left = new Node(4);
		n1.left.right = new Node(5);
		n1.right.left = new Node(6);
		n1.right.right = new Node(7);
		
		Node n2 = new Node(5);
		n2.left = new Node(4);
		n2.right = new Node(6);
		n2.left.left = new Node(3);
		n2.left.right = new Node(5);
		n2.right.left = new Node(5);
		// System.out.println(1<<3);
		System.out.println(nodeNumbers(n1));
		System.out.println(nodeNumbers(n2));
	}
}
