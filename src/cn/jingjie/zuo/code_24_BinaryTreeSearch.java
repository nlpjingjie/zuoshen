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
	
	// �ݹ鷽ʽ�������򡢺������������
	public static void binaryTreeSearchRecur1(Node head) {// �������
		if(head == null) {
			return;
		}
		System.out.print(head.value + " ");
		binaryTreeSearchRecur1(head.left);
		binaryTreeSearchRecur1(head.right);
	}
	
	public static void binaryTreeSearchRecur2(Node head) {// �������
		if(head == null) {
			return;
		}
		binaryTreeSearchRecur2(head.left);
		System.out.print(head.value + " ");
		binaryTreeSearchRecur2(head.right);
	}
	
	public static void binaryTreeSearchRecur3(Node head) {// �������
		if(head == null) {
			return;
		}
		binaryTreeSearchRecur3(head.left);
		binaryTreeSearchRecur3(head.right);
		System.out.print(head.value + " ");
	}
	
	// �ǵݹ鷽ʽ�������򡢺������������
	public static void binaryTreeSearchNotRecur1(Node head) {// �������
		// ����ջ��ѹ�е��ȴ�ӡ����
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
	
	public static void binaryTreeSearchNotRecur2(Node head) {// �������
		// ��ѹ���ͣ����д�ӡ����ѹ��
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
	
	public static void binaryTreeSearchNotRecur3(Node head) {// �������
		// �޸����������ѹ�����ң�����������ѹ������-��ʹ��һ������ջ�����洢����ĺ������������ӡ�����С�
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
			// ��ӡ��������Ľ��
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
