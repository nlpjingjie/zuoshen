package cn.jingjie.zuo.advanced;

import java.util.Arrays;

// ��û����dp


// �����ַ���str������exp��.�ж�str�ܷ�expƥ��
// expû������������*��*Ҳ����exp�Ŀ�ͷ��exp�������ַ�ֻ��  . �� *�� 
public class Code_15_StringMatching {
	public static boolean stringMatching(String str, String exp) {
		if(str == null || exp == null) {
			return false;
		}
		
		char[] chStr = str.toCharArray();
//		System.out.println(Arrays.toString(chStr));
//		System.out.println(chStr.length);
		char[] chExp = exp.toCharArray();
		return process(chStr, chExp, 0, 0);
	}

	public static boolean process(char[] chStr, char[] chExp, int i, int j) {
//		// basecase j�ľ������iҲ�ľ��򷵻�true
//		if(j == chExp.length) {
//			return i == chStr.length;
//		}
//		
//		// jû�ľ�,j֮����*�����
//		if(j < chExp.length && (j+1 == chExp.length || chExp[j+1] != '*')) {
//			return (chStr[i] == chExp[j] || chExp[j] == '.') && process(chStr, chExp, i+1, j+1);
//		}
//		
//		// jû�ľ���j֮����*�����
//		while(i < chStr.length && (chStr[i] == chExp[j] || chStr[j] == '.')) {
//			if(process(chStr, chExp, i, j+2)) {
//				return true;
//			}
//			i++;
//		}
//		// jû�ľ���j֮����*�����,i��j�޷�ƥ��
//		return process(chStr, chExp, i, j+2);
		
		if (j == chExp.length) {
			return i == chStr.length;
		}
		if (j + 1 == chExp.length || chExp[j + 1] != '*') {
			return i != chStr.length && (chExp[j] == chStr[i] || chExp[j] == '.')
					&& process(chStr, chExp, i + 1, j + 1);
		}
		while (i != chStr.length && (chExp[j] == chStr[i] || chExp[j] == '.')) {
			if (process(chStr, chExp, i, j + 2)) {
				return true;
			}
			i++;
		}
		return process(chStr, chExp, i, j + 2);
	}
	
	// �д���
	public static boolean stringMatching2(String str, String exp) {
		if(str == null || exp == null) {
			return false;
		}
		
		char[] chStr = str.toCharArray();
//		System.out.println(Arrays.toString(chStr));
//		System.out.println(chStr.length);
		char[] chExp = exp.toCharArray();
		
		boolean[][] dp = new boolean[chStr.length+1][chExp.length+1];
		dp[chStr.length][chExp.length] = true;
		
		for(int i=chStr.length-1; i >= 0; i--) {
			// �����Ż�
			dp[i][chExp.length-1] = (chExp[chExp.length-1] == chStr[i] || chExp[chExp.length-1] == '.')
					&& dp[i + 1][chExp.length-1 + 1];
		}
		
		for(int j=chExp.length-2; j >= 0; j = j-2) {
			// dp�����һ��,str������
			if(chExp[j] != '*' && chExp[j+1] == '*') {
				dp[chStr.length][j] = true;
			}else {
				// һ����ǰdp����true,break����Ϊ���һ��ǰ���dp���������dp
				break;
			}
		}
		
		for(int i = chStr.length-1; i >= 0; i--) {
			for(int j = chExp.length - 2; j >= 0; j--) {
				if(chExp[j+1] != '*') {
					dp[i][j] = (chExp[j] == chStr[i] || chExp[j] == '.')
							&& dp[i + 1][j + 1];
				}else {
					int tmp = i;
					while(tmp != chStr.length && (chExp[j] == chStr[i] || chExp[j] == '.')) {
						if(dp[tmp][j+2]) {
							dp[i][j] = true;
							break;
						}
						tmp++;
					}
					dp[i][j] = dp[i][j+2];
				}
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		String str1 = "abcd";
		String exp1 = ".*";
		System.out.println(stringMatching(str1, exp1));
		System.out.println(stringMatching2(str1, exp1));
		
		
		String str2 = "";
		String exp2 = "..*";
		
		System.out.println(stringMatching(str2, exp2));
		System.out.println(stringMatching2(str2, exp2));
	}
}
