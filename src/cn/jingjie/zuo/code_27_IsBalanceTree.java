package cn.jingjie.zuo;

public class code_27_IsBalanceTree {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static class heightAndBalance{// 平衡状态的返回类型
		public int height;
		public Boolean isB;
		
		public heightAndBalance(int h, Boolean b) {
			this.height = h;
			this.isB = b;
		}
	}
	
	public static heightAndBalance isBalanceTree(Node head) {// 判断一棵树是否是平衡二叉树,递归的思路，
		// 左子树平衡，右子数平衡，通过左右子树的高度差判断这个树是否平衡，返回值应该包括树高和是否平衡
		if(head == null) {
			return new heightAndBalance(0, true);
		}
		heightAndBalance leftIsBalance = isBalanceTree(head.left);
		heightAndBalance rightIsBalance = isBalanceTree(head.right);
		if(leftIsBalance.isB && rightIsBalance.isB && Math.abs(leftIsBalance.height - rightIsBalance.height) < 2) {
			return new heightAndBalance(Math.max(leftIsBalance.height, rightIsBalance.height) + 1, true);
		}else {
			return new heightAndBalance(0, false);
		}
	}
}
