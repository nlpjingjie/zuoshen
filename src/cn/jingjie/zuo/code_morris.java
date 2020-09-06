package cn.jingjie.zuo;


public class code_morris {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void morris(Node head) {
		if (head == null){
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// ��������Ϊ��
				while (mostRight.right != null && mostRight.right != cur) {// �ҵ������������ҽڵ�
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {// ������ҽڵ���Һ���Ϊ�գ������ҽڵ���Һ���ָ��cur��cur������
					mostRight.right = cur;
					cur = cur.left;
					continue;// ֱ����������ѭ�����жϵ�ǰcur���������Ƿ�Ϊ��
				} else {// ������ҽڵ���Һ��Ӳ�Ϊ�գ���ô����ָ��cur�ģ������ҽڵ���Һ���ָ��null,cur������
					mostRight.right = null;
				}
			}
			System.out.print(cur.value + " ");// ��һ������Ҷ�ӽڵ�͵ڶ���������Ҷ�ӽڵ㣬ֱ�Ӵ�ӡ��������
			cur = cur.right;
		}
		System.out.println();
	}
	
	public static void morrisPre(Node head) {// morris���������ӡ�������ڵ㣬��һ�������ڵ��ʱ���ӡ
		if (head == null){
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// ��������Ϊ��
				while (mostRight.right != null && mostRight.right != cur) {// �ҵ������������ҽڵ�
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {// ������ҽڵ���Һ���Ϊ�գ������ҽڵ���Һ���ָ��cur��cur������
					mostRight.right = cur;
					System.out.print(cur.value + " ");// ���ҽڵ���Һ���Ϊ�գ���һ������cur
					cur = cur.left;
					continue;// ֱ����������ѭ�����жϵ�ǰcur���������Ƿ�Ϊ��
				} else {// ������ҽڵ���Һ��Ӳ�Ϊ�գ���ô����ָ��cur�ģ������ҽڵ���Һ���ָ��null,cur������
					mostRight.right = null;// �ڶ�������cur
				}
			}else {// cur������Ϊ�գ�curֻ��������һ�Σ�ֱ�Ӵ�ӡ
				System.out.print(cur.value + " ");
			}
			cur = cur.right;
		}
		System.out.println();
	}
	
	public static void morrisInOrder(Node head) {// morris���������ӡ�������ڵ㣬��һ�������ڵ��ʱ���ӡ
		if (head == null){
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// ��������Ϊ��
				while (mostRight.right != null && mostRight.right != cur) {// �ҵ������������ҽڵ�
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {// ������ҽڵ���Һ���Ϊ�գ������ҽڵ���Һ���ָ��cur��cur������
					mostRight.right = cur;
					// System.out.print(cur.value + " ");// ���ҽڵ���Һ���Ϊ�գ���һ������cur
					cur = cur.left;
					continue;// ֱ����������ѭ�����жϵ�ǰcur���������Ƿ�Ϊ��
				} else {// ������ҽڵ���Һ��Ӳ�Ϊ�գ���ô����ָ��cur�ģ������ҽڵ���Һ���ָ��null,cur������
					System.out.print(cur.value + " ");
					mostRight.right = null;// �ڶ�������cur
				}
			}else {// cur������Ϊ�գ�curֻ��������һ�Σ�ֱ�Ӵ�ӡ
				System.out.print(cur.value + " ");
			}
			cur = cur.right;
		}
		System.out.println();
	}
	
	public static void morrisPos(Node head) {// morris���������ӡ�������ڵ㣬�ڶ�����������ڵ㣬�����ӡ���������ұ߽磬������ɺ󣬴�ӡ���������ұ߽硣
		if (head == null){
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// ��������Ϊ��
				while (mostRight.right != null && mostRight.right != cur) {// �ҵ������������ҽڵ�
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {// ������ҽڵ���Һ���Ϊ�գ������ҽڵ���Һ���ָ��cur��cur������
					mostRight.right = cur;
					// System.out.print(cur.value + " ");// ���ҽڵ���Һ���Ϊ�գ���һ������cur
					cur = cur.left;
					continue;// ֱ����������ѭ�����жϵ�ǰcur���������Ƿ�Ϊ��
				} else {// ������ҽڵ���Һ��Ӳ�Ϊ�գ���ô����ָ��cur�ģ������ҽڵ���Һ���ָ��null,cur������
					mostRight.right = null;// �ڶ�������cur
					pringEdge(cur.left);// �Ƚ����ҽڵ���Һ���ָ��null���⿪�ջ����ٴ�ӡ
				}
			}
			cur = cur.right;
		}
		pringEdge(head);
		System.out.println();
	}
	
private static void pringEdge(Node head) {
		Node tail = reverse(head);// �����ұ߽�
		Node cur = tail;
		while(cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		reverse(tail);// �ѵ������������
	}

private static Node reverse(Node head) {// ����������,���ұ߽統����������
	Node pre = null;
	Node next = null;
	Node cur = head;
	while(cur != null) {// next����ָ����һ����pre��������ǰָ��cur����������ǰ�ڵ�
		next = cur.right;
		cur.right = pre;
		pre = cur;
		cur = next;
	}
	return pre;// preָ��������һ���ǿյĽڵ�
}

/*	public static void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			System.out.print(cur1.value + " ");
			cur1 = cur1.right;
		}
		System.out.println();
	}*/
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.left = new Node(2);
		n1.right = new Node(3);
		n1.left.left = new Node(4);
		n1.left.right = new Node(5);
		n1.right.left = new Node(6);
		n1.right.right = new Node(7);
		
		morris(n1);
		morrisPre(n1);
		morrisInOrder(n1);
		morrisPos(n1);
	}
}
