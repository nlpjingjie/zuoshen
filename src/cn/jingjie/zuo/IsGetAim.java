package cn.jingjie.zuo;

// 给一个数组和一个目标值aim，数组中的数是否能够相加得到aim
public class IsGetAim {
	// 暴力递归
	public static boolean isGetAim(int[] arr, int aim) {
		if(arr == null) {
			return false;
		}
		return process(arr, aim, 0, 0);
	}

	private static boolean process(int[] arr, int aim, int sum, int i) {
		if(i == arr.length) {
			return aim == sum;
		}
		return process(arr, aim, sum+arr[i], i+1) || process(arr, aim, sum, i+1);
	}
	
	// dp,有点迷糊
	public static boolean isGetAim2(int[] arr, int aim) {
		
		boolean[][] dp = new boolean[arr.length+1][aim+1];
		for(int i=0; i < arr.length+1; i++) {
			dp[i][aim] = true;
		}
		
		for(int i = arr.length-1; i >= 0; i--) {
			for(int j = aim-1; j >= 0; j--) {
				dp[i][j] = dp[i+1][j];
				// 这里递推
				if(j + arr[i] <= aim) {
					dp[i][j] = dp[i][j] || dp[i+1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 6, 0, 2, 7};
//		System.out.print(isGetAim(arr, 1));
		System.out.print(isGetAim2(arr, 7));
	}
}
