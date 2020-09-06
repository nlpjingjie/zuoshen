package cn.jingjie.zuo.advanced;

import java.util.Arrays;

// ������ʱ�临�Ӷ����ҵ������е� k С������
public class Code_03_BFPRT {
	public static int getMinKthByBFPRT(int[] arr, int k) {
		int[] copyArr = copyArray(arr);
		
		return bfprt(copyArr, 0, arr.length-1, k-1);
	}
	
	// index�ǵ�kС��ֵ������
	public static int bfprt(int[] arr, int start, int end, int index) {
		if(start == end) {
			return arr[start];
		}
		// ȡ�û���ֵ
		int pivot = getMedianFromMedians(arr, start, end);
		
		int[] pivotRange = partition(arr, start, end, pivot);
		if(pivotRange[0] <= index && index <= pivotRange[1]) {
			return arr[index];
		}else if(index < pivotRange[0]) {
			return bfprt(arr, start, pivotRange[0]-1, index);
		}else {
			return bfprt(arr, pivotRange[0]+1, end, index);
		}
	}

	private static int[] partition(int[] arr, int start, int end, int pivot) {
		int small = start - 1;
		int large = end + 1;
		int cur = start;
		while(cur != large) {
			if(arr[cur] < pivot) {
				swap(arr, ++small, cur++);
			}else if(arr[cur] > pivot) {
				swap(arr, --large, cur);
			}else {
				cur++;
			}
		}
		return new int[] {small+1, large-1};
	}

	public static int getMedianFromMedians(int[] arr, int start, int end) {
		int num = end - start + 1;
		// num����5�ı�����mArr�Ĵ�С��Ҫ����ƫ����
		int offset = num%5 == 0 ? 0:1;
		int[] mArr = new int[num/5 + offset];
		for(int i = 0; i < mArr.length; i++) {
			int starts = start + 5*i;
			int ends = starts + 4;
			mArr[i] = getMidian(arr, starts, Math.min(ends, end));
		}
		// Ѱ����λ��������λ���Ĺ���Ҳ��-�ҵ������е� k С�����ֵ�����
		return bfprt(mArr, 0, mArr.length-1, mArr.length/2);
	}

	public static int getMidian(int[] arr, int starts, int ends) {
		insertSort(arr, starts, ends);
		int sum = starts + ends;
		// ż����ʱ��ȡ����λ��
		int mid = sum/2 + sum%2;
		return arr[mid];
	}

	private static void insertSort(int[] arr, int starts, int ends) {
		// ��������
		for(int i=starts+1; i <= ends; i++) {
			for(int j=i; j > starts; j--) {
				if(arr[j-1] > arr[j]) {
					swap(arr, j-1, j);
				}else {
					break;
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

	public static int[] copyArray(int[] arr) {
		int[] res = new int [arr.length];
		for(int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
		System.out.println(getMinKthByBFPRT(arr, 8));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
