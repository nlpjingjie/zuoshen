package cn.jingjie.zuo.advanced;

import java.util.HashMap;

// ����һ�����飬�ֳ�����������������Ϊ0�����������
// ˼·���磺��������һ��ֵ��i�������Ż����dp[i] = dp[i-1];i�����Ż�����dp[i] = dp[k-1] + 1
// ��k, n^0=n
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
				// �����һ������Ϊ0�����,pre == -1
				dp[i] = pre == -1 ? 1:dp[pre] + 1;
			}
			// ����������ĸ���д����һ��
			if(i > 1) {
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
			// �������͵�λ�ã���Ϊk�����Ż������һ�����ֵ�ǰһ��ֵ
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
