package cn.jingjie.zuo.advanced;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// ���õ�������ջ��������Ӿ���Ĵ�С(����1�γɵľ���)
// ������ÿ��Ϊ�ף���ֱ��ͼ�ҵ���������Σ��������ֵ
public class Code_06_GetMaxSubMatrix {
	public static int getMaxSubMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxArea = 0;
		// �ռ��Ե�i��Ϊ�׵�ֱ��ͼ
		int[] helpArr = new int[matrix[0].length];
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				// �ػ�Ϊ0������Ϊ0���Ϸ���0���Ѿ��������
				helpArr[j] = matrix[i][j] == 0 ? 0:helpArr[j] + 1;
			}
			System.out.println(Arrays.toString(helpArr));
			// ֱ��ͼ�ҵ�������
			maxArea  = Math.max(getRec(helpArr), maxArea);
		}
		return maxArea;
	}

	public static int getRec(int[] helpArr) {
		// ��������ջ����һ�����εĸ߶��޷���չʱ��������
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxArea = 0;
		for(int i = 0; i < helpArr.length; i++) {
			// ������ȵ�ֵ���㣬��Ӱ�����Ľ��
			while(!stack.isEmpty() && helpArr[i] <= helpArr[stack.peek()]) {
				// ȡ��ǰ,������θ�
				int cur = stack.pop();
				// ȡǰһ�����±꣬��i�����þ��ο�
				int pre = stack.isEmpty() ? -1:stack.peek();
				// ������������cur��i֮����ܴ��ڱ�����ľ��Σ�cur���ұ߽�Ͳ���cur����
				// int curArea = (cur - pre)*helpArr[cur];
				int curArea = (i - pre -1)*helpArr[cur];
				// System.out.print(curArea + " ");
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		
		// ջ�л���Ԫ�أ���ʱ�ұ߽翪��
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			// ȡǰһ�����±꣬�����þ��ο�
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
