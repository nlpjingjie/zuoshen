package cn.jingjie.zuo.advanced;

import java.util.Deque;
import java.util.LinkedList;


// ���ֵ��ȥ��СֵС�ڵ���num���������������������ڸ��´����ڵ����ֵ����Сֵ
// �磺��0��ͷ�������飬0��x��Χ���Ǵ��ģ�0��x+�ǲ����ġ�������x+1��.
public class Code_05_Window_SubArrayNumbers {
	public static int subArrayNumbers(int[] arr, int num) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int res = 0;
		int L = 0;
		int R = 0;
		Deque<Integer> minQueue = new LinkedList<>();
		Deque<Integer> maxQueue = new LinkedList<>();
		while(L != arr.length) {
			while(R != arr.length) {
				// >= ���ڵ�ҲҪ���в�������ΪԽ�����ұߵ���Ч��Խ��
				while(!maxQueue.isEmpty() && arr[R] >= arr[maxQueue.getLast()]) {
					maxQueue.pollLast();
				}
				maxQueue.offerLast(R);
				while(!minQueue.isEmpty() && arr[R] <= arr[minQueue.getLast()]) {
					minQueue.pollLast();
				}
				minQueue.offerLast(R);
				// 
				if(arr[maxQueue.getFirst()] - arr[minQueue.getFirst()] > num) {
					break;
				}
				R++;
			}
			// ȥ��������߽��ֵ
			if(minQueue.getFirst() == L) {
				minQueue.pollFirst();
			}
			if(maxQueue.getFirst() == L) {
				maxQueue.pollFirst();
			}
			res += R-L;
			L++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {6, 14, 26};
		System.out.print(subArrayNumbers(arr, 5));
	}
}
