package TestAbout;
import java.util.*;

/*
next() ���ַ������ո����ͣ
nextLine() ���ַ���������ͣ
nextInt()��һϵ��  �������͵����֣����ո����ͣ

ò�ƶ�û��β���з�
*/
public class TestInput {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(s.hasNextInt()) {
			System.out.println(s.nextInt());
		}
	}
}
