package cn.jingjie.zuo;

// 给一个二维数组，找到从左上角到右下角的最小路径和
public class LeastRoads {
	
	// 暴力递归，包含大量重复
	public static int leastRoads(int[][] m) {
		if(m == null) {
			return 0;
		}
		int r = m.length - 1;
		int c = m[0].length - 1;
		return process(m, r, c, 0, 0);
	}

	private static int process(int[][] m, int R, int C, int I, int J) {
		int s = 0;
		if(I == R) {
			for(int j = J; j <= C; j++) {
				s += m[I][j];
			}
			return s;
		}
		if(J == C) {
			for(int i = I; i <= R; i++) {
				s += m[i][J];
			}
			return s;
		}
		return m[I][J] + Math.min(process(m, R, C, I+1, J), process(m, R, C, I, J+1));
	}
	
	// dp
	public static int leastRoads2(int[][] m) {
		if(m == null) {
			return 0;
		}
		int R = m.length-1;
		int C = m[0].length - 1;
		int[][] dp = new int[R+1][C+1];
		
		dp[R][C] = m[R][C];
		// 最后一列
		for(int i=R-1; i >=0; i--) {
			dp[i][C] =m[i][C] + dp[i+1][C];
		}
		// 最后一行
		for(int i=C-1; i >=0; i--) {
			dp[R][i] = m[R][i] + dp[R][i+1];
		}
		for(int i = R-1; i >=0; i--) {
			for(int j = C-1; j >= 0; j--) {
				dp[i][j] = m[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int[][] m = {{1, 1, 0, 0, 1}, 
					 {1, 0, 1, 0, 0}, 
					 {0, 1, 0, 1, 1}, 
					 {1, 1, 0, 0, 0}, 
					 {0, 1, 1, 0, 1}};
		
		int[][] m1 = {{1, 1, 0, 0, 1}};
		int[][] m2 = {{1}, {0}, {1}, {0}, {1}};
		
		System.out.println(leastRoads(m));
		System.out.println(leastRoads(m1));
		System.out.println(leastRoads(m2));
		System.out.println("******");
		System.out.println(leastRoads2(m));
		System.out.println(leastRoads2(m1));
		System.out.println(leastRoads2(m2));
	}
}
