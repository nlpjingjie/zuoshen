package TestAbout;
import java.util.*;

/*
next() 读字符串遇空格或换行停
nextLine() 读字符串遇换行停
nextInt()及一系列  读该类型的数字，遇空格或换行停

貌似都没行尾换行符
*/
public class TestInput {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(s.hasNextInt()) {
			System.out.println(s.nextInt());
		}
	}
}
