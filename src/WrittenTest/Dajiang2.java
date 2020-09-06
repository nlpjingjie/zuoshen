package WrittenTest;

import java.util.*;


/*0-1��������
 * 
 * ÿ����Ϸ����һ���ɾ�ֵ��ͬʱ��ÿ����Ϸ������һ��ͨ������Ҫ��������
���ƻ���δ��X�������Լ�����Ϸ�ĳɾʹﵽ�����ô��Ӧ����ô���ƻ��أ�
������ÿ����Ϸ���ֻ�ƻ���һ�飬
����ÿ����Ϸ��������ͨ�ز���ȡ�óɾ�ֵ����ͨ��ÿ����Ϸ��Сʱ�䵥λ��1�죩
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
		
		// i����Ϸ,j��ﵽ�����ɾ�ֵ
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
