package cn.jingjie.zuo;

// ĸţ���⣬��ʼһͷĸţ��Сţ������죬ÿһ����һֻĸţ����n���м�ͷţ��
public class code_41_Cow {
	public static int cow(int n) {
		if(n < 1) {
			return 0;
		}
		if(n < 4) {
			return n;
		}
		return cow(n-1) + cow(n-3);
	}
	
	public static void main(String[] args) {
		System.out.print(cow(6));
	}
}
