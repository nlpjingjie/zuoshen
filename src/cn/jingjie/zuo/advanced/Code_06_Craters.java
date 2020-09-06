package cn.jingjie.zuo.advanced;

import java.util.Deque;
import java.util.LinkedList;


// ���õ���ջ
/*һ�������е�������ɻ���ɽ����ֵΪɽ��
1 2 4 5 3
���򣬷�𴫵ݣ�
����֮�������ɽ���ܿ������
�����ڵ�ɽ֮����һ�ߵ�ɽ�߶� <= ������������ɽ��ɽ�ߣ���������ɽ���໥�������*/

// �ҵ����пɼ�ɽ��ԡ�
// 1.��ȷ˵��û���ظ����ݣ�˼·�����ҵ�����ɽ����߼��θ߶���ʣ���Ԫ�أ��������ݴ�С���ظ���������ÿһ��Ԫ�أ������ҵ�����ɽ��ԣ��У�n-2��*2��ɽ��ԣ������ټ���1��
// 2.���ظ����ݣ��õ���ջ���ֲ������õ���1�Ĺ�ʽ�����£�
public class Code_06_Craters {
	public static class Data{
		public int index;
		public int count;
		
		public Data(int v) {
			index = v;
			count = 1;
		}
	}
	
	public static int getCratersPairs(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return 0;
		}
		// �ҵ������е����ֵ������
		int maxIndex = 0;
		for(int i=0; i < arr.length; i++) {
			maxIndex = arr[maxIndex] > arr[i] ? maxIndex:i;
		}
		// System.out.println(arr[maxIndex]);
		int res = 0;
		// �����ݼ�ջ
		Deque<Data> stack = new LinkedList<>();
		stack.push(new Data(maxIndex));
		for(int i = maxIndex + 1; i != maxIndex; i++ ) {
			// ���û���
			if(i == arr.length) {
				i = 0;
			}
			
			Data data = new Data(i);
			while(!stack.isEmpty() && arr[data.index] > arr[stack.peek().index]) {
				Data curData = stack.pop();
				int count = curData.count;
				res += (count*(count - 1)/2) + count*2;
			}
			if(arr[data.index] == arr[stack.peek().index]) {
				stack.peek().count++;
			}else {
				stack.push(data);
			}
		}
		
		/*����ջ���Ӵ�С����
		������һ�����ֵ��ʼ����һ��������ת��������ջ����
		��һ����������ջʱ�����ҵ���2�������໥����ɽ����������ջ�ĺ��������
		������ջ����ջ����ȣ�������������Ϣ��ͬ��¼��ͬһ��ջλ�ã�
		������ĳ����Ϊn����¼ʱ������ͬһ��λ�ü�¼��n��ĳ���������磬������n��4��ջ��������ͬλ�ü�¼n��4
		��ʱ������ʱ���ܿ�����ɽΪ��Cn2 + n * 2������Cn2[n��4֮���໥���] + n * 2[n��4�������ߵĸ�ɽ���]��
		���������������ջ��ʣ���������ʱ��
		���ڵ�����i > 2��ʣ��������ʱ�����ܿ�����ɽΪ��Cn2 + n * 2
		���ڵ����ڶ���ʣ��������ʱ��
		�����һ����Ϊ > 1����¼���ܿ�����ɽΪ��Cn2 + n * 2
		�����һ����Ϊ == 1����¼���ܿ�����ɽΪ��Cn2 + n * 1, ��Ϊ����һ������
		���ڵ�����1��ʣ��������ʱ�����ܿ�����ɽΪ��Cn2*/
		
		while(!stack.isEmpty()) {
			Data curData = stack.pop();
			int count = curData.count;
			// ���������
			if(stack.size() >= 2) {
				res += (count*(count - 1)/2) + count*2;
			}else if(stack.size() == 1) {
				if(stack.peek().count > 1) {
					res += (count*(count - 1)/2) + count*2;
				}else {
					res += (count*(count - 1)/2) + count;
				}
			}else {
				res += (count*(count - 1)/2);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 5, 3};
		System.out.println(getCratersPairs(arr));
	}
}
