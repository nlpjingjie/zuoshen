package cn.jingjie.zuo;

import java.util.Arrays;

// ºÉÀ¼¹úÆìÎÊÌâ
public class Code_08_NetherLandsFlag {
	public static void partition(int[] arr, int L, int R, int v) {
		int less = L-1;
		int more = R+1;
		int current = L;
		while(current < more) {
			if(arr[current] < v) {
				swap(arr, ++less, current++);
			}
			else if(arr[current] > v) {
				swap(arr, --more, current);
			}
			else
				current++;
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int k = arr[a];
		arr[a] = arr[b];
		arr[b] = k;
	}
	
	public static void main(String[] args) {
		int[] a = {3, 2, 4, 6, 9, 2, 8, 4, 5, 6, 1, 0, 3, 7, 3, 5, 8};
		partition(a, 0, 13, 5);
		System.out.println(Arrays.toString(a));
	}
}
