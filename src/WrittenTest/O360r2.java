package WrittenTest;

import java.util.Scanner;



//��Ϸװ��
//ʱ�����ƣ� 3000MS
//�ڴ����ƣ� 589824KB
//��Ŀ������
//С�����������һ��Ӣ�۶�ս��Ϸ��ÿ����ҿ���ӵ��m��Ӣ�ۣ�����Ϸ���ṩ��n��װ����Ӣ��ʹ�á���ͬ��Ӣ��ӵ�в�ͬ��Ŀ��װ��ʱ����ò�ͬ�Ĺ���ֵ��ÿһ��Ӣ�ۿ���ӵ��0������װ����
//
//������η�����n��װ��������ʹ������m��Ӣ�ۻ�õĹ���ֵ�ĺ����
//
//
//
//��������
//�������롣
//
//��1����������������m��n���ֱ��ʾӢ�۵ĸ�����װ������������������֮���ÿո������m��n��������100��
//
//��������һ��m*n�ľ��󣬵�i�е�j�б�ʾ��i��Ӣ���ܹ�ӵ��j��װ��ʱ�ܹ��õ��Ĺ���ֵ������ֵ����int���͵�������������װ���򹥻�ֵΪ0��������һ��m�У�ÿһ��n�У�ͬһ����������֮���ÿո������
//
//�������
//���m��Ӣ�۵Ĺ���ֵ֮�͵����ֵ��
//
//
//��������
//2 3
//5 6 7
//7 8 9
//�������
//13
//
//��ʾ
//��2��Ӣ�ۺ�3��װ��
//���磺���ڵ�һ��Ӣ�ۣ�����ӵ��һ��װ��ʱ����ֵΪ5��Ӣ��ӵ������װ��ʱ������Ϊ6��ӵ������װ��ʱ������Ϊ7��
//�ʵ�1��Ӣ��ӵ������װ������2��Ӣ��ӵ��һ��װ��ʱ���Ի�õĹ���ֵ֮��Ϊ6+7=13�����ߵ�1��Ӣ��ӵ��һ��װ������2��Ӣ��ӵ������װ��ʱ���Ի�õĹ���ֵ֮��Ϊ5+8=13�����ǿ��Եõ������ֵ��

public class O360r2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		
		int[][] arr = new int[m+1][n+1];
		int[][] dp = new int[m+1][n+1];
		for(int i=1; i < m+1; i++) {
			for(int j=1; j < n+1; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		int res = 0;
		res = Math.max(dfs(arr, 0, 0, m, n, dp), res);
		System.out.println(res);
	}

	
	// k�����ڼ���Ӣ�ۣ�j������ĿǰΪֹ���ĵļ��ܸ�����m����Ӣ������n����������
	private static int dfs(int[][] arr, int k, int j, int m, int n, int[][] dp) {
		if(k > m || j > n) return 0;
		
		int max = 0;
		
		// n-jʣ��ļ�����
		for(int i=0; i <= n-j; i++) {
			int r = 0;
			
			if(k+1 <= m && j + i <= n && dp[k+1][j + i] != 0) {
				r += arr[k][i] + dp[k+1][j + i];
			}else {
				r += arr[k][i] + dfs(arr, k+1, j+i, m, n, dp);
			} 
			
			max = Math.max(r, max);
		}
		
		dp[k][j] = max; // ��k��Ӣ��,Ŀǰ������j������ʱ��m-k+1��Ӣ�۵Ĺ���ֵ֮�͵����ֵ
		return max;
	}
}