package Answer;

import java.util.HashSet;
import java.util.Scanner;


public class MeiTuan1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int numsA = in.nextInt();
		int numsB = in.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i < numsA; i++) {
			set.add(in.nextInt());
		}
		int tmp = 0;
		int re = 0;
		for(int j=0; j < numsB; j++) {
			tmp = in.nextInt();
			if(set.contains(tmp)) {
				re++;
			}
		}
		
		System.out.println((numsA-re) + " " + (numsB-re) + " " + re);
	}
}
