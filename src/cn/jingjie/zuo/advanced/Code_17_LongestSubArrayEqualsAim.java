package cn.jingjie.zuo.advanced;

// 给定数组，全是正数。求累加和等于aim的最长子数组
public class Code_17_LongestSubArrayEqualsAim {
	public static int getLsaea(int[] arr, int aim) {
		if(arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		
		int left = 0;
		int right = 0;
		int sum = arr[0];
		int max = 0;
		// 双指针遍历
		while(right < arr.length) {
			if(sum == aim) {
				max = Math.max(right-left+1, max);
				sum -= arr[left++];
			}else if(sum < aim) {
				right++;
				if(right == arr.length) {
					break;
				}
				sum += arr[right];
			}else {
				sum -= arr[left++];
			}
			
//			if(sum < aim && right != arr.length-1) {
//				sum += arr[++right];
//			}else if(sum > aim) {
//				sum -= arr[left++];
//			}else {
//				max = Math.max(right-left+1, max);
//				sum -= arr[left++];
//			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 5, 1, 1, 1, 1, 1, 1};
		System.out.println(getLsaea(arr, 6));
	}
}
