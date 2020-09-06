package cn.jingjie.zuo.advanced;

// 输入环形单链表的head,报数到m杀人，从下一个继续，以此类推，直到剩下一个人。
// 返回最后生存下来的节点，且这个节点自己形成单向环形链表，其它节点都删掉
public class Code_16_Joseph {
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int data) {
			value = data;
		}
	}
	
	// 模拟报数的过程，为m时杀死返回最后剩下的链表
	public static Node joseph1(Node head, int m) {
		if(head == null || m < 1) {
			return null;
		}
		
		// 找到循环链表的尾节点
		Node last = head;
		while(last.next != head) {
			last = last.next;
		}
		
		int tmp = 0;
		// last和head向前移动(报数)，tmp=m时，杀死此节点（将其断连），tmp置0，继续向前推。当last等head时，链表中只剩一个节点，返回。
		while(head != last) {
			if(++tmp == m) {
				last.next = head.next;
				tmp = 0;
			}else {
				last = last.next;
			}
			head = last.next;
		}
		
		return head;
	}
	
	// 公式递推
	public static Node joseph2(Node head, int m) {
		if(head == null || m < 1) {
			return null;
		}
		
		// 计算单向环形链表的个数
		Node cur = head.next;
		int num = 1;
		while(cur != head) {
			num++;
			cur = cur.next;
		}
		// 获得最后存活的人（节点）的编号
		int liveNum = getLive(num, m);
		
		// 找到最后存活的节点
		while(--liveNum > 0) {
			head = head.next;
		}
		
		// 将此节点形成单向环形链表
		head.next = head;
		return head;
	}

	private static int getLive(int num, int m) {
		if(num == 1) {
			return 1;
		}
		// 旧编号从新编号推出来
		return (getLive(num-1, m) + m - 1)%num + 1;
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = head1;
		head1 = joseph1(head1, 3);
		System.out.println(head1.value);
		
		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(4);
		head2.next.next.next.next = new Node(5);
		head2.next.next.next.next.next = head2;
		head2 = joseph2(head2, 3);
		System.out.println(head2.value);

	}
}
