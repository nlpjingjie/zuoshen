package cn.jingjie.zuo;

import java.util.Arrays;

public class code_10_GjQuickSort {
	// 利用荷兰国旗问题改进快速排序,随机快排
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		processSort(arr, 0, arr.length - 1);
	}

	public static void processSort(int[] arr, int L, int R) {
		if (L < R) {
			swap(arr, L + (int)(Math.random()*(R-L+1)), R); //随机取值与最后一个数交换，达到使用随机数划分的目的
			int[] p = partition(arr, L, R);
			processSort(arr, L, p[0]);
			processSort(arr, p[1], R);
		}

	}

	private static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
//		int more = r; //使用最后一个数做划分
		int more = r + 1;
//		int v = arr[l];
		int k = arr[r];
		while(l < more) {
			if(arr[l] < k) {
				swap(arr, ++less, l++);
			}
			else if(arr[l] > k) {
				swap(arr, --more, l);
			}
			else {
				l++;
			}
		}
		// more指向的数值大于arr[r],最后交换arr[more]和arr[r]
//		swap(arr, more, r);
		return new int[] {less, more};
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
	
	public static void main(String[] args) {
		int[] a = { 3, 2, 4, 6, 9, 2, 8, 4, 5, 6, 1, 0, 3, 7, 3, 5, 8 };
		quickSort(a);
		System.out.println(Arrays.toString(a));
	}
}
