package cn.jingjie.zuo.advanced;

import java.util.Arrays;


// manacher�㷨���ҳ�һ���ַ����е�������Ӵ�
public class Code_02_Manacher {
	public static char[] manacherString(String str) {
		char[] chs = str.toCharArray();
		char[] res = new char[chs.length*2 + 1];
		// chs������
		int index = 0;
		for(int i=0; i != res.length; i++) {
			// ��ż��λ����ַ�
			res[i] = (i&1) == 0 ? '#' : chs[index++];
		}
		
		return res;
	}
	
	/*
	 * manacher�㷨
	 * �����ұ߽磬R
	 * �����ұ߽�����,C
	 * ���İ뾶����,pArr
	*/
	public static int maxLength(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		char[] manacherStr = manacherString(str);
		int C = -1;
		int R = -1;
		int max = Integer.MIN_VALUE;
		int[] pArr = new int[manacherStr.length];
		for(int i=0; i < manacherStr.length; i++) {
			// i����C�ĶԳƵ�Ļ��İ뾶����i�������ұ߽�ľ���
			// ������i��R�ڣ�i'�Ļ��İ뾶��L�ں�L�����������Լ���������һ��Ԫ��������������������Ӱ��������Ϊ������ʧ�ܡ�
			pArr[i] = i < R ? Math.min(pArr[2*C - i], R-i):1;
			
			// i��R���i��R�ڣ�i'�Ļ��İ뾶��L��
			while(i + pArr[i] < manacherStr.length && i - pArr[i] > -1) {
				if(manacherStr[i + pArr[i]] == manacherStr[i - pArr[i]]) {
					pArr[i]++;
				}else {
					break;
				}
			}
			// ���»����ұ߽�ͻ����ұ߽�����
			if(i + pArr[i] > R) {
				R = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		System.out.println(Arrays.toString(pArr));
		return max-1;
	}
	
	public static void main(String[] args) {
		String str = "ABCABA";
		String str1 = "ABCABABAC";
		char[] r = manacherString(str);
////		char[] r1 = manacherString(str);
		System.out.println(Arrays.toString(r));
////		System.out.println(Arrays.toString(r1));
		System.out.println(maxLength(str));
//		System.out.println(maxLength(str1));
	}
}
