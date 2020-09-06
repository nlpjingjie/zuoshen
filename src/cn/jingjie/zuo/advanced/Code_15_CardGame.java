package cn.jingjie.zuo.advanced;


// �ų�һ���ߵ�ֽ�Ʋ�������
// һ�����飬�����ˣ�ÿ���˱���ֻ�ܴ���ͷȡ�ƣ��������ʤ�ߵķ�������ȡ��������
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
		// ��Ϊ�����ߣ�ʣ�����һ��Ԫ�ص�ʱ�����ò������ݵġ�
		if(i == j) {
			return 0;
		}
		// ��������Ϊ�����������ˣ�����ѡ��ᾡ���ú����Ż�ø�С�ķ���
		return Math.min(f(arr, i+1, j), f(arr, i, j-1));
	}
	
	// 1.ȷ���ɱ������Χ��---->�ݹ麯���Ĳ����仯��Χ
	// 2.����basecase��---->�߽�����ķ��ؽ����
	// 3.����һ�������������ϵ��---->�ݹ麯���ķ��������
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
