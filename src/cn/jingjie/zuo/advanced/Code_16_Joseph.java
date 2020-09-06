package cn.jingjie.zuo.advanced;

// ���뻷�ε������head,������mɱ�ˣ�����һ���������Դ����ƣ�ֱ��ʣ��һ���ˡ�
// ����������������Ľڵ㣬������ڵ��Լ��γɵ��������������ڵ㶼ɾ��
public class Code_16_Joseph {
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int data) {
			value = data;
		}
	}
	
	// ģ�ⱨ���Ĺ��̣�Ϊmʱɱ���������ʣ�µ�����
	public static Node joseph1(Node head, int m) {
		if(head == null || m < 1) {
			return null;
		}
		
		// �ҵ�ѭ�������β�ڵ�
		Node last = head;
		while(last.next != head) {
			last = last.next;
		}
		
		int tmp = 0;
		// last��head��ǰ�ƶ�(����)��tmp=mʱ��ɱ���˽ڵ㣨�����������tmp��0��������ǰ�ơ���last��headʱ��������ֻʣһ���ڵ㣬���ء�
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
	
	// ��ʽ����
	public static Node joseph2(Node head, int m) {
		if(head == null || m < 1) {
			return null;
		}
		
		// ���㵥��������ĸ���
		Node cur = head.next;
		int num = 1;
		while(cur != head) {
			num++;
			cur = cur.next;
		}
		// ����������ˣ��ڵ㣩�ı��
		int liveNum = getLive(num, m);
		
		// �ҵ������Ľڵ�
		while(--liveNum > 0) {
			head = head.next;
		}
		
		// ���˽ڵ��γɵ���������
		head.next = head;
		return head;
	}

	private static int getLive(int num, int m) {
		if(num == 1) {
			return 1;
		}
		// �ɱ�Ŵ��±���Ƴ���
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
