package cn.jingjie.zuo.advanced;

// 给定数组，正，负，0
public class Code_17_LongestSubArrayLetterEqualsAim {
	public static int getLSALEA(int[] arr, int aim) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		// 计算某个元素到右侧的最小值
		int[] min_array = new int[arr.length];
		// 这个最小值到右侧的位置
		int[] min_index = new int[arr.length];
		
		min_array[arr.length-1] = arr[arr.length-1];
		min_index[arr.length-1] = arr.length-1;
		
		for(int i=arr.length-2; i >= 0; i--) {
			if(min_array[i+1] <= 0) {
				min_array[i] += min_array[i+1];
				min_index[i] = min_index[i+1];
			}else {
				min_array[i] += arr[i];
				min_index[i] = i;
			}
		}
		
		int right = 0;
		int left = 0;
		int sum = 0;
		int max = 0;
		int pre = 0;
		while(right < min_array.length+1) {
			if(sum <= aim) {
				// 只有当right更新的时候才更新max
				max = pre != right ? Math.max(max, right - left):max;
				if(right == min_array.length) {
					break;
				}
				sum += min_array[right];
				right = min_index[right] + 1;
			}else {
				sum += arr[left++];
				pre = right;
			}
		}
		System.out.println(sum);
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, -3, 4, -5, 7, 3, -6, 9};
		System.out.println(getLSALEA(arr, 6));
	}
}
