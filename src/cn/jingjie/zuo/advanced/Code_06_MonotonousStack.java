package cn.jingjie.zuo.advanced;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



// ����ջ����ջ��Ԫ�ض����ϸ񵥵������򵥵��ݼ��ġ�
// ���⣺��һ�������У�ÿһ��λ�õ�num���ҵ������num����>num��ֵ�����ұ���num����>num��ֵ��Ҫ��ʱ�临�Ӷ�O(n)��
public class Code_06_MonotonousStack {
	// �����洢�����Ĵ�����
	public static class Num{
		public int left;
		public int right;
		public int value;
		
		public Num(int data) {
			value = data;
		}
	}
	
	// ����������ݴ�С�ظ������⣬��С��ȵ�����ѹ��һ��
	public static class Node{
		public int count;
		public int index;
		
		public Node(int i) {
			index = i;
			count = 1;
		}
	}
	
	public static List<Num> monotonousStack(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		List<Num> res = new ArrayList<>();
		// �����ݼ�ջ
		Deque<Node> stack = new LinkedList<>();
		for(int i=0; i < arr.length; i++) {
			// ���ջ��Ϊ�գ����ҵ�ǰԪ�ش���ջ��Ԫ�أ����д���
			while(!stack.isEmpty() && arr[stack.peek().index] < arr[i]) {
				Node curNode = stack.pop();
				// �����ظ�����
				for(int j=0; j < curNode.count; j++) {
					Num num = new Num(arr[curNode.index]);
					num.right = arr[i];
					num.left = stack.isEmpty() ? -1:arr[stack.peek().index];
					res.add(num);
				}
			}
			if(!stack.isEmpty() && arr[stack.peek().index] == arr[i]) {
				stack.peek().count++;
				continue;
			}
			stack.push(new Node(i));
		}
		
		// ������ջ�л���Ԫ��
		while(!stack.isEmpty()) {
			Node curNode = stack.pop();
			// �����ظ�����
			for(int j=0; j < curNode.count; j++) {
				Num num = new Num(arr[curNode.index]);
				num.right = -1;
				num.left = stack.isEmpty() ? -1:arr[stack.peek().index];
				res.add(num);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 7, 5, 4, 7, 6, 4, 2, 3, 1, 3, 2, 3, 4, 5, 7, 8};
		List<Num> rList = monotonousStack(arr);
		for(Num num:rList) {
			System.out.println(num.value + "���" + num.left + "�ұ�" + num.right);
		}
	}
}
