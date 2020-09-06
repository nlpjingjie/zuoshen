package Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeiTuan3 {
	/*
	 * 式子求值
时间限制： 3000MS
内存限制： 655360KB
题目描述：
小团有一个序列a，下标从1开始直到n，分别为a1 , a2 ...  an 。现在，小团定义了以下式子： 



现在小团想让小美回答的值

其中，⊕代表异或运算，请你帮助小美。





输入描述
输入第一行包含一个整数n，表示序列 a 的长度。

接下来一行 n 个数，空格隔开，第 i 个数表示ai

n≤100000 , 0≤ai≤n

输出描述
输出包含一个数，即题干中所求的值
	 * */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> arr = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			arr.add(in.nextInt());
		}
		
		for(int j = 0; j < n; j++) {
			res.add(getNum(arr.get(j), j+1, n));
		}
//		System.out.println(Arrays.toString(res));
		int ans = 0;
		for(int x:res) {
			ans ^= x;
		}
		System.out.println(ans);
	}

	private static int getNum(int num, int index, int n) {
		int res = num;
		for(int i = 1; i <= n; i++) {
			res ^= (index % i);
		}
		return res;
	}
}
