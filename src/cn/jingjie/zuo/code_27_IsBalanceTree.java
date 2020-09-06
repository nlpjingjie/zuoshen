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
	
	public static class heightAndBalance{// ƽ��״̬�ķ�������
		public int height;
		public Boolean isB;
		
		public heightAndBalance(int h, Boolean b) {
			this.height = h;
			this.isB = b;
		}
	}
	
	public static heightAndBalance isBalanceTree(Node head) {// �ж�һ�����Ƿ���ƽ�������,�ݹ��˼·��
		// ������ƽ�⣬������ƽ�⣬ͨ�����������ĸ߶Ȳ��ж�������Ƿ�ƽ�⣬����ֵӦ�ð������ߺ��Ƿ�ƽ��
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
