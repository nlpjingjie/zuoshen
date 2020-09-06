package cn.jingjie.zuo.advanced;

import java.util.Deque;
import java.util.LinkedList;


// 计算表达式的值如1+2*3-(3+4*1)+3/2
// addNum方法计算乘除，只保留数和加减，getNum计算结果
// 消除括号，括号内的公式计算出结果返回结果和右括号位置（遇到括号递归计算）
public class Code_12_ExpressionCompute {
	
	public static int getValue(String str) {
		return compute(str.toCharArray(), 0)[0];
	}
	
	public static int[] compute(char[] chs, int index) {
		Deque<String> que = new LinkedList<String>();
		// 收集数字
		int pre = 0;
		int[] subBra = new int[2];
		// 没遇到右括号之前都在计算范围内
		while(index < chs.length && chs[index] != ')') {
			if(chs[index] >= '0' && chs[index] <= '9') {
				pre = pre*10 + chs[index++]-'0';
			}else if(chs[index] != '(') {
				// 遇到了计算符号
				// addNum把之前的数据的乘除计算出来，只保留加减
				addNum(que, pre);
				// pre归0，准备收集下一个数据
				pre = 0;
				// 把符号加进来
				que.push(String.valueOf(chs[index++]));
			}else {
				// 遇到了左括号,递归计算括号中的内容,返回结果和右括号的位置的位置
				subBra = compute(chs, index + 1);
				pre = subBra[0];
				index = subBra[1] + 1;
			}
		}
		addNum(que, pre);
		// 计算加减的结果
		return new int[] {getNum(que), index};
	}

	// 问题：如果栈底最后一个字符串是"-",栈中剩下一个元素时，就会索引错误。所以用栈，存在这个问题，可以用双向队列从头部开始计算。
	// Exception in thread "main" java.lang.NumberFormatException: For input string: "-"
//	private static int getNum(Deque<String> stack) {
//		int res = 0;
//		while(!stack.isEmpty()) {
//			String later = stack.pop();
//			int l = Integer.valueOf(later);
//			// 如果只剩一个数字
//			if(stack.isEmpty()) {
//				res += l;
//			}else {
//				res += l;
//				String sign = stack.pop();
//				String cur = stack.pop();
//				int c = Integer.valueOf(cur);
//				res = sign.equals("+") ? c+res:c-res;
//			}
//		}
//		return res;
//	}
	
	private static int getNum(Deque<String> que) {
		boolean add = true;
		int res = 0;
		String cur = null;
		int tmp = 0;
		while(!que.isEmpty()) {
			cur = que.pollFirst();
			if(cur.equals("+")) {
				add = true;
			}else if(cur.equals("-")) {
				add = false;
			}else {
				tmp = Integer.valueOf(cur);
				res = add == true ? (res + tmp):(res - tmp);
			}
		}
		return res;
	}

	private static void addNum(Deque<String> stack, int next) {
		if(!stack.isEmpty()) {
			String cur = stack.pop();
			if(cur.equals("+") || cur.equals("-")) {
				stack.offerLast(cur);
			}else {
				// 乘除的情况
				int p = Integer.valueOf(stack.pollLast());
				next = cur.equals("*") ? (p*next):(p/next);
			}
		}
		// 包含栈为空的情况
		stack.offerLast(String.valueOf(next));
	}
	
	public static void main(String[] args) {
		String exp = "48*((70-65)-43)+8*1";
		System.out.println(getValue(exp));

		exp = "4*(6+78)+53-9/2+45*8";
		System.out.println(getValue(exp));

		exp = "10-5*3";
		System.out.println(getValue(exp));

		exp = "-3*4";
		System.out.println(getValue(exp));

		exp = "3+1*4";
//		exp = "33333436";
		System.out.println(getValue(exp));
		
		exp = "-9/2+2";
		System.out.println(getValue(exp));
	}

}
