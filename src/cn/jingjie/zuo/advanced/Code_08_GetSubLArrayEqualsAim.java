package cn.jingjie.zuo.advanced;

import java.util.HashMap;

// 给出目标值，返回累加和等于aim的最长子数组.   数组中的数据可以正负0
// 用map记录数组累加和sum,和它第一次出现的位置。在map中查找sum-aim是否出现过，子数组长度就是sum-aim的索引到sum的索引
public class Code_08_GetSubLArrayEqualsAim {
	public static int getSubArray(int[] arr, int aim) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		
		int res = 0;
		int sum = 0;
		// map记录数组累加和sum,和它第一次出现的位置
		HashMap<Integer, Integer> map = new HashMap<>(); 
		for(int i=0; i < arr.length; i++) {
			sum += arr[i];
			if(map.containsKey(sum - aim)) {
				res = Math.max(res, i - map.get(sum - aim));
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return res;
	}
	
	// 给一个数组，求奇数和偶数相等的最长子数组
	// 将奇数置1，偶数置0。奇偶数目相等的数组相加为0
	public static int getSubArrayOddEEvent(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int[] helpArr = new int[arr.length];
		
		for(int i=0; i < arr.length; i++) {
			if(arr[i]%2 == 0) {
				helpArr[i] = -1;
			}else {
				helpArr[i] = 1;
			}
		}
		
		int res = 0;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>(); 
		for(int i=0; i < helpArr.length; i++) {
			sum += helpArr[i];
			if(map.containsKey(sum)) {
				res = Math.max(res, i - map.get(sum));
				if(sum == 0) {
					res = Math.max(res, i+1);
				}
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {8, 4, 5, 6, 2, 3, 2, 2, 5, 1};
		System.out.println(getSubArray(arr, 15));
		System.out.println(getSubArrayOddEEvent(arr));
	}
}
