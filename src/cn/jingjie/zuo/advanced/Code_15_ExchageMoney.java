package cn.jingjie.zuo.advanced;

// ��Ǯ��
// ������ֵ���飬�Ǹ����ظ�������Ŀ��aim��ͬһ��ֵ�����ظ�ʹ�ã����ܹ���Ǯ������������
public class Code_15_ExchageMoney {
	// �����ݹ�
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
	
	// ��̬�滮��dp�����С int[arr.length+1][aim+1]
	public static int exchangeMoney2(int[] arr, int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		// ���һ��ֻ��aimΪ0��λ��Ϊ1
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
	
	// ��һ���Ż�
	public static int exchangeMoney3(int[] arr, int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		// ���һ��ֻ��aimΪ0��λ��Ϊ1
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
