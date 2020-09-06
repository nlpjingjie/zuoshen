package TestAbout;

import java.util.Scanner;


/*
 算法描述
一场球赛开始前,售票工作正在紧张的进行中.每张球票为50元,现有m+n个人排队等待购票,其中有m个人手持50元的钞票,另外n个人手持100元的钞票.假设开始售票时售票处没有零钱,求出m+n排队购票,
算法思路
定义函数f(m,n)表示m个人手持50元，n个人手持100元共有的排队种数
1. 当n=0,没有手持100元的人排队，这个情况是找得开钱 f(m,0) =1
2. 当m<n,(手持50元的人数小于手持100元的人数) f(m,n)=0
3. 其他情况
当第m+n个人手持100元，他之前的m+n-1个人有m个人手持50元，n-1个人手持100元，共有的排队种数为f(m,n-1)
当第m+n个人手持50元，他之前的m+n-1个人有m-1个人手持50元，n个人手持100元，共有的排队种数为f(m-1,n)
根据上述情况可得到
递归公式f(m,n)=f(m-1,n)+f(m,n-1)
递归出口n=0 f(m,0)=1 m<n f(m,n)=0
 */

public class KaTeLanAbout {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.close();
		long temp = digui(m, n);
		System.out.println(temp);
	}
	
	public static long digui(int m,int n){
		if(n==0){
			return 1;
		}else if(m<n){
			return 0;
		}else{
			return digui(m-1,n)+digui(m,n-1);
		}
	}
}
