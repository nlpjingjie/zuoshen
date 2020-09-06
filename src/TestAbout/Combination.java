package TestAbout;

import java.util.Scanner;

public class Combination {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		System.out.println(getNums(n, m));
//		System.out.print((double)n / (double)m);
	}
	
	// 求组合数
	private static long getNums(int n, int m) {
		
		double count = 1;
//		long fenzi = 1;
//		long fenmu = 1;
//		for(int i=0; i < m; i++) {
//			fenzi *= (n - i);  // 连乘可能会溢出，如果溢出，最后再求count可能出错。
//			fenmu *= (m-i);
//		}
//		count = fenzi/fenmu;
		
		for(int i=0; i < m; i++) {
			// 至少每一项都不会溢出
			count *= (double)(n - i)/(double)(m-i); // long或int类型不行，每项直接除会积累误差。n=5,m=3结果是6，n=5,m=2,结果是6。
		}
		return (long) (count);
	}
}   
