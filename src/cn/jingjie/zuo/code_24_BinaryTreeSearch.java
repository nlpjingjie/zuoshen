package cn.jingjie.zuo;

import java.util.Deque;
import java.util.LinkedList;

public class code_24_BinaryTreeSearch {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			this.value = v;
		}
	}
	
	// 递归方式先序、中序、后序遍历二叉树
	public static void binaryTreeSearchRecur1(Node head) {// 先序遍历
		if(head == null) {
			return;
		}
		System.out.print(head.value + " ");
		binaryTreeSearchRecur1(head.left);
		binaryTreeSearchRecur1(head.right);
	}
	
	public static void binaryTreeSearchRecur2(Node head) {// 中序遍历
		if(head == null) {
			return;
		}
		binaryTreeSearchRecur2(head.left);
		System.out.print(head.value + " ");
		binaryTreeSearchRecur2(head.right);
	}
	
	public static void binaryTreeSearchRecur3(Node head) {// 后序遍历
		if(head == null) {
			return;
		}
		binaryTreeSearchRecur3(head.left);
		binaryTreeSearchRecur3(head.right);
		System.out.print(head.value + " ");
	}
	
	// 非递归方式先序、中序、后序遍历二叉树
	public static void binaryTreeSearchNotRecur1(Node head) {// 先序遍历
		// 利用栈，压中弹先打印右左。
		if(head != null) {
			Deque<Node> stack = new LinkedList<>();
			stack.push(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if(head.right != null) {
					stack.push(head.right);
				}
				if(head.left != null) {
					stack.push(head.left);
				}
			}
		}
	}
	
	public static void binaryTreeSearchNotRecur2(Node head) {// 中序遍历
		// 左压到低，弹中打印，再压右
		if(head != null) {
			Deque<Node> stack = new LinkedList<>();
			while(!stack.isEmpty()|| head != null) {
				if(head != null) {
					stack.push(head);
					head = head.left;
				}else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
	}
	
	public static void binaryTreeSearchNotRecur3(Node head) {// 后序遍历
		// 修改先序遍历，压中左右，弹中右左，再压中右左-多使用一个辅助栈用来存储逆序的后序遍历，最后打印左右中。
		if(head != null) {
			Deque<Node> stack1 = new LinkedList<>();
			Deque<Node> stack2 = new LinkedList<>();
			stack1.push(head);
			while(!stack1.isEmpty()) {
				head = stack1.pop();
				stack2.push(head);
				if(head.left != null) {
					stack1.push(head.left);
				}
				if(head.right != null) {
					stack1.push(head.right);
				}
			}
			// 打印后序遍历的结果
			while(!stack2.isEmpty()) {
				head = stack2.pop();
				System.out.print(head.value + " ");
			}
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
		binaryTreeSearchRecur1(n1);
		System.out.print("   ");
		binaryTreeSearchNotRecur1(n1);
		System.out.println();
		binaryTreeSearchRecur2(n1);
		System.out.print("   ");
		binaryTreeSearchNotRecur2(n1);
		System.out.println();
		binaryTreeSearchRecur3(n1);
		System.out.print("   ");
		binaryTreeSearchNotRecur3(n1);
	}
}
