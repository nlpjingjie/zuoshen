package cn.jingjie.zuo;

public class JieCheng {
	public static int jieCheng(int n) {
		if(n == 0) {
			return 1;
		}
		return n*jieCheng(n-1);
	}
	
	public static void main(String[] args) {
		System.out.print(jieCheng(5));
	}
}
