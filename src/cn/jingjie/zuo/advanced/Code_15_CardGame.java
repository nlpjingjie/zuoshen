package cn.jingjie.zuo.advanced;


// 排成一条线的纸牌博弈问题
// 一个数组，两个人，每个人必须只能从两头取牌，返回最后胜者的分数，求取得最大的牌
public class Code_15_CardGame {
	public static int cardGame(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length-1));
	}

	private static int f(int[] arr, int i, int j) {
		if(i == j) {
			return arr[i];
		}
		return Math.max(arr[i] + s(arr, i+1, j), arr[j] + s(arr, i, j-1));
	}

	private static int s(int[] arr, int i, int j) {
		// 作为后拿者，剩下最后一个元素的时候是拿不到数据的。
		if(i == j) {
			return 0;
		}
		// 先拿着作为绝顶聪明的人，它的选择会尽量让后拿着获得更小的分数
		return Math.min(f(arr, i+1, j), f(arr, i, j-1));
	}
	
	// 1.确定可变参数范围。---->递归函数的参数变化范围
	// 2.分析basecase。---->边界情况的返回结果。
	// 3.分析一般情况的依赖关系。---->递归函数的返回情况。
	public static int cardGame2(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		
		for(int i=0; i < arr.length; i++) {
			f[i][i] = arr[i];
		}
		
		for(int j=1; j < arr.length; j++) {
			for(int i=0; i < arr.length-j; i++ ) {
				f[i][j+i] = Math.max(arr[i] + s[i+1][j+i], arr[j+i] + s[i][j+i-1]);
				s[i][j+i] = Math.min(f[i+1][j+i], f[i][j+i-1]);
			}
		}
		
		return Math.max(f[0][arr.length-1], s[0][arr.length-1]);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 100, 4};
		int[] arr1 = {1, 100, 2};
		System.out.println(cardGame(arr));
		System.out.println(cardGame(arr1));
		
		System.out.println(cardGame2(arr));
		System.out.println(cardGame2(arr1));
	}
}
