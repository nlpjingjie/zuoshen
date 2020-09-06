package cn.jingjie.zuo.advanced;

import java.util.Arrays;

// �ж�һ��������һ�������������ṹ��ֵ��ȫ��ͬ�����Ƚ����������л����мǼ��Ϸָ���Ϳսڵ��ǣ�Ȼ����KMP�ķ�����
public class Code_01_KMP_ContainsAnotherTree {
	// ���
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static String serialByPre(Node head) {
		// ��!��Ϊ�˷����л�ʹ�õģ����ﲻ��Ҫ!��ֻҪ�ܹ����汣֤���Ľṹ����
		if(head == null) {
			return "#";
		}
		String reString = head.value + "";
		reString += serialByPre(head.left);
		reString += serialByPre(head.right);
		return reString;
	}
	
	public static boolean kmp(char[] a, char[] b) {
		boolean flag = false;
		if(a == null || b == null || a.length < b.length) {
			return flag;
		}
		
		int[] next = getNext(b);
		System.out.println(Arrays.toString(next));
		int j = 0;
		for(int i=0; i < a.length; i++) {	
			if(b[j] != a[i]) {
				j = next[j];
				// j����-1����Ҫ����i,��Ϊ��ʱ�Ѿ��ȽϹ�j=0��iλ�ñȽϹ����Ҳ���ȡ�
				i = j == -1 ? i:i-1;
				j = j == -1 ? 0:j;  
//				continue;
			}else {
				j++;
				if(j == b.length) {
//				flag = true;
				return true;
				}
			}
		}
		return flag;
	}

	private static int[] getNext(char[] b) {
		if(b.length == 1) {
			return new int[] {-1};
		}
		if(b.length == 2) {
			return new int[] {-1, 0};
		}
		int[] next = new int[b.length];
		next[0] = -1;
		next[1] = 0;
		for(int i = 2; i < b.length; i++) {
			int preIndex = next[i-1];
			
			while(b[preIndex] != b[i-1]) {
				// ����next��ǰ�ҿ�����ȵ�λ��
				preIndex = next[preIndex];
				if(preIndex == -1) {
					break;
				}
			}
			// preIndex == -1 ˵��û����ȵģ�������Ϊ��Ƚ���preIndexû�ص�-1
//			if(preIndex != -1) {
//				next[i] = preIndex + 1;
//			}else {
//				next[i] = 0;
//			}
			
			next[i] = preIndex == -1 ? 0:preIndex+1;
		}
		return next;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(2);
		n1.left = new Node(3);
		n1.right = new Node(4);
		n1.left.left = new Node(5);
		n1.left.right = new Node(3);
		n1.right.left = new Node(7);
		n1.right.right = new Node(8);
		
		Node n2 = new Node(3);
		n2.left = new Node(5);
		n2.right = new Node(3);
		n2.right.left = new Node(5);
		
		Node n3 = new Node(3);
		n3.left = new Node(5);
		n3.right = new Node(3);
		
		String serial1 = serialByPre(n1);
		String serial2 = serialByPre(n2);
		String serial3 = serialByPre(n3);
		
		System.out.println(serial1);
		System.out.println(serial2);
		System.out.println(serial3);
		
		char[] ch1 = serial1.toCharArray();
		char[] ch2 = serial2.toCharArray();
		char[] ch3 = serial3.toCharArray();
		
		System.out.println(kmp(ch1, ch2));
		System.out.println(kmp(ch1, ch3));
	}
}
