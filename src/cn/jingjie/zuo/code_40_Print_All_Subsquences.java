package cn.jingjie.zuo;

// 打印一个字符串的所有子序列
public class code_40_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}
	
	public static void printAllSub(char[] chs, int i, String res) {
		if(i == chs.length) {
			System.out.println(res);
			return;
		}
		// 碰到任何一个字符都可以选择要还是不要
		printAllSub(chs, i+1, res);
		printAllSub(chs, i+1, res + String.valueOf(chs[i]));
	}
	
	public static void main(String[] args) {
		String test = "abc";
//		printAllSubsquence(test);
//		// char c = 0; 代表字符为空
		printAllSub(test.toCharArray(), 0, "");
	}
}
