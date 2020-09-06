package cn.jingjie.zuo;

import java.util.Arrays;

// ������ţ�ȡһ����Ϊ��׼�����С�ڴ�ֵ���ұߴ��ڡ�Ȼ��ݹ����ҡ�
public class code_09_JdQuickSort {
	public static void quicksort(int[] arr, int L, int R) {
		if (L < R) {
			int mid = partition(arr, L, R);
			quicksort(arr, L, mid-1);
			quicksort(arr, mid + 1, R);
		}
	}

	public static int partition(int[] arr, int L, int R) {
		int tmp = arr[L];
		while (L < R) {
			while (L < R && arr[R] >= tmp) {
				R--;
			}
			arr[L] = arr[R];
			while (L < R && arr[L] <= tmp) {
				L++;
			}
			arr[R] = arr[L];
		}
		arr[L] = tmp;
		return L;
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 4, 6, 9, 2, 8, 4, 5, 6, 1, 0, 3, 7, 3, 5, 8 };
		quicksort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
