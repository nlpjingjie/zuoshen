package cn.jingjie.zuo;

import java.util.Deque;
import java.util.LinkedList;

// ��תջ�е�Ԫ�أ����ܽ�����������ݽṹ���õݹ�ķ�ʽ����˼·���õ�ջ��Ԫ�أ�ͬʱɾ��������תʣ��Ԫ�أ�Ȼ�󽫴�ջ��Ԫ��ѹջ,���ջ����
public class ReverseStack {
	public static void reverse(Deque<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		Integer tmp = getLast(stack);
		reverse(stack);
		stack.push(tmp);
	}

	// ��ջ��Ԫ�ء���ǰ�õ��Ĳ���ջ��Ԫ�أ���ջ��ʣ�µ�Ԫ���е�ջ��Ԫ�أ�Ȼ��Ѵ�Ԫ��ѹջ�ָ���
	private static Integer getLast(Deque<Integer> stack) {
		Integer result = stack.pop();
		if(stack.isEmpty()) {
			return result;
		}else {
			Integer last = getLast(stack);
			stack.push(result);
			return last;
		}
	}
	
	public static void main(String[] args) {
		Deque<Integer> stack = new LinkedList<>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		reverse(stack);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
