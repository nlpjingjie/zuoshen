package WrittenTest;

import java.util.Scanner;



//游戏装备
//时间限制： 3000MS
//内存限制： 589824KB
//题目描述：
//小明最近迷上了一款英雄对战游戏。每个玩家可以拥有m个英雄，在游戏中提供了n件装备给英雄使用。不同的英雄拥有不同数目的装备时将获得不同的攻击值，每一个英雄可以拥有0件或多件装备。
//
//请问如何分配这n件装备，可以使得所有m个英雄获得的攻击值的和最大？
//
//
//
//输入描述
//单组输入。
//
//第1行输入两个正整数m和n，分别表示英雄的个数和装备的数量，两个数字之间用空格隔开。m和n均不超过100。
//
//接下来是一个m*n的矩阵，第i行第j列表示第i个英雄总共拥有j件装备时能够得到的攻击值（攻击值都是int类型的正整数，不拿装备则攻击值为0）。矩阵一共m行，每一行n列，同一行两个数字之间用空格隔开。
//
//输出描述
//输出m个英雄的攻击值之和的最大值。
//
//
//样例输入
//2 3
//5 6 7
//7 8 9
//样例输出
//13
//
//提示
//有2个英雄和3件装备
//例如：对于第一个英雄：当其拥有一件装备时攻击值为5，英雄拥有两件装备时攻击力为6，拥有三件装备时攻击力为7。
//故第1个英雄拥有两件装备，第2个英雄拥有一件装备时可以获得的攻击值之和为6+7=13；或者第1个英雄拥有一件装备，第2个英雄拥有两件装备时可以获得的攻击值之和为5+8=13。这是可以得到的最大值。

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

	
	// k代表第几个英雄，j代表到目前为止消耗的技能个数，m代表英雄数，n代表技能数
	private static int dfs(int[][] arr, int k, int j, int m, int n, int[][] dp) {
		if(k > m || j > n) return 0;
		
		int max = 0;
		
		// n-j剩余的技能数
		for(int i=0; i <= n-j; i++) {
			int r = 0;
			
			if(k+1 <= m && j + i <= n && dp[k+1][j + i] != 0) {
				r += arr[k][i] + dp[k+1][j + i];
			}else {
				r += arr[k][i] + dfs(arr, k+1, j+i, m, n, dp);
			} 
			
			max = Math.max(r, max);
		}
		
		dp[k][j] = max; // 第k个英雄,目前消耗了j个技能时，m-k+1个英雄的攻击值之和的最大值
		return max;
	}
}
