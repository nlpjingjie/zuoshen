package cn.jingjie.zuo;

// 得到两个链表相交得第一个节点
public class code_23_FindFirstIntersectNode {
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int v){
			this.value = v;
		}
	}
	
	public static Node getIntersectNode(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoop(head1);
		Node loop2 = getLoop(head2);
		if(loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}else if(loop1 != null && loop2 != null) {
			return bothLoop(head1, head2, loop1, loop2);
		}else {
			return null;
		}
	}

	private static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
		Node h1 = head1;
		Node h2 = head2;
		// 三种情况，两个独立环，入环节点相同的公共环，入环节点不相同的公共环。
		if(loop1 != loop2) {
			Node l1 = loop1.next;
			while(l1 != loop1) {
				if(l1 == loop2) {
					return loop1;
				}
				l1 = l1.next;
			}
			return null;
		}else {
			int i = 0;
			while(h1 != loop1) {
				h1 = h1.next;
				i++;
			}
			while(h2 != loop1) {
				h2 = h2.next;
				i--;
			}
			h1 = i > 0? head1:head2;
			h2 = h1 == head1? head2:head1;
			i = Math.abs(i);
			while(i > 0) {
				h1 = h1.next;
				i--;
			}
			while(h1 != h2) {
				h1 = h1.next;
				h2 = h2.next;
			}
			return h1;
		}
	}

	private static Node noLoop(Node head1, Node head2) {
		// 两个无环链表相交的第一个节点,通过尾节点是否相等判断是否相交，通过链表长度找出相交的第一个节点
		Node h1 = head1;
		Node h2 = head2;
		int i = 0; // 两个链表的长度差值
		while(h1.next != null) {
			h1 = h1.next;
			i++;
		}
		while(h2.next != null) {
			h2 = h2.next;
			i--;
		}
		if(h1 != h2) {
			return null;
		}else { 
			h1 = i > 0 ? head1:head2; // 让h1指向较长的链表
			h2 = h1 == head1? head2:head1;
			i = Math.abs(i);
			while(i > 0) {
				h1 = h1.next;
				i--;
			}
			while(h1 != h2) {
				h1 = h1.next;
				h2 = h2.next;
			}
			return h1;
		}
	}

	// 得到有环链表的入环节点，没环返回null
	private static Node getLoop(Node head) {
		// 快速检查三个节点之内不存在环的情况
		if(head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node fast = head.next.next;
		Node slow = head.next;
		while(slow != fast) {
			if(fast.next == null || fast.next.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
				Node head1 = new Node(1);
				head1.next = new Node(2);
				head1.next.next = new Node(3);
				head1.next.next.next = new Node(4);
				head1.next.next.next.next = new Node(5);
				head1.next.next.next.next.next = new Node(6);
				head1.next.next.next.next.next.next = new Node(7);

				// 0->9->8->6->7->null
				Node head2 = new Node(0);
				head2.next = new Node(9);
				head2.next.next = new Node(8);
				head2.next.next.next = head1.next.next.next.next.next; // 8->6
				System.out.println(getIntersectNode(head1, head2).value);

				// 1->2->3->4->5->6->7->4...
				head1 = new Node(1);
				head1.next = new Node(2);
				head1.next.next = new Node(3);
				head1.next.next.next = new Node(4);
				head1.next.next.next.next = new Node(5);
				head1.next.next.next.next.next = new Node(6);
				head1.next.next.next.next.next.next = new Node(7);
				head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

				// 0->9->8->2...
				head2 = new Node(0);
				head2.next = new Node(9);
				head2.next.next = new Node(8);
				head2.next.next.next = head1.next; // 8->2
				System.out.println(getIntersectNode(head1, head2).value);

				// 0->9->8->6->4->5->6..
				head2 = new Node(0);
				head2.next = new Node(9);
				head2.next.next = new Node(8);
				head2.next.next.next = head1.next.next.next.next.next; // 8->6
				System.out.println(getIntersectNode(head1, head2).value);
	}
}
