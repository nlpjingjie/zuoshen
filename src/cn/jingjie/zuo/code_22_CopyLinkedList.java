package cn.jingjie.zuo;

import java.util.HashMap;


public class code_22_CopyLinkedList {
	// copy linkedlist with special attribute
	public static class Node{
		public int value;
		public Node next;
		public Node rand;
		
		public Node(int v) {
			this.value = v;
		}
	}
	
	public static Node copyLinkedList(Node head) {
		Node cur = head;
		HashMap<Node, Node> helpHM = new HashMap<>();
		while(cur != null) { // ԭ����ڵ�Ϳ����ڵ��Ӧ
			helpHM.put(cur, copyNode(cur));
			cur = cur.next;
		}
		cur = head;
		while(cur != null) {
			helpHM.get(cur).next = helpHM.get(cur.next);
			helpHM.get(cur).rand = helpHM.get(cur.rand);
			cur = cur.next;
		}
		return helpHM.get(head);
	}
	
	public static Node copyNode(Node n) {
		Node n1 = new Node(n.value);
		return n1;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(3); // �ڵ��ֵ3
		n1.next = new Node(5);
		n1.next.next = new Node(6);
		n1.next.next.next = new Node(2);
		n1.rand = n1.next.next; // 6
		n1.next.rand = n1.next.next.next; //2
		
		Node n2 = copyLinkedList(n1);
		Node n3 = n2;
		while(n3 != null) {
			System.out.print(n3.value + " ");
			n3 = n3.next;
		}
		n3 = n2;
		while(n3 != null) {
			if(n3.rand != null) {
				System.out.print(n3.rand.value + " ");
			}
			n3 = n3.next;
		}
	}
}
