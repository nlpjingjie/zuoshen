package WrittenTest;

import java.util.Scanner;


//从字符矩阵中匹配到"CHINA"的个数
public class Didi2 {
	static int res = 0;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		String[] str = new String[n];
		for(int i=0; i < n; i++) {
			str[i] = in.next().trim();
		}
		
		
		String[] b = {"CHINA"};
		for(int i=0; i < n; i++) {
			for(int j=0; j < n; j++) {
				if(str[i].charAt(j) == 'C') {
					dfs(str, i, j, n, b, 0);
				}
			}
		}
		
		System.out.println(res);
	}
	
	static void dfs(String[] str, int i, int j, int n, String[] b, int index) {
		
		if(i < 0 || j < 0 || i >= n || j >= n || str[i].charAt(j) != b[0].charAt(index)) {
			return ;
		}
		// 成功一次，增加一次
		if(index == 4) {
			res++;
			return;
		}
		
		dfs(str, i-1, j, n, b, index+1);
		dfs(str, i+1, j, n, b, index+1);
		dfs(str, i, j-1, n, b, index+1);
		dfs(str, i, j+1, n, b, index+1);
	}
}
