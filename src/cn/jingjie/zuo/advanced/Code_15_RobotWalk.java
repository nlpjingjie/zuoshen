package cn.jingjie.zuo.advanced;

// 机器人走路问题
/*给你标号为1、2、3、……、N的N个位置，机器人初始停在M位置上，
走P步后停在K位置上的走法有多少种。注：机器人在1位置上时只能向右走，
在N位置上时只能向左走，其它位置既可向右又可向左。*/
public class Code_15_RobotWalk {
	public static int robotWalk(int N, int M, int P, int K) {
		if(P == 0) {
			return M == K ? 1:0;
		}
		if(M == N) {
			return robotWalk(N, M-1, P-1, K);
		}
		if(M == 1) {
			return robotWalk(N, M+1, P-1, K);
		}
		
		return robotWalk(N, M-1, P-1, K) + robotWalk(N, M+1, P-1, K);
	}
	
	public static int robotWalk2(int N, int M, int P, int K) {
		if(N < 1 || M > N || P < 1 || K > N || K < 1) {
			return 0;
		}
		
		int[][] dp = new int[P+1][N+1];
		dp[0][K] = 1;
		
		for(int i=1; i < dp.length; i++) {
			for(int j=1; j < dp[0].length; j++) {
				if(j == 1) {
					dp[i][j] = dp[i-1][j+1];
				}else if(j == N) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
			}
		}
		return dp[P][M];
	}
	
	public static void main(String[] args) {
		System.out.println(robotWalk(5, 2, 3, 3));
		System.out.println(robotWalk2(5, 2, 3, 3));
	}
}
