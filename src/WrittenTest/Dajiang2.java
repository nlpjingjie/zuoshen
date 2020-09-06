package WrittenTest;

import java.util.*;


/*0-1背包问题
 * 
 * 每个游戏标上一个成就值，同时对每个游戏都估算一个通关所需要的天数，
他计划在未来X天内让自己玩游戏的成就达到最大，那么他应该怎么做计划呢？
（假设每个游戏最多只计划玩一遍，
而且每个游戏必须玩完通关才能取得成就值，且通关每个游戏最小时间单位是1天）
*/
public class Dajiang2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int X = in.nextInt();
		
		int[] A = new int[N+1];
		int[] B = new int[N+1];
		
		for(int i=1; i <= N; i++) {
			A[i] = in.nextInt();
			B[i] = in.nextInt();
		}
		
		// i个游戏,j天达到的最大成就值
		int path[][] = new int[N+1][X+1];
		for(int i=1; i <= N; i++) {
			for(int j=1; j <= X; j++) {
				if(j < B[i]) {
					path[i][j] = path[i-1][j];
				}else {
					path[i][j] = Math.max(path[i-1][j], path[i-1][j-B[i]] + A[i]);
				}
			}
		}
		System.out.println(path[N][X]);
	}
}
