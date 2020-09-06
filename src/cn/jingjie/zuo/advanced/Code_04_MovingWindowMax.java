package cn.jingjie.zuo.advanced;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// ���ڴ�СΪW��ά�ֻ��������ڵ����ֵ�����½ṹʹ�õ���˫�����
public class Code_04_MovingWindowMax {
	public static int[] movingWindowMax(int[] arr, int W) {
		if(arr == null || arr.length ==0 || W < 1) {
			return new int[]{};
		}
		int[] res = new int[arr.length - W + 1]; 
		int index = 0;
		int L = 0;
		Deque<Integer> updateMax = new LinkedList<>();
		for(int R=0; R < arr.length; R++) {
			// �������ڴ�С��������е�һ��Ԫ�ص��ڴ������L��˵����Ԫ���Ѿ�ʧЧ�����д�ͷ������һ��Ԫ�أ�L������
			if(R - L == W) {
				if(updateMax.getFirst() == L) {
					updateMax.pollFirst();
				}
				L++;
			}
			// ѹ���Ԫ�رȶ�β�󣬴Ӷ�βɾ��Ԫ��
			while(!updateMax.isEmpty() && arr[R] >= arr[updateMax.getLast()]) {
				updateMax.pollLast();
			}
			updateMax.offerLast(R);
			// ���ڴ�С����W,ȡ��ǰ�������ֵ,
			if(R - L == W - 1) {
				res[index++] = arr[updateMax.getFirst()];
				// System.out.print(arr[updateMax.getFirst()]);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 4, 7, 8, 4, 5, 6, 2, 4, 1};
		int[] arr1 = {4, 3, 5, 4, 3, 3, 6, 7};
		int[] r = movingWindowMax(arr1, 3);
		System.out.print(Arrays.toString(r));
	}
}
