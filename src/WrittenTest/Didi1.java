package WrittenTest;

import java.util.ArrayList;
import java.util.Scanner;

//A+B����
//��a, b, c��0��9֮�������������a, b, c������ͬ��������abc��acc��������ͬ����λ��������������n�����ж��ٶ�abc��acc������abc+acc=n(a!=0)
public class Didi1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int res = 0;
		ArrayList<String> list = new ArrayList<>();
		for(int i=1;i<=9;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=0;k<=9;k++) {
					if(200*i+10*j+12*k==n && i!=j && i!=k && j!=k) {
						res++;
						list.add(""+i+j+k+" "+i+k+k);
					}
				}
			}
		}
		System.out.println(res);
		for(String s:list) {
			System.out.println(s);
		}
	}
}
