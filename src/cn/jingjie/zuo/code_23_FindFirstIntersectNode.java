package cn.jingjie.zuo;

// �õ����������ཻ�õ�һ���ڵ�
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
		// ����������������������뻷�ڵ���ͬ�Ĺ��������뻷�ڵ㲻��ͬ�Ĺ�������
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
		// �����޻������ཻ�ĵ�һ���ڵ�,ͨ��β�ڵ��Ƿ�����ж��Ƿ��ཻ��ͨ���������ҳ��ཻ�ĵ�һ���ڵ�
		Node h1 = head1;
		Node h2 = head2;
		int i = 0; // ��������ĳ��Ȳ�ֵ
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
			h1 = i > 0 ? head1:head2; // ��h1ָ��ϳ�������
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

	// �õ��л�������뻷�ڵ㣬û������null
	private static Node getLoop(Node head) {
		// ���ټ�������ڵ�֮�ڲ����ڻ������
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
