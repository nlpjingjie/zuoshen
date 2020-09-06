package cn.jingjie.zuo;

import java.util.Deque;
import java.util.LinkedList;

// 反转栈中的元素，不能借助额外的数据结构，用递归的方式。大思路是拿到栈底元素，同时删掉它，反转剩余元素，然后将此栈底元素压栈,变成栈顶。
public class ReverseStack {
	public static void reverse(Deque<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		Integer tmp = getLast(stack);
		reverse(stack);
		stack.push(tmp);
	}

	// 拿栈底元素。当前拿到的不是栈底元素，拿栈中剩下的元素中的栈底元素，然后把此元素压栈恢复。
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
