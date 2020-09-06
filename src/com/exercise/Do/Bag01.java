package com.exercise.Do;


public class Bag01 {
	public static void main(String[] args) {
		int[] arr = {2, 2, 4, 6, 3};
		int[] value = {3, 4, 8, 9, 6};
		int res1 = bag01(arr, value, 9);
		int res2 = bag02(arr, value, 5, 9);
		int res3 = bag03(arr, value, 9);
		int res4 = bag04(arr, value, 9);
		System.out.println(res1); // ���18
		System.out.println(res2); // ���18
		System.out.println(res3); // ���18
		System.out.println(res4); // ���18
	}
	
	// �Լ�д�ĵݹ�⣬���ǵ������˶�����Ʒ��������������ʵ��dp
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
	
	// �ݹ�⣬����n����Ʒ��v������ʱ���õ�������ֵ������ۣ�����ʵ��dp
	// ����n����Ʒ���������Ϊvʱ����ȡ������ֵ
	public static int bag02(int[] wi, int[] va, int n, int v) {
		if(n == 0 || v == 0) { // ����Ʒ����Ϊ0�����߱�������Ϊ0ʱ�����Ž�Ϊ0
			return 0;
		}else {
			if(wi[n-1] <= v) { // ����Ʒwi[N-1]����С�ڱ�������Vʱ�����Կ�������
				int r1 = bag02(wi, va, n-1, v);
				int r2 = bag02(wi, va, n-1, v-wi[n-1]) + va[n-1];
				return Math.max(r1, r2);
			}else {
				return bag02(wi, va, n-1, v); // ��ǰ��Ʒ������ʱ
			}
		}
	}
	
	// ����bag2ʵ�ֵ�dp
	public static int bag03(int[] wi, int[] va, int c) {
		int n = wi.length;
		int[][] dp = new int[n+1][c+1];    // ǰi����Ʒ����ǰ��������Ϊjʱ����Ӧ������ֵ
		
		// ��������ʼ������ʡ��
//		// �޻�ʱ
//		for(int j=0; j < c+1; j++) {
//			dp[0][j] = 0; 
//		}
//		// ��������Ϊ��ʱ
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
	
	
	// �Ż�dp,״̬ѹ�������Կ���dp[i][j]ֻ�����Ϸ����Ϸ����λ���й�ϵ������ʹ��һάdp[]
	// ��ΪҪʹ����ߵ�״̬��������������ƻḲ����һ��Ҫʹ�õ�λ��,����ѡ�����������
	public static int bag04(int[] wi, int[] va, int c) {
		int n = wi.length;
		int[] dp = new int[c+1];   // ������bag03dp�����dpֵ
		
		
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