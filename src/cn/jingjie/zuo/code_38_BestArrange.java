package cn.jingjie.zuo;

import java.util.Arrays;
import java.util.Comparator;

// ���鰲�ţ���ΰ��Ÿ���Ļ��飬̰�Ĳ��ԣ��Ի������ʱ������
public class code_38_BestArrange {
	// ��֯����
	public static class Program {
		public int start;
		public int end;
		
		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	// ʵ���Ի������ʱ��ȽϵıȽ���
	public static class endComparator implements Comparator<Program>{
		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}
	}
	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new endComparator());
		int result = 0;
		for(int i=0; i < programs.length; i++) {
			if(start <= programs[i].start) {
				result++;
				start = programs[i].end;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Program p1 = new Program(7, 8);
		Program p2 = new Program(7, 9);
		Program p3 = new Program(8, 10);
		Program p4 = new Program(9, 12);
		Program p5 = new Program(13, 15);
		Program p6 = new Program(14, 15);
		Program p7 = new Program(16, 19);
		Program[] programs = {p1, p2, p3, p4, p5, p6, p7};
		System.out.print(bestArrange(programs, 9));
	}
}
