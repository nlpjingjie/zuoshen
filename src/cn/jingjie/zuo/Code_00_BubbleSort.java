package cn.jingjie.zuo;

import java.util.Arrays;


// ð�������ö��������в���
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
	
	// ����������
	// �õĵ��ǲ����ӵ��㷨
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	//���һ����С�����ֵ��������飬�������������
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		//��ΪRandom[0,1),����[0,maxSize+1)���ֻ��ȡmaxSize.С��
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; //����һ�������С����������
		for (int i = 0; i < arr.length; i++) {
			//�������п��ܣ�������ȡֵ��Χ����������ȥһ��С�������
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// ��������
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

	// �鿴���������Ƿ���ͬ��ֻ����ͬ�ˣ��ſ��ԱȽϳ����Լ��ķ����Ƿ����
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

	//�����������飬Ϊ�˲����Լ������������
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
		//testTime������ȷ�ķ����뱻�ⷽ���ıȽϴ�����һ����1�ν����ͬ���̴�ӡ��������������
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
				printArray(arr3);////��ӡ��������Ĳ�������
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
