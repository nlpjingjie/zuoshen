package WrittenTest;

import java.util.Scanner;


/*单调栈
 * 
 * 给定一个非负的、字符串形式的整形数字，例如“12353789”，
字符串的长度也就是整形数字的位数不超过10000位，并且字符串不会以0开头，
小C需要挑选出其中K个数字（K小于字符串的长度）并删掉他们，
使得剩余字符组成新的整数是最小的。
*/
public class Dajiang3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int k = in.nextInt();
		
		String res = rmdigits(s, k);
		System.out.println(res);
	}

	private static String rmdigits(String s, int k) {
		if(s == null || ("").equals(s) || ("").equals(s.trim()) || k == 0) {
			return s;
		}
		
		if(s.length() <= k || s.length() > 10000) {
			return "0";
		}
		
		StringBuilder sb = new StringBuilder(s);
		while(k > 0) {
			int i = 0;
			// 单调递增走到头删掉最后一个、遇到更小的删掉前面大的
			while(sb.length() - 1 > i && sb.charAt(i) <= sb.charAt(i+1)) {
				i++;
			}
			sb.delete(i, i+1);
			k--;
		}
		
		while(sb.length() != 0 && sb.charAt(0) == '0') {
			sb.delete(0, 1);
		}
		if(sb.length() == 0) {
			return "0";
		}
		
		return sb.toString();
	}
}