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
	
	// �������
	private static long getNums(int n, int m) {
		
		double count = 1;
//		long fenzi = 1;
//		long fenmu = 1;
//		for(int i=0; i < m; i++) {
//			fenzi *= (n - i);  // ���˿��ܻ���������������������count���ܳ���
//			fenmu *= (m-i);
//		}
//		count = fenzi/fenmu;
		
		for(int i=0; i < m; i++) {
			// ����ÿһ��������
			count *= (double)(n - i)/(double)(m-i); // long��int���Ͳ��У�ÿ��ֱ�ӳ��������n=5,m=3�����6��n=5,m=2,�����6��
		}
		return (long) (count);
	}
}   
