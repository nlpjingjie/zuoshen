package cn.jingjie.zuo;
import java.util.Arrays;

public class Code_01_SelectSort {
	// ѡ�����򷽷�
	public static void selectSort(int[] arr) {
		for(int i=arr.length-1; i>0; i--) {
			int maxindex = i;
			for(int j=i-1; j>=0; j--) {
				maxindex = arr[j] > arr[maxindex] ? j:maxindex;
				/*if(arr[j] > arr[miaxindex]) {
					maxindex = j; 
				}
				else;
					maxindex = maxindex;*/
			}
			swap(arr,i,maxindex);
		}
	}


	public static void swap(int[] arr, int i, int minindex) {
		// TODO Auto-generated method stub
		int tmp = arr[i];
		arr[i] = arr[minindex];
		arr[minindex] = tmp;
	}
	
	
	// һ��������ȷ�ķ���
	public static void absoluteRight(int[] arr) {
		Arrays.sort(arr);
	} 
	
	
	// ������鷢����
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
	
	// �ȶ�����������������Ƿ���ͬ
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
	
	
	// ��ӡ�����Աȴ��������
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	// �����ַ��������ɵ���������������
	public static void main(String[] args) {
		int maxSize = 100;
		int maxValue = 100;
		int num = 500000;
		boolean f = true;
		for(int i=0; i < num; i++) {
			int[] randomArr = generateRandomArray(maxSize, maxValue);
			// ��randomArr�������ݷֱ�����ַ�������
			int[] randomArr1 = arrayCopy(randomArr);
			int[] randomArr2 = arrayCopy(randomArr);
			selectSort(randomArr1);
			absoluteRight(randomArr2);
			if(!isEqual(randomArr1, randomArr2)) {
				f = false;
				printArray(randomArr);
				break;
		}
		}
		System.out.println(f ? "nice":"wrong");
	}
	// �Ƚ���������Ƿ���ͬ
}
