package cn.jingjie.zuo;

import java.util.Arrays;
import java.util.Comparator;


//给定一个字符串数组，排成一个字典序最小的字符串
public class code_34_LowestLexicography {
	// 构造比较器
	public static class StrComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			return (o1 + o2).compareTo(o2 + o1);
		}
	}
	
	public static String lowestString(String[] s) {
		if(s == null || s.length == 0) {
			return "";
		}
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		Arrays.sort(s, new StrComparator());
		System.out.println(Arrays.toString(s));
		String result = "";
		for(int i=0; i < s.length; i++) {
			result += s[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] strings = {"nixiang", "wozai", "beizi", "lide", "shufu", "aoao", "b", "ba"};
		String r = lowestString(strings);
		System.out.print(r);
	}
}
