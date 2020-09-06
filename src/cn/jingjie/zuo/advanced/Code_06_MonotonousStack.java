package cn.jingjie.zuo.advanced;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



// 单调栈就是栈内元素都是严格单调递增或单调递减的。
// 问题：在一个数组中，每一个位置的num，找到左边离num近的>num的值，和右边离num近的>num的值。要求时间复杂度O(n)。
public class Code_06_MonotonousStack {
	// 用来存储弹出的处理结果
	public static class Num{
		public int left;
		public int right;
		public int value;
		
		public Num(int data) {
			value = data;
		}
	}
	
	// 用来解决数据大小重复的问题，大小相等的数据压在一起
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
		// 单调递减栈
		Deque<Node> stack = new LinkedList<>();
		for(int i=0; i < arr.length; i++) {
			// 如果栈不为空，并且当前元素大于栈顶元素，进行处理
			while(!stack.isEmpty() && arr[stack.peek().index] < arr[i]) {
				Node curNode = stack.pop();
				// 处理重复数据
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
		
		// 遍历完栈中还有元素
		while(!stack.isEmpty()) {
			Node curNode = stack.pop();
			// 处理重复数据
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
			System.out.println(num.value + "左边" + num.left + "右边" + num.right);
		}
	}
}
