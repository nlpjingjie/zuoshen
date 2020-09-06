package cn.jingjie.zuo.advanced;

import java.util.Arrays;


// manacher算法，找出一个字符串中的最长回文子串
public class Code_02_Manacher {
	public static char[] manacherString(String str) {
		char[] chs = str.toCharArray();
		char[] res = new char[chs.length*2 + 1];
		// chs的索引
		int index = 0;
		for(int i=0; i != res.length; i++) {
			// 给偶数位添加字符
			res[i] = (i&1) == 0 ? '#' : chs[index++];
		}
		
		return res;
	}
	
	/*
	 * manacher算法
	 * 回文右边界，R
	 * 回文右边界中心,C
	 * 回文半径数组,pArr
	*/
	public static int maxLength(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		char[] manacherStr = manacherString(str);
		int C = -1;
		int R = -1;
		int max = Integer.MIN_VALUE;
		int[] pArr = new int[manacherStr.length];
		for(int i=0; i < manacherStr.length; i++) {
			// i关于C的对称点的回文半径，与i到回文右边界的距离
			// 下面是i在R内，i'的回文半径在L内和L外的情况。可以继续跳到下一个元素扩，这里向右扩并不影响结果，因为会扩充失败。
			pArr[i] = i < R ? Math.min(pArr[2*C - i], R-i):1;
			
			// i在R外和i在R内，i'的回文半径在L上
			while(i + pArr[i] < manacherStr.length && i - pArr[i] > -1) {
				if(manacherStr[i + pArr[i]] == manacherStr[i - pArr[i]]) {
					pArr[i]++;
				}else {
					break;
				}
			}
			// 更新回文右边界和回文右边界中心
			if(i + pArr[i] > R) {
				R = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		System.out.println(Arrays.toString(pArr));
		return max-1;
	}
	
	public static void main(String[] args) {
		String str = "ABCABA";
		String str1 = "ABCABABAC";
		char[] r = manacherString(str);
////		char[] r1 = manacherString(str);
		System.out.println(Arrays.toString(r));
////		System.out.println(Arrays.toString(r1));
		System.out.println(maxLength(str));
//		System.out.println(maxLength(str1));
	}
}
