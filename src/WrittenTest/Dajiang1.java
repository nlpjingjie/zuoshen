package WrittenTest;

import java.util.*;

/*��Դ���·��
 * 
 * ��0��·��ﵽ�յ�·�꣬��·����ʱ����߻�ʤ��
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
			
			// �ҳ�û���ʹ�������ʼ�������С�ĵ�
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
