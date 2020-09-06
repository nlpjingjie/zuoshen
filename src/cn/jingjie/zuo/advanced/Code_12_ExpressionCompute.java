package cn.jingjie.zuo.advanced;

import java.util.Deque;
import java.util.LinkedList;


// ������ʽ��ֵ��1+2*3-(3+4*1)+3/2
// addNum��������˳���ֻ�������ͼӼ���getNum������
// �������ţ������ڵĹ�ʽ�����������ؽ����������λ�ã��������ŵݹ���㣩
public class Code_12_ExpressionCompute {
	
	public static int getValue(String str) {
		return compute(str.toCharArray(), 0)[0];
	}
	
	public static int[] compute(char[] chs, int index) {
		Deque<String> que = new LinkedList<String>();
		// �ռ�����
		int pre = 0;
		int[] subBra = new int[2];
		// û����������֮ǰ���ڼ��㷶Χ��
		while(index < chs.length && chs[index] != ')') {
			if(chs[index] >= '0' && chs[index] <= '9') {
				pre = pre*10 + chs[index++]-'0';
			}else if(chs[index] != '(') {
				// �����˼������
				// addNum��֮ǰ�����ݵĳ˳����������ֻ�����Ӽ�
				addNum(que, pre);
				// pre��0��׼���ռ���һ������
				pre = 0;
				// �ѷ��żӽ���
				que.push(String.valueOf(chs[index++]));
			}else {
				// ������������,�ݹ���������е�����,���ؽ���������ŵ�λ�õ�λ��
				subBra = compute(chs, index + 1);
				pre = subBra[0];
				index = subBra[1] + 1;
			}
		}
		addNum(que, pre);
		// ����Ӽ��Ľ��
		return new int[] {getNum(que), index};
	}

	// ���⣺���ջ�����һ���ַ�����"-",ջ��ʣ��һ��Ԫ��ʱ���ͻ���������������ջ������������⣬������˫����д�ͷ����ʼ���㡣
	// Exception in thread "main" java.lang.NumberFormatException: For input string: "-"
//	private static int getNum(Deque<String> stack) {
//		int res = 0;
//		while(!stack.isEmpty()) {
//			String later = stack.pop();
//			int l = Integer.valueOf(later);
//			// ���ֻʣһ������
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
				// �˳������
				int p = Integer.valueOf(stack.pollLast());
				next = cur.equals("*") ? (p*next):(p/next);
			}
		}
		// ����ջΪ�յ����
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
