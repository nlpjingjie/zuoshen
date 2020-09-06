package cn.jingjie.zuo;

// ��һ�������һ��Ŀ��ֵaim�������е����Ƿ��ܹ���ӵõ�aim
public class IsGetAim {
	// �����ݹ�
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
	
	// dp,�е��Ժ�
	public static boolean isGetAim2(int[] arr, int aim) {
		
		boolean[][] dp = new boolean[arr.length+1][aim+1];
		for(int i=0; i < arr.length+1; i++) {
			dp[i][aim] = true;
		}
		
		for(int i = arr.length-1; i >= 0; i--) {
			for(int j = aim-1; j >= 0; j--) {
				dp[i][j] = dp[i+1][j];
				// �������
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
