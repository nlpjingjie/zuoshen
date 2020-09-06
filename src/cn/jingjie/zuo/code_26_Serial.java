package cn.jingjie.zuo;


import java.util.LinkedList;
import java.util.Queue;


public class code_26_Serial {// 序列化(永久化)树结构
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	public static String serialByPre(Node head) {// 先序遍历序列化树
		if(head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	
	public static String serialByLevel(Node head) {// 层序遍历序列化树
		if(head == null) {
			return "#!";
		}
		Queue<Node> q = new LinkedList<>();
		String res = head.value + "!";
		q.offer(head);
		while(!q.isEmpty()) {
			head = q.poll();
			if(head.left != null) {
				res += head.left.value + "!";
				q.offer(head.left);
			}else {
				res += "#!";
			}
			if(head.right != null) {
				res += head.right.value + "!";
				q.offer(head.right);
			}else {
				res += "#!";
			}
		}
		return res;
	}
	
	public static Node deSerialByLevel(String strLevel) {// 层序遍历反序列化树
		Queue<Node> q = new LinkedList<>();
		String[] values = strLevel.split("!");
		int index = 0;
		Node head = generateNodeByStr(values[index++]);
		q.offer(head);
		Node node = null;
		while(!q.isEmpty()) {
			node = q.poll();
			node.left = generateNodeByStr(values[index++]);
			node.right = generateNodeByStr(values[index++]);
			if(node.left != null) {
				q.offer(node.left);
			}
			if(node.right != null) {
				q.offer(node.right);
			}
		}
		return head;
	}
	
	private static Node generateNodeByStr(String s) {
		if(s.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(s));
	}

	public static Node deSerialByPre(String preStr) {
		String[] values = preStr.split("!");
		Queue<String> q = new LinkedList<>();
		for(int i = 0; i < values.length; i++) {
			q.offer(values[i]);
		}
		return deSerial(q);
	}
	
	private static Node deSerial(Queue<String> q) {
		String value = q.poll();
		if(value.equals("#")) {
			return null;
		}
		Node n = new Node(Integer.valueOf(value));
		n.left = deSerial(q);
		n.right = deSerial(q);
		return n;
	}


	public static void main(String[] args) {
//		Node n1 = new Node(1);
//		n1.left = new Node(2);
//		n1.right = new Node(3);
//		n1.left.left = new Node(4);
//		n1.left.right = new Node(5);
//		n1.right.left = new Node(6);
//		n1.right.right = new Node(7);
		
		Node n1 = new Node(2);
		n1.left = new Node(3);
		n1.right = new Node(4);
		n1.left.left = new Node(5);
		n1.left.right = new Node(6);
		n1.right.left = new Node(7);
		n1.right.right = new Node(8);
		
		String r = serialByPre(n1);
		System.out.print(r);
		System.out.println();
		
//		Node n2 = deSerialByPre(r);
//		System.out.print(n2.left.left.value);
//		System.out.println();
//		
//		String r1 = serialByLevel(n1);
//		System.out.print(r1);
//		System.out.println();
//		
//		Node n3 = deSerialByLevel(r1);
//		System.out.print(n3.left.left.value);
	}
}
