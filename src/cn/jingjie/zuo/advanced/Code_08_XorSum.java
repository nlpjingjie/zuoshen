package cn.jingjie.zuo.advanced;

import java.util.HashMap;

// 给定一个数组，分出来的子数组中异或和为0的子数组最多
// 思路：如：数组的最后一个值，i不在最优划分里，dp[i] = dp[i-1];i在最优划分里dp[i] = dp[k-1] + 1
// 求k, n^0=n
public class Code_08_XorSum {	
	public static int getMostSubArray(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		
		int dp[] = new int[arr.length];
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int xorSum = 0;
		int res = 0;
		for(int i=0; i < arr.length; i++) {
			xorSum ^= arr[i];
			if(map.containsKey(xorSum)) {
				int pre = map.get(xorSum);
				// 处理第一次异或和为0的情况,pre == -1
				dp[i] = pre == -1 ? 1:dp[pre] + 1;
			}
			// 把两种情况的更新写到了一起
			if(i > 1) {
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
			// 更新异或和的位置，因为k是最优划分最后一个划分的前一个值
			map.put(xorSum, i);
			res = Math.max(res, dp[i]);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 0, 1, 2, 3, 0};
		int[] arr1 = {3, 2, 1, 0, 1, 2, 3, 0, 0, 0};
		System.out.println(getMostSubArray(arr));
		System.out.println(getMostSubArray(arr1));
	}
}
