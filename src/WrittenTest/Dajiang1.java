package WrittenTest;

import java.util.*;

/*单源最短路径
 * 
 * 从0号路标达到终点路标，总路程用时最短者获胜。
 * 
 */
public class Dajiang1 {
	public static int maxValue = 100000;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int N = in.nextInt();
			int P = in.nextInt();
			
			int[][] matrix = new int[N][P];
			
			for(int i=0; i < N; i++) {
				for(int j=0; j < P; j++) {
					matrix[i][j] = maxValue;
				}
			}
			
			for(int i=0; i < P; i++) {
				int A = in.nextInt();
				int B = in.nextInt();
				int weight = in.nextInt();
				
				matrix[A][B] = weight;
			}
			
			int target = in.nextInt();
			myDijkstra(matrix, target);
		}
	}


	private static void myDijkstra(int[][] matrix, int target) {
		int from = 0;
		int[] st = new int[matrix.length];
		
		int[] visited = new int[matrix.length];
		
		st[from] = 0;
		visited[from] = 1;
		
		for(int i=1; i < matrix.length; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			// 找出没访问过的离起始点距离最小的点
			for(int j=0; j < matrix.length; j++) {
				if(visited[j] == 0 && matrix[from][j] < min) {
					min = matrix[from][j];
					index = j;
				}
			}
			
			st[index] = min;
			visited[index] = 1;
			
			for(int m=0; m < matrix.length; m++) {
				if(visited[m] == 0 && matrix[from][index] + matrix[index][m] < matrix[from][m]) {
					matrix[from][m] = matrix[from][index] + matrix[index][m];
				}
			}
		}
		System.out.println(st[target]);
	}
}
