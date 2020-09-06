package cn.jingjie.zuo.advanced;

import java.util.Arrays;

// kmp算法。给出字符串str1和str2，找到str2在str1中完全匹配的起始位置
public class Code_01_KMP {
	// 暴力O(N*M)
	public static int kmp(String str1, String str2) {
		
		if(str2 == null || str1 == null || str1.length() < str2.length()) {
			return -1;
		}
		
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		// 暴力循环
		for(int i=0; i < chs1.length; i++) {
			for(int j=0; j < chs2.length; j++) {
				if(chs1[i+j] != chs2[j]) {
					break;
				}
				if(j == chs2.length-1) {
					return i;
				}
			}
		}
		return -1;
	}
	
	// kmp
	public static int kmp2(String str1, String str2) {
		
		if(str2 == null || str1 == null || str1.length() < str2.length()) {
			return -1;
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		int[] next = getNextArray(chs2);
		System.out.println(Arrays.toString(next));
		int j = 0;
		// kmp,使用next数组进行加速比较
		for(int i=0; i < chs1.length; i++) {
			if(chs1[i] != chs2[j]) {
				if(next[j] > 0) {
					j = next[j];
					i--;
					continue;
				}else {
					j = 0;
					continue;
				}
			}
			j++;
			if(j == chs2.length) {
				return i-j+1;
			}
		}
		return -1;
	}
	
	private static int[] getNextArray(char[] chs2) {
		if(chs2.length == 1) {
			return new int[] {-1};
		}
		if(chs2.length == 2) {
			return new int[] {-1, 0};
		}
		int[] next = new int[chs2.length];
		next[0] = -1;
		next[1] = 0;
//		for(int i=2; i < chs2.length; i++) {
//			int index = next[i-1];
//			while(index >= 0) {
//				if(chs2[index] == chs2[i-1]) {
//					next[i] = next[index] + 1;
//					break;
//				}
//				index = next[index];
//			}
//			next[i] = 0;
//		}
		for(int i = 2; i < chs2.length; i++) {
			int preIndex = next[i-1];
			
			while(chs2[preIndex] != chs2[i-1]) {
				preIndex = next[preIndex];
				if(preIndex == -1) {
					break;
				}
			}
			if(preIndex != -1) {
//				next[i] = next[preIndex] + 1;
				next[i] = preIndex + 1;
			}else {
				next[i] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String s1 = "absabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsatabsabsateabsabsattabsabsaa";
		String s2 = "absabsatt";
		
		System.out.println(kmp(s1, s2));
		System.out.println(kmp2(s1, s2));
	}
}
