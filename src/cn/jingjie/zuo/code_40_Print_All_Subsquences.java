package cn.jingjie.zuo;

// ��ӡһ���ַ���������������
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
		// �����κ�һ���ַ�������ѡ��Ҫ���ǲ�Ҫ
		printAllSub(chs, i+1, res);
		printAllSub(chs, i+1, res + String.valueOf(chs[i]));
	}
	
	public static void main(String[] args) {
		String test = "abc";
//		printAllSubsquence(test);
//		// char c = 0; �����ַ�Ϊ��
		printAllSub(test.toCharArray(), 0, "");
	}
}
