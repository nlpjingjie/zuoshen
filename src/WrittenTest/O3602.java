package WrittenTest;

import java.util.Scanner;



public class O3602 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int[] str1 = new int[N];
		int[] str2 = new int[M];
		
		for(int i=0; i < N; i++) {
			str1[i] = i+1;
		}
		
		for(int j=0; j < M; j++) {
			str2[j] = in.nextInt();
		}
		
		for(int k=0; k < M; k++) {
			if(str2[k] == 1) {
				str1 = moveToEnd(str1);
			}else if(str2[k] == 2) {
				change(str1);
			}
		}
		
		for(int i=0; i < N; i++) {
			System.out.print(str1[i] + " ");
		}
	}

	private static void change(int[] arr) {
		for(int i=0; i < arr.length; i += 2) {
			int help = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = help;
		}
		
	}

	private static int[] moveToEnd(int[] arr) {
		int[] arrNew = new int[arr.length];
		arrNew[arr.length-1] = arr[0];
		for(int i=0; i < arr.length - 1; i++) {
			arrNew[i] = arr[i+1];
		}
		return arrNew;
	}
	
}
