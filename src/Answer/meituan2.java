package Answer;

import java.util.Scanner;

public class meituan2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int low = 0, large = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'a' && c <= 'z') {
				low++;
			}else {
				large++;
			}
		}
		
		System.out.println(Math.abs(large - low)/2);
	}
}
