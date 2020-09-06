package WrittenTest;

import java.util.Scanner;

public class QuShi2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n < 1 || n > 20) {
			System.out.println("error");
			return;
		}
		
		int[][] nums = new int[n][n];
		int index = 1;
		int left = 0;
		int right = n-1;
		int up = 0;
		int down = n - 1;
		while(true) {
			for(int i=up; i <= down; i++) {
				nums[i][right] = index++;
			}
			right--;
			if(left > right || up > down) break;
			for(int j=right; j >= left; j--) {
				nums[down][j] = index++;
			}
			down--;
			if(left > right || up > down) break;
			for(int i=down; i >= up; i--) {
				nums[i][left] = index++;
			}
			left++;
			if(left > right || up > down) break;
			for(int j = left; j <= right; j++) {
				nums[up][j] = index++;
			}
			up++;
			if(left > right || up > down) break;
		}
		
		for(int i=0; i < n; i++) {
			for(int j=0; j < n; j++) {
				System.out.print(String.format("%4d", nums[i][j]));
			}
			if(i < n-1) {
				System.out.println();
			}
		}
	}
}
