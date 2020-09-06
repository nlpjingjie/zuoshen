package cn.jingjie.zuo;

import java.util.Deque;
import java.util.LinkedList;

public class code_20_Plalindrome { // 判断单链表是否为回文结构
	
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int v) {
			this.value = v;
		}
	}
	
	// 使用栈做辅助,时间复杂度N
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
	
	// 使用栈辅助，空间复杂度减少到N/2,使用快慢指针，慢指针走到一半的位置，将包括慢指针及剩余的节点压栈，
	// 然逐个弹出栈与单链表头节点开始比较，直到栈空。
	public static Boolean isPlalindrome2(Node head) {
		if(head == null || head.next  == null) {
			return true;
		}
		// 保证从慢指针压入的是对称的
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
	
	// 使用快慢指针，然后反转慢指针之后的链表，从两头向中间遍历比较，最后再恢复单链表，空间复杂度O(1)
	public static boolean isPlalindrome3(Node head) {
		if(head == null || head.next == null) {
			return true;
		}
		// 保证慢指针走到中间位置，偶数个节点的前一个中间位置
		Node fast = head;
		Node slow = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// 反转慢指针之后的列表
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
		
		// 无论是否回文，都要恢复链表
		boolean res = true;
		while(head != null && fast != null) {
			if(head.value != fast.value) {
				res = false;
				break;
			}
			head = head.next;
			fast = fast.next;
		}
		// 恢复链表
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
