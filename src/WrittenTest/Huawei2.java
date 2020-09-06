package WrittenTest;

import java.util.Scanner;


/*dfs + 回溯  给定步长的机器人走路问题
 * 跟牛客65题，矩阵中的路径一样
 */
public class Huawei2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] matrix = new int[r][c];
		for(int i = 0 ; i < r; i++) {
			for(int j = 0; j < c; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		boolean flag = dfs(matrix, 0, 0, r, c, s);
		System.out.println(flag ? 1 : 0);
	}
	private static boolean dfs(int[][] grid, int i, int j, int r, int c, int s){
		if (i >= r || i < 0 || j < 0 || j >= c || grid[i][j] == 0) {
			return false;
		}
		grid[i][j] = 0;
		if (i == r - 1 && j == c - 1) {
			return true;
		}
		boolean flag = dfs(grid, i - s, j, r, c, s) 
				|| dfs(grid, i, j + s, r, c, s) 
				|| dfs(grid, i + s, j, r, c, s)
				|| dfs(grid, i, j - s, r, c, s);
		return flag;
	}

}
