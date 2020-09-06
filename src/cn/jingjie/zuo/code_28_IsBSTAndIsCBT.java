package cn.jingjie.zuo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class code_28_IsBSTAndIsCBT {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static boolean isBST(Node head) {// 是否是二叉搜索树，改写morris中序遍历
		if(head == null) {
			return true;
		}
		boolean res = true;
		Node pre = null;
		Node cur = head;
		Node mostRight = null;
		while(cur != null) {
			mostRight = cur.left;
			if(mostRight != null) {
				while(mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;
				}
				if(mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				}else {
					mostRight.right = null;
				}
			}
			if(pre != null && pre.value > cur.value) {
				res = false;
				//return false;// 直接返回就会遍历中断，cur.right的指向会改变二叉树
			}
			// System.out.print(cur.value + ' ');
			pre = cur;
			cur = cur.right;
		}
		return res;
	}
	
/*	public static boolean isBST(Node head) {// 左神程序
		if (head == null) {
			return true;
		}
		boolean res = true;// res变量的必要性，保存判断结果，顺利遍历完整颗树，而不至于改变二叉树。
		Node pre = null;
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
			if (pre != null && pre.value > cur1.value) {
				res = false;
			}
			pre = cur1;
			cur1 = cur1.right;
		}
		return res;
	}*/
	
	public static boolean isBST2(Node head) {// 是否是二叉搜索树，改写非递归中序遍历
		if(head == null) {
			return true;
		}
		Node cur = head;
		Node pre = null;
		Deque<Node> stack = new LinkedList<>();
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}else {
				cur = stack.pop();
				if(pre != null && pre.value > cur.value) {
					return false;
				}
				pre = cur;
				// System.out.print(cur.value + ' ');
				cur = cur.right;
			}
		}
		return true;
	}
	
	public static boolean isCBT(Node head) {// 是否是完全二叉树
		if(head == null) {
			return true;
		}
		boolean leaf = false;// 标志进入叶子节点
		Queue<Node> q = new LinkedList<>();
		q.offer(head);
		while(!q.isEmpty()) {
			head = q.poll();
			System.out.print(head.value + " ");
			if(leaf && (head.left != null || head.right != null) || (head.left == null && head.right != null)) {
				return false;// 进入叶子节点和非叶子节点失败的情况
			}
			if(head.left != null) {
				q.offer(head.left);
			}
			if(head.right != null) {
				q.offer(head.right);
			}else {
				leaf = true;// 右孩子为空，进入子节点判断
			}
		}
		System.out.println();
		return true;
	}
	
	/*public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			System.out.println(head.value + " ");
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}*/
	
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
		n2.right.right = new Node(7);
		
		System.out.println(isBST(n1));
		System.out.println(isBST(n2));
		System.out.println(isBST2(n1));
		System.out.println(isBST2(n2));
		
		System.out.println(isCBT(n1));
		System.out.println(isCBT(n2));
	}
}
