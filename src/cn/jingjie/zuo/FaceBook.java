package cn.jingjie.zuo;

// ���ִ�ת�ַ������ж�����ת����1-a��2-b���ֶ�Ӧ26����ĸ
public class FaceBook {
	public static int number(char[] chs, int i) {
		if(i == chs.length) {
			return 1;
		}
		if(chs[i] == '0') {
			return 0;
		}
		
		if(chs[i] == '1') {
			int res = number(chs, i+1);
			// i+2����Խ��
			if(i+1 < chs.length) {
				res += number(chs, i+2);
			}
			return res;
		}

		if(chs[i] == '2') {
			int res = number(chs, i+1);
			// i+2����Խ��
			if(i+1 < chs.length && chs[i] >= '0' && chs[i] <= '6') {
				res += number(chs, i+2);
			}
			return res;
		}
		// �����������2������Ҫֱ��������һ��
		return number(chs, i+1);
	}
		
	
//		if (i == chs.length) {
//			return 1;
//		}
//		if (chs[i] == '0') {
//			return 0;
//		}
//		if (chs[i] == '1') {
//			int res = number(chs, i + 1);
//			if(i + 1 < chs.length) {
//				res += number(chs, i + 2);
//			}
//			return res;
//		}
//		if (chs[i] == '2') {
//			int res = number(chs, i + 1);
//			if (i + 1 < chs.length 
//					&& (chs[i + 1]  >= '0' && chs[i + 1]  <= '6')) {
//				res += number(chs, i + 2);
//			}
//			return res;
//		}
//		return number(chs, i+1);
//	}
//	
		
	public static void main(String[] args) {
		String string = "1132";
		System.out.print(number(string.toCharArray(), 0));
	}
}
