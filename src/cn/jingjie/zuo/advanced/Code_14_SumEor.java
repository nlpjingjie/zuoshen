package cn.jingjie.zuo.advanced;


// 给定一个数组，求子数组最大异或和
// 很重要的一个规律，3~i的异或结果等于0~i的异或结果异或0~2
public class Code_14_SumEor {
	public static Integer solution1(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		// 暴力循环O(n3),i之前的所有元素到i的异或和
		int res = Integer.MIN_VALUE;
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j <= i; j++) {
				int cur = 0;
				for(int m=j; m <= i; m++) {
					cur ^= arr[m];
				}
				res = Math.max(cur, res);
//				System.out.print(res + " ");
			}
		}
		return res;
	}
	
	// O（n2）
	public static Integer solution2(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		// 利用前i个异或和做优化
		int[] dp = new int[arr.length];
		int res = Integer.MIN_VALUE;
		int cur = 0;
		for(int i=0; i < arr.length; i++) {
			cur ^= arr[i];
			res = Math.max(res, cur);
			for(int m=1; m <= i; m++) {
				int tmp = dp[m-1]^cur;
				res = Math.max(res, tmp);
			}
			dp[i] = cur;
		}
		return res;
	}
	
	// 利用前缀树，可以O(n)时间内获取前i个范围内的最大异或和
	public static class TrieNode{
		public int[] path;
		
		public TrieNode() {
			path = new int[2];
		}
	}
	
	// 异或和加进前缀树，获取前i个范围内的最大异或和
	public static class Trie{
		
	}
	
	public static Integer solution3(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 6};
		int[] arr1 = {1, 1, 1};
		
		System.out.println(solution1(arr));
		System.out.println(solution1(arr1));
		
		System.out.println(solution2(arr));
		System.out.println(solution2(arr1));
	}
}
