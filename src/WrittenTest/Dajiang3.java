package WrittenTest;

import java.util.Scanner;


/*����ջ
 * 
 * ����һ���Ǹ��ġ��ַ�����ʽ���������֣����硰12353789����
�ַ����ĳ���Ҳ�����������ֵ�λ��������10000λ�������ַ���������0��ͷ��
СC��Ҫ��ѡ������K�����֣�KС���ַ����ĳ��ȣ���ɾ�����ǣ�
ʹ��ʣ���ַ�����µ���������С�ġ�
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
			// ���������ߵ�ͷɾ�����һ����������С��ɾ��ǰ����
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