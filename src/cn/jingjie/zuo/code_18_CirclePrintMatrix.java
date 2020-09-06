package cn.jingjie.zuo;

public class code_18_CirclePrintMatrix {
	// תȦ��ӡ����
	public static void circlePrint(int[][] m) {
		// tR��tC���Ͻ��к��У�dR��dC���½��к���
		int tR = 0;
		int tC = 0;
		int dR = m.length-1;
		int dC = m[0].length-1;
		while(tR <= dR) {
			printEdge(m, tR++, tC++, dR--, dC--);
		}
	}

	private static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		// ��ӡ��ǰ�Խ�����ȷ���ľ����һȦ
		if(tR == dR) {// ֻ��һ��
			for (int i=tC; i<= dC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		}else if(tC == dC) {// ֻ��һ��
			for (int i=tR; i<= dR; i++) {
				System.out.print(m[i][tR] + " ");
			} 
		}else {// ���ж��о���
			int curR = tR;
			int curC = tC;
			while(curC != dC) {
				System.out.print(m[curR][curC] + " ");
				curC++;
			}
			while(curR != dR) {
				System.out.print(m[curR][curC] + " ");
				curR++;
			}
			while(curC != tC) {
				System.out.print(m[curR][curC] + " ");
				curC--;
			}
			while(curR != tR) {
				System.out.print(m[curR][curC] + " ");
				curR--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3},{8,9,4},{7,6,5}};
		circlePrint(m);
	}
}
