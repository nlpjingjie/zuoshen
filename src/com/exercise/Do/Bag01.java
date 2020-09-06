package com.exercise.Do;


public class Bag01 {
	public static void main(String[] args) {
		int[] arr = {2, 2, 4, 6, 3};
		int[] value = {3, 4, 8, 9, 6};
		int res1 = bag01(arr, value, 9);
		int res2 = bag02(arr, value, 5, 9);
		int res3 = bag03(arr, value, 9);
		int res4 = bag04(arr, value, 9);
		System.out.println(res1); // 结果18
		System.out.println(res2); // 结果18
		System.out.println(res3); // 结果18
		System.out.println(res4); // 结果18
	}
	
	// 自己写的递归解，考虑的是用了多少物品和容量，不容易实现dp
	public static int bag01(int[] arr, int[] value, int V) {
		if(V < 1) return 0;
		
		return solution(arr, value, V, 0, 0);
	}
	
	public static int solution(int[] arr, int[] value, int V, int index, int tmpV) {
		if(index == arr.length) {
			return 0;
		}
		
		int r1 = 0;
		if(tmpV+arr[index] > V) {
			r1 = solution(arr, value, V, index+1, tmpV);
		}else {
			r1 = value[index] + solution(arr, value, V, index+1, tmpV + arr[index]);
		}
		int r2 = solution(arr, value, V, index+1, tmpV);
		return Math.max(r1, r2);
	}
	
	// 递归解，考虑n个物品，v的容量时，得到的最大价值，更宏观，容易实现dp
	// 可拿n个物品，最大容量为v时，获取的最大价值
	public static int bag02(int[] wi, int[] va, int n, int v) {
		if(n == 0 || v == 0) { // 当物品数量为0，或者背包容量为0时，最优解为0
			return 0;
		}else {
			if(wi[n-1] <= v) { // 当物品wi[N-1]容量小于背包容量V时，可以考虑拿它
				int r1 = bag02(wi, va, n-1, v);
				int r2 = bag02(wi, va, n-1, v-wi[n-1]) + va[n-1];
				return Math.max(r1, r2);
			}else {
				return bag02(wi, va, n-1, v); // 当前物品不能拿时
			}
		}
	}
	
	// 按照bag2实现的dp
	public static int bag03(int[] wi, int[] va, int c) {
		int n = wi.length;
		int[][] dp = new int[n+1][c+1];    // 前i件物品，当前背包容量为j时，对应的最大价值
		
		// 这两个初始化可以省略
//		// 无货时
//		for(int j=0; j < c+1; j++) {
//			dp[0][j] = 0; 
//		}
//		// 背包容量为空时
//		for(int i=0; i < n+1; i++) {
//			dp[i][0] = 0; 
//		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < c+1; j++) {
				if(wi[i-1] <= j) {
					dp[i][j] = Math.max(dp[i-1][j-wi[i-1]] + va[i-1], dp[i-1][j]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][c];
	}
	
	
	// 优化dp,状态压缩，可以看到dp[i][j]只与其上方或上方左边位置有关系，可以使用一维dp[]
	// 因为要使用左边的状态，如果从左往右推会覆盖下一个要使用的位置,所以选择从右往左推
	public static int bag04(int[] wi, int[] va, int c) {
		int n = wi.length;
		int[] dp = new int[c+1];   // 逐层更新bag03dp矩阵的dp值
		
		
		for(int i = 1; i < n+1; i++) {
			for(int j = c; j > 0; j--) {
				if(wi[i-1] <= j) {
					dp[j] = Math.max(dp[j-wi[i-1]] + va[i-1], dp[j]);
				}
			}
		}
		
		return dp[c];
	}
}