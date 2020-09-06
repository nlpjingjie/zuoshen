package cn.jingjie.zuo.advanced;

import java.util.Arrays;

// 判断一个树是另一个树的子树（结构和值完全相同），先将两棵树序列化，切记加上分割符和空节点标记，然后用KMP的方法。
public class Code_01_KMP_ContainsAnotherTree {
	// 完成
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static String serialByPre(Node head) {
		// 加!是为了反序列化使用的，这里不需要!，只要能够保存保证树的结构就行
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
				// j等于-1不需要回退i,因为此时已经比较过j=0与i位置比较过，且不相等。
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
				// 根据next向前找可能相等的位置
				preIndex = next[preIndex];
				if(preIndex == -1) {
					break;
				}
			}
			// preIndex == -1 说明没有相等的，否则因为相等结束preIndex没回到-1
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
