package cn.jingjie.zuo;

// ��ŵ�����⣬����һ�����ӣ���������n�����ϵ��±���ŵ����Ӳ����Ҵ���Ų����һ��������
public class code_39_Hanoi {
	
	// �����ݹ�
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
