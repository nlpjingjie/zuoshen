package cn.jingjie.zuo;

// 汉诺塔问题，借助一个杆子，将杆子上n个从上到下编完号的盘子不打乱次序，挪到另一个杆子上
public class code_39_Hanoi {
	
	// 暴力递归
	public static void hanoi(int n) {
		if(n > 0) {
			moveProcess(n, n, "left", "mid", "right");
		}
	}

	public static void moveProcess(int rest, int down, String from, String help, String to) {
		if(rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		}else {
			moveProcess(rest-1, down-1, from, to, help);
			moveProcess(1, down, from, help, to);
			moveProcess(rest-1, down-1, help, from, to);
		}
	}
	
	public static void main(String[] args) {
		hanoi(3);
	}
}
