package cn.jingjie.zuo;

import java.util.Arrays;
import java.util.HashSet;

// 打印一个字符串的字母全排列，要求不能有重复
public class code_42_PrintPermutations {
	// 对
	public static void printPermutations(char[] chs, int i) {
		if(i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		// 使用set去除同一递归层次重复的字符，达到去重的效果
		HashSet<Character> set = new HashSet<>(); 
		for(int j=i; j < chs.length; j++) {
			if(!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs, i, j);
				printPermutations(chs, i+1);
				// 每次递归结束恢复源字符串，保证正确递归到每个字符串。如：对于源"abc"  需要分别对"abc"、“bac”、"cba"进行递归
				// 如果不恢复，上次的递归结果会影响后面的递归结果
				swap(chs, i, j);
			}
		}
	}

	private static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
		
	}


	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "aba";
		
		printPermutations(s1.toCharArray(), 0);
		System.out.println("===");
		printPermutations(s2.toCharArray(), 0);
	}
	

/*	public static void printAllPermutations1(String str) {
		char[] chs = str.toCharArray();
		process1(chs, 0);
	}

	public static void process1(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		for (int j = i; j < chs.length; j++) {
			swap(chs, i, j);
			process1(chs, i + 1);
			swap(chs, i, j);
		}
	}

	public static void printAllPermutations2(String str) {
		char[] chs = str.toCharArray();
		process2(chs, 0);
	}

	public static void process2(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		HashSet<Character> set = new HashSet<>();
		for (int j = i; j < chs.length; j++) {
			if (!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs, i, j);
				process2(chs, i + 1);
				swap(chs, i, j);
			}
		}
	}

	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}

	public static void main(String[] args) {
		String test1 = "abc";
		printAllPermutations1(test1);
		System.out.println("======");
		printAllPermutations2(test1);
		System.out.println("======");

		String test2 = "acc";
		printAllPermutations1(test2);
		System.out.println("======");
		printAllPermutations2(test2);
		System.out.println("======");
	}*/
}