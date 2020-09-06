package WrittenTest;

import java.util.ArrayList;
import java.util.Scanner;

// X×ÖĞÍÅÅÁĞ
public class Huawei3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ss = sc.nextLine().split(",");
		String s = ss[0];
		int n = Integer.parseInt(ss[1]);
		ArrayList<StringBuffer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(new StringBuffer());
		}
		int index = 0; 
		boolean flag = true;
		int curRow = 0;
		int go = 1;
		while(index < s.length()) {
			list.get(curRow).append(s.charAt(index++));
			if (curRow != n / 2 && index < s.length()) {
				list.get(n - curRow - 1).append(s.charAt(index++));
			}
			curRow += go;
			if (curRow == 0 || curRow == n / 2) {
				flag = !flag;
			}
			go = flag ? 1 : -1;
		}
		StringBuilder reStringBuffer = new StringBuilder();
		for(StringBuffer buffer : list) {
			reStringBuffer.append(buffer);
		}
		System.out.println(reStringBuffer.toString());
}
}
