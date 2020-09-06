package WrittenTest;

import java.util.Scanner;


public class O360r1 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine().trim();
		
		for(int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(i == 0 || c == 'n') {
				System.out.print((char)(c-32));
			}else {
				System.out.print(c);
			}
			
			if(i+1 < s.length() && s.charAt(i+1) == 'n') {
				System.out.println();
			}
		}
	}
}
