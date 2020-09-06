package cn.jingjie.zuo;

import java.util.Arrays;

// 归并排序，分治左右两部分，左右两部分分别都排好序，然后将左右两部分合并。
public class Code_03_MergeSort {
	public static void mergeSort(int[] arr) {
		if((arr == null || arr.length < 2)) {
			return;
		}
		sortProcess(arr, 0, arr.length-1);
	}
	
	public static void sortProcess(int[] arr, int L, int R) {
		if(L==R) {
			return;
		}
		int mid = L + ((R-L)>>1);
		sortProcess(arr, L, mid);
		sortProcess(arr, mid+1, R);
		merge(arr, L, mid, R);
	}
	
	public static void merge(int[] arr, int L, int mid, int R) {
		int[] helparr = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = mid+1;
		while(p1<=mid && p2<=R) {
			helparr[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
		}
		while(p1<=mid) {
			helparr[i++] = arr[p1++];
		}
		while(p2<=R) {
			helparr[i++] = arr[p2++];
		}
		for(int j=0; j<helparr.length; j++) {
			arr[L+j] = helparr[j];
		}
	}
	
	// 一个绝对正确的方法
	public static void absoluteRight(int[] arr) {
		Arrays.sort(arr);
	} 
	
	
	// 随机数组发生器
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)((maxSize + 1)*Math.random())];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)((maxValue + 1)*Math.random());
		}
		return arr;
	}
	
	
	public static int[] arrayCopy(int[] arr) {
		if(arr == null) {
			return null;
		}
		int[] copyarray = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			copyarray[i] = arr[i];
		}
		return copyarray;
	}
	
	// 比对两个排完序的数组是否相同
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if((arr1 == null && arr2 != null)||(arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	// 打印出来对比错误的数组
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	// 用两种方法对生成的随机数组进行排序
	public static void main(String[] args) {
		int maxSize = 100;
		int maxValue = 100;
		int num = 500000;
		boolean f = true;
		for(int i=0; i < num; i++) {
			int[] randomArr = generateRandomArray(maxSize, maxValue);
			// 将randomArr拷贝两份分别给两种方法排序
			int[] randomArr1 = arrayCopy(randomArr);
			int[] randomArr2 = arrayCopy(randomArr);
			mergeSort(randomArr1);
			absoluteRight(randomArr2);
			if(!isEqual(randomArr1, randomArr2)) {
				f = false;
				printArray(randomArr);
				break;
		}
		}
		System.out.println(f ? "nice":"wrong");
	}
}
