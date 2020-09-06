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
			if (mostRight != null) {// 左子树不为空
				while (mostRight.right != null && mostRight.right != cur) {// 找到左子树的最右节点
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {// 如果最右节点的右孩子为空，让最右节点的右孩子指向cur，cur向左走
					mostRight.right = cur;
					cur = cur.left;
					continue;// 直接跳出本次循环，判断当前cur的左子树是否为空
				} else {// 如果最右节点的右孩子不为空，那么它是指向cur的，让最右节点的右孩子指回null,cur向右走
					mostRight.right = null;
				}
			}
			System.out.print(cur.value + " ");// 第一次碰到叶子节点和第二次碰到非叶子节点，直接打印就是中序
			cur = cur.right;
		}
		System.out.println();
	}
	
	public static void morrisPre(Node head) {// morris先序遍历打印二叉树节点，第一次碰到节点的时候打印
		if (head == null){
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// 左子树不为空
				while (mostRight.right != null && mostRight.right != cur) {// 找到左子树的最右节点
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {// 如果最右节点的右孩子为空，让最右节点的右孩子指向cur，cur向左走
					mostRight.right = cur;
					System.out.print(cur.value + " ");// 最右节点的右孩子为空，第一次碰到cur
					cur = cur.left;
					continue;// 直接跳出本次循环，判断当前cur的左子树是否为空
				} else {// 如果最右节点的右孩子不为空，那么它是指向cur的，让最右节点的右孩子指回null,cur向右走
					mostRight.right = null;// 第二次碰到cur
				}
			}else {// cur的左孩子为空，cur只能碰到这一次，直接打印
				System.out.print(cur.value + " ");
			}
			cur = cur.right;
		}
		System.out.println();
	}
	
	public static void morrisInOrder(Node head) {// morris中序遍历打印二叉树节点，第一次碰到节点的时候打印
		if (head == null){
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// 左子树不为空
				while (mostRight.right != null && mostRight.right != cur) {// 找到左子树的最右节点
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {// 如果最右节点的右孩子为空，让最右节点的右孩子指向cur，cur向左走
					mostRight.right = cur;
					// System.out.print(cur.value + " ");// 最右节点的右孩子为空，第一次碰到cur
					cur = cur.left;
					continue;// 直接跳出本次循环，判断当前cur的左子树是否为空
				} else {// 如果最右节点的右孩子不为空，那么它是指向cur的，让最右节点的右孩子指回null,cur向右走
					System.out.print(cur.value + " ");
					mostRight.right = null;// 第二次碰到cur
				}
			}else {// cur的左孩子为空，cur只能碰到这一次，直接打印
				System.out.print(cur.value + " ");
			}
			cur = cur.right;
		}
		System.out.println();
	}
	
	public static void morrisPos(Node head) {// morris后序遍历打印二叉树节点，第二次来到这个节点，逆序打印左子树的右边界，遍历完成后，打印整棵树的右边界。
		if (head == null){
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {// 左子树不为空
				while (mostRight.right != null && mostRight.right != cur) {// 找到左子树的最右节点
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {// 如果最右节点的右孩子为空，让最右节点的右孩子指向cur，cur向左走
					mostRight.right = cur;
					// System.out.print(cur.value + " ");// 最右节点的右孩子为空，第一次碰到cur
					cur = cur.left;
					continue;// 直接跳出本次循环，判断当前cur的左子树是否为空
				} else {// 如果最右节点的右孩子不为空，那么它是指向cur的，让最右节点的右孩子指回null,cur向右走
					mostRight.right = null;// 第二次碰到cur
					pringEdge(cur.left);// 先将最右节点的右孩子指向null，解开闭环，再打印
				}
			}
			cur = cur.right;
		}
		pringEdge(head);
		System.out.println();
	}
	
private static void pringEdge(Node head) {
		Node tail = reverse(head);// 逆序右边界
		Node cur = tail;
		while(cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		reverse(tail);// 把单链表调整回来
	}

private static Node reverse(Node head) {// 单链表逆序,把右边界当作单链表处理
	Node pre = null;
	Node next = null;
	Node cur = head;
	while(cur != null) {// next用来指向下一个，pre用来被当前指向，cur用来遍历当前节点
		next = cur.right;
		cur.right = pre;
		pre = cur;
		cur = next;
	}
	return pre;// pre指向的是最后一个非空的节点
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
