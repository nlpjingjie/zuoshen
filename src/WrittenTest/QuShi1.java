package WrittenTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 趋势科技，单源最短路径，没写出来
public class QuShi1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		List<Integer[]> list = new ArrayList<>();
		ArrayList<Integer> dis = new ArrayList<>();
		while(in.hasNextInt()) {
			Integer[] r = new Integer[2];
			r[0] = in.nextInt();
			r[1] = in.nextInt();
			list.add(r);
			
			int distance = getDistance(list.get(0), list.get(list.size()-1));
			dis.add(distance);
		}
		
		int res = 0;
		
		
		
		
		
	}

	private static int getDistance(Integer[] A, Integer[] B) {
		int a = A[0] - B[0];
		int b = A[1] - B[1];
		a = a < 0 ? -a:a;
		b = b < 0 ? -b:b;
		return a + b;
	}
}
