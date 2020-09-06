package cn.jingjie.zuo;

import java.util.Arrays;


// 冒泡排序，用对数器进行测试
public class Code_00_BubbleSort {
	public static void bubbleSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i=arr.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}
	
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	// 构建对数器
	// 好的但是不复杂的算法
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	//获得一个大小随机，值随机的数组，随机样本产生器
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		//因为Random[0,1),所以[0,maxSize+1)最大只能取maxSize.小数
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; //产生一个随机大小的整型数组
		for (int i = 0; i < arr.length; i++) {
			//正负都有可能，所以用取值范围大的随机数减去一个小的随机数
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// 拷贝数组
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// 查看两个数组是否相同，只有相同了，才可以比较出来自己的方法是否错误
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
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

	//输出错误的数组，为了查验自己的问题出在哪
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		//testTime绝对正确的方法与被测方法的比较次数，一旦有1次结果不同立刻打印错误用例并跳出
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			int[] arr3 = copyArray(arr1);
			bubbleSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr3);////打印出来错误的测试用例
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
}
