package WrittenTest;


import java.util.Scanner;

// 有效的名字  要求：大小写字母  长度不超多10，返回有效名字的个数。
public class O3601 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int res = 0;
		for(int i=0; i < n; i++) {
			String s = in.next().trim();
			if(s.length() <= 10) {
				for(int j=0; j < s.length(); j++) {
					char c = s.charAt(j);
					if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
						if(j == s.length()-1) {
							res++;
						}
					}else {
						break;
					}
				}
			}
		}
		
		
		System.out.println(res);
	}
}
