package cn.jingjie.zuo;

import java.util.Arrays;


public class code_17_RotateMatrix {
	public static void rotate(int[][] m) {// Ðý×ª·½Õó
		int tR = 0;
		int tC = 0;
		int dR = m.length - 1;
		int dC = m[0].length - 1;
		while(tR <= dR) {
			rotateEdge(m, tR++, tC++, dR--, dC--);
		}
	}

	private static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		// TODO Auto-generated method stub
		int steps = dC - tC;
		int tmp = 0;
		for (int i=0; i < steps; i++) {
			tmp = m[tR][tC+i];
			m[tR][tC+i] = m[dR-i][tC];
			m[dR-i][tC] = m[dR][dC-i];
			m[dR][dC-i] = m[tR+i][dC];
			m[tR+i][dC] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3},{8,9,4},{7,6,5}};
		for(int[] a:m) {
			System.out.println(Arrays.toString(a));
		}
//		System.out.println(Arrays.deepToString(m));
//		rotate(m);
//		System.out.println(Arrays.deepToString(m));
		System.out.println("***************");
		rotate(m);
		for(int[] a:m) {
			System.out.println(Arrays.toString(a));
		}
	}
}
