package cn.jingjie.zuo;

public class code_21_SmallerEqualBigger {
	
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int v) {
			this.value = v;
		}
	}
	
	public static Node listPartition1(Node head, int p) {
		if(head == null && head.next==null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while(cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] helpArr = new Node[i];
		i = 0;
		cur = head;
		// 将链表的节点放到一个数组中
		for(int j=0; j < helpArr.length; j++) {
			helpArr[j] = cur;
			cur = cur.next;
		}
		// 调整数组，荷兰国旗问题
		partition(helpArr, p);
		// 根据数组将节点串成链表
		for(i=1; i< helpArr.length; i++) {
			helpArr[i-1].next = helpArr[i];
		}
		// 最后这个节点要指向空，否则就会形成有环链表
		helpArr[i-1].next = null;
		return helpArr[0];
	}

	// 空间复杂度为O(1)的方法
	public static Node listPartition2(Node head, int p) {
		Node sH = null; // smaller head
		Node sT = null;
		Node eH = null; // equal head
		Node eT = null;
		Node bH = null; // bigger head
		Node bT = null;
		Node next = null; // save next Node
		while(head != null) {
			// 将遍历到的节点，从单链表中打开，置成独立节点,才能保证重新将节点串成单链表，否则不知道在哪里就闭环啦
			next = head.next;
			head.next = null;
			
			if(head.value < p) {
				if(sH == null) {
					sH = head;
					sT = head;
				}else {
					sT.next = head;
					sT = sT.next;
				}
			}else if(head.value > p) {
				if(bH == null) {
					bH = head;
					bT = head;
				}else {
					bT.next = head;
					bT = bT.next;
				}
			}else {
				if(eH == null) {
					eH = head;
					eT = head;
				}else {
					eT.next = head;
					eT = eT.next;
				}
			}
			head = next;
		}
		// 连接sall、equal链表
		if(sH != null) {
			sT.next = eH;
			eT = eT == null ? sT:eT;
		}
		if(eT != null) {
			eT.next = bH;
		}
		return sH != null? sH:eH != null ? eH:bH;
	} 
	
	private static void partition(Node[] helpArr, int p) {
		int less = -1;
		int more = helpArr.length;
		int cur = 0;
		while(cur < more) {
			if(helpArr[cur].value < p) {
				swap(helpArr, ++less, cur++);
			}else if(helpArr[cur].value > p) {
				swap(helpArr, --more, cur);
			}else {
				cur++;
			}
		}
	}

	private static void swap(Node[] helpArr, int i, int j) {
		Node tmp = helpArr[i];
		helpArr[i] = helpArr[j];
		helpArr[j] = tmp;
	}

	public static void main(String[] args) {
		Node n1 = new Node(3);
		n1.next = new Node(5);
		n1.next.next = new Node(6);
		n1.next.next.next = new Node(2);
		
//		Node r = listPartition1(n1, 2);
//		while(r != null) {
//			System.out.print(r.value + " ");
//			r = r.next;
//		}
//		System.out.println();
//		System.out.println("**********");
		
		Node r1 = listPartition2(n1, 2);
		while(r1 != null) {
			System.out.print(r1.value + " ");
			r1 = r1.next;
		}
	}

}
