package cn.jingjie.zuo;

import java.util.Arrays;

public class code_11_HeapSort {
	public static void heapSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		// 形成大根堆
		for(int i=0; i<arr.length; i++) {
			heapInsert(arr, i);
		}
		
		int heapsize = arr.length;
		// 将大根堆最大值换到末尾
		swap(arr, 0, --heapsize);
		// System.out.println(heapsize);
		// 调整交换后的数组为大根堆
		while(heapsize > 0) {
			heapify(arr, 0, heapsize);
			swap(arr, 0, --heapsize);
		}
	}

	// 堆化函数,调整交换之后的数组成大根堆。
	private static void heapify(int[] arr, int index, int heapsize) {
		int left = 2*index + 1;
		while(left < heapsize) {
			// 取左右子节点的最大值
			int largest = left+1 < heapsize && arr[left] < arr[left+1] ? left+1:left;
			// 比较父节点与最大的子节点的大小
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
