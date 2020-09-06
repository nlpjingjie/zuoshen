package cn.jingjie.zuo;

import java.util.Arrays;

public class code_11_HeapSort {
	public static void heapSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		// �γɴ����
		for(int i=0; i<arr.length; i++) {
			heapInsert(arr, i);
		}
		
		int heapsize = arr.length;
		// ����������ֵ����ĩβ
		swap(arr, 0, --heapsize);
		// System.out.println(heapsize);
		// ���������������Ϊ�����
		while(heapsize > 0) {
			heapify(arr, 0, heapsize);
			swap(arr, 0, --heapsize);
		}
	}

	// �ѻ�����,��������֮�������ɴ���ѡ�
	private static void heapify(int[] arr, int index, int heapsize) {
		int left = 2*index + 1;
		while(left < heapsize) {
			// ȡ�����ӽڵ�����ֵ
			int largest = left+1 < heapsize && arr[left] < arr[left+1] ? left+1:left;
			// �Ƚϸ��ڵ��������ӽڵ�Ĵ�С
			largest = arr[largest] > arr[index] ? largest:index;
			if(largest == index) {
				break;
			}
			swap(arr, index, largest);
			index = largest;
			left = 2*index + 1;
		}
		
	}

	private static void heapInsert(int[] arr, int index) {
		while(arr[index]>arr[(index-1)/2]) {
			swap(arr, index, (index-1)/2);
			index = (index-1)/2;
		}
	}

	private static void swap(int[] arr, int index, int i) {
		int tmp = arr[index];
		arr[index] = arr[i];
		arr[i] = tmp;
	} 
	
	public static void main(String[] args) {
		int[] a = { 3, 2, 4, 6, 9, 2, 8};
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}
