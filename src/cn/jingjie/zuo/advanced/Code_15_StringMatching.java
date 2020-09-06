package cn.jingjie.zuo.advanced;

import java.util.Arrays;

// 还没进行dp


// 给定字符串str，给定exp。.判断str能否被exp匹配
// exp没有连续的两个*，*也不是exp的开头。exp的特殊字符只有  . 和 *。 
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
//		// basecase j耗尽。如果i也耗尽则返回true
//		if(j == chExp.length) {
//			return i == chStr.length;
//		}
//		
//		// j没耗尽,j之后不是*的情况
//		if(j < chExp.length && (j+1 == chExp.length || chExp[j+1] != '*')) {
//			return (chStr[i] == chExp[j] || chExp[j] == '.') && process(chStr, chExp, i+1, j+1);
//		}
//		
//		// j没耗尽，j之后是*的情况
//		while(i < chStr.length && (chStr[i] == chExp[j] || chStr[j] == '.')) {
//			if(process(chStr, chExp, i, j+2)) {
//				return true;
//			}
//			i++;
//		}
//		// j没耗尽，j之后是*的情况,i和j无法匹配
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
	
	// 有错误
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
			// 可以优化
			dp[i][chExp.length-1] = (chExp[chExp.length-1] == chStr[i] || chExp[chExp.length-1] == '.')
					&& dp[i + 1][chExp.length-1 + 1];
		}
		
		for(int j=chExp.length-2; j >= 0; j = j-2) {
			// dp的最后一行,str消耗完
			if(chExp[j] != '*' && chExp[j+1] == '*') {
				dp[chStr.length][j] = true;
			}else {
				// 一旦当前dp不是true,break。因为最后一行前面的dp依赖后面的dp
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
