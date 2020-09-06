package cn.jingjie.zuo.advanced;

// 换钱。
// 给定面值数组，非负非重复，给定目标aim。同一面值可以重复使用，求能够换钱的所有面币组合
public class Code_15_ExchageMoney {
	// 暴力递归
	public static int exchangeMoney(int[] arr, int index, int aim) {
		if(aim == 0) {
			return 1;
		}
		if(index == arr.length && aim != 0) {
			return 0;
		}
		int res = 0;
		for(int i=0; i*arr[index] <= aim; i++) {
			res += exchangeMoney(arr, index+1, aim - i*arr[index]);
		}
		return res;
	}
	
	// 动态规划，dp数组大小 int[arr.length+1][aim+1]
	public static int exchangeMoney2(int[] arr, int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		// 最后一行只有aim为0的位置为1
		dp[arr.length][0] = 1;
		for(int i=arr.length-1; i >= 0; i--) {
			for(int j=0; j < aim+1; j++) {
				for(int m=0; m*arr[i] <= j; m++) {
					dp[i][j] += dp[i+1][j-m*arr[i]];
				}
			}
		}
		return dp[0][aim];
	}
	
	// 进一步优化
	public static int exchangeMoney3(int[] arr, int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		// 最后一行只有aim为0的位置为1
		dp[arr.length][0] = 1;
		for(int i=arr.length-1; i >= 0; i--) {
			for(int j=0; j < aim+1; j++) {
				dp[i][j] = j-arr[i] >=0 ? dp[i][j-arr[i]] + dp[i+1][j]:dp[i+1][j];
			}
		}
		return dp[0][aim];
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 10, 25, 1};
		int[] arr1 = {3, 5};
		System.out.println(exchangeMoney(arr, 0, 0));
		System.out.println(exchangeMoney(arr, 0, 15));
		System.out.println(exchangeMoney(arr1, 0, 2));
		
		System.out.println(exchangeMoney2(arr, 0));
		System.out.println(exchangeMoney2(arr, 15));
		System.out.println(exchangeMoney2(arr1, 2));
		
		System.out.println(exchangeMoney3(arr, 0));
		System.out.println(exchangeMoney3(arr, 15));
		System.out.println(exchangeMoney3(arr1, 2));
	}
}
