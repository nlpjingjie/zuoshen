package cn.jingjie.zuo.advanced;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 运用单调递增栈，求最大子矩阵的大小(数字1形成的矩形)
// 依次以每行为底，求直方图找到最大正方形，返回最大值
public class Code_06_GetMaxSubMatrix {
	public static int getMaxSubMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxArea = 0;
		// 收集以第i行为底的直方图
		int[] helpArr = new int[matrix[0].length];
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				// 地基为0，则置为0。上方非0的已经计算过啦
				helpArr[j] = matrix[i][j] == 0 ? 0:helpArr[j] + 1;
			}
			System.out.println(Arrays.toString(helpArr));
			// 直方图找到最大矩形
			maxArea  = Math.max(getRec(helpArr), maxArea);
		}
		return maxArea;
	}

	public static int getRec(int[] helpArr) {
		// 单调递增栈，当一个矩形的高度无法扩展时，结算它
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxArea = 0;
		for(int i = 0; i < helpArr.length; i++) {
			// 遇到相等的值结算，不影响最后的结果
			while(!stack.isEmpty() && helpArr[i] <= helpArr[stack.peek()]) {
				// 取当前,计算矩形高
				int cur = stack.pop();
				// 取前一个的下标，与i计算获得矩形宽
				int pre = stack.isEmpty() ? -1:stack.peek();
				// 下面这行有误，cur到i之间可能存在被结算的矩形，cur的右边界就不是cur自身。
				// int curArea = (cur - pre)*helpArr[cur];
				int curArea = (i - pre -1)*helpArr[cur];
				// System.out.print(curArea + " ");
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		
		// 栈中还有元素，此时右边界开放
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			// 取前一个的下标，计算获得矩形宽
			int pre = stack.isEmpty() ? -1:stack.peek();
			int curArea = (helpArr.length - pre - 1)*helpArr[cur];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[][] m = {{1, 0, 1, 1},
					 {1, 1, 1, 1},
					 {1, 1, 1, 0}};
		int[] m2 = {3, 2, 3, 0};
		System.out.println(getMaxSubMatrix(m));
		
		System.out.println(getRec(m2));
	}
}
