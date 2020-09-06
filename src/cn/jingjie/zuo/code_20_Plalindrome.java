package cn.jingjie.zuo;

import java.util.Deque;
import java.util.LinkedList;

public class code_20_Plalindrome { // �жϵ������Ƿ�Ϊ���Ľṹ
	
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int v) {
			this.value = v;
		}
	}
	
	// ʹ��ջ������,ʱ�临�Ӷ�N
	public static boolean isPlalindrome(Node head) {
		if(head == null || head.next  == null) {
			return true;
		}
		Deque<Node> helpStack = new LinkedList<>();
		Node cur = head;
		while(cur != null) {
			helpStack.push(cur);
			cur = cur.next;
		}
		while(head != null) {
			if(head.value != helpStack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	// ʹ��ջ�������ռ临�Ӷȼ��ٵ�N/2,ʹ�ÿ���ָ�룬��ָ���ߵ�һ���λ�ã���������ָ�뼰ʣ��Ľڵ�ѹջ��
	// Ȼ�������ջ�뵥����ͷ�ڵ㿪ʼ�Ƚϣ�ֱ��ջ�ա�
	public static Boolean isPlalindrome2(Node head) {
		if(head == null || head.next  == null) {
			return true;
		}
		// ��֤����ָ��ѹ����ǶԳƵ�
		Node fast = head;
		Node slow = head.next;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Deque<Node> helpStack = new LinkedList<>();
		while(slow != null) {
			helpStack.push(slow);
			slow = slow.next;
		}
		while(!helpStack.isEmpty()) {
			if(head.value != helpStack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	// ʹ�ÿ���ָ�룬Ȼ��ת��ָ��֮�����������ͷ���м�����Ƚϣ�����ٻָ��������ռ临�Ӷ�O(1)
	public static boolean isPlalindrome3(Node head) {
		if(head == null || head.next == null) {
			return true;
		}
		// ��֤��ָ���ߵ��м�λ�ã�ż�����ڵ��ǰһ���м�λ��
		Node fast = head;
		Node slow = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// ��ת��ָ��֮����б�
		Node next = null;
		fast = next;
		while(slow != null) {
			next = slow.next;
			slow.next = fast;
			fast = slow;
			slow = next;
		}
		
//		Node hh = fast;
//		while(hh != null) {
//			System.out.print(hh.value + " ");
//			hh = hh.next;
//		}
		
		// �����Ƿ���ģ���Ҫ�ָ�����
		boolean res = true;
		while(head != null && fast != null) {
			if(head.value != fast.value) {
				res = false;
				break;
			}
			head = head.next;
			fast = fast.next;
		}
		// �ָ�����
		Node nextf = null;
		fast = nextf;
		while(slow != null) {
			nextf = slow.next;
			slow.next = fast;
			fast = slow;
			slow = nextf;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(1);
		n1.next.next.next = new Node(2);
		n1.next.next.next.next = new Node(1);
		System.out.println(isPlalindrome(n1));
		System.out.println(isPlalindrome2(n1));
		System.out.println(isPlalindrome3(n1));
	}
}
