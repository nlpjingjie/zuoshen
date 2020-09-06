package cn.jingjie.zuo;

// 母牛问题，开始一头母牛，小牛三年成熟，每一年生一只母牛。第n年有几头牛。
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
