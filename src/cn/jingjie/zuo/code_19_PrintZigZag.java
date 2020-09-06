package cn.jingjie.zuo;

import java.util.Arrays;

public class code_19_PrintZigZag {
	public static void printZigZag(int[][] m) {
		int aR = 0;
		int aC = 0;
		int bR = 0;
		int bC = 0;
		int endR = m.length-1;
		int endC = m[0].length-1;
		boolean fromUp = false;
		while(aR != endR+1) {
			printLevel(m, aR, aC, bR, bC, fromUp);
			aR = aC == endC ? aR+1 : aR;
			aC = aC == endC ? aC : aC+1;
			bC = bR == endR ? bC+1: bC;
			bR = bR == endR ? bR : bR+1;
			fromUp = !fromUp;
		}
	}

	private static void printLevel(int[][] m, int ar, int ac, int br, int bc, boolean f) {
		// f为true从右上到左下打印
		if(f) {
			while(ar <= br) {
				System.out.print(m[ar++][ac--] +" ");
			}
		}else {
			while(bc <= ac) {
				System.out.print(m[br--][bc++] +" ");
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3},{8,9,4},{7,6,5}};
		for(int[] m1:m) {
			System.out.println(Arrays.toString(m1));
		}
		printZigZag(m);
	}
}
