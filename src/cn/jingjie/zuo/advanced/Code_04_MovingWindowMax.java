package cn.jingjie.zuo.advanced;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 窗口大小为W，维持滑动窗口内的最大值，更新结构使用单调双向队列
public class Code_04_MovingWindowMax {
	public static int[] movingWindowMax(int[] arr, int W) {
		if(arr == null || arr.length ==0 || W < 1) {
			return new int[]{};
		}
		int[] res = new int[arr.length - W + 1]; 
		int index = 0;
		int L = 0;
		Deque<Integer> updateMax = new LinkedList<>();
		for(int R=0; R < arr.length; R++) {
			// 超出窗口大小，如果队列第一个元素等于窗口左侧L，说明此元素已经失效，队列从头部丢掉一个元素，L向右走
			if(R - L == W) {
				if(updateMax.getFirst() == L) {
					updateMax.pollFirst();
				}
				L++;
			}
			// 压入的元素比队尾大，从队尾删除元素
			while(!updateMax.isEmpty() && arr[R] >= arr[updateMax.getLast()]) {
				updateMax.pollLast();
			}
			updateMax.offerLast(R);
			// 窗口大小等于W,取当前窗口最大值,
			if(R - L == W - 1) {
				res[index++] = arr[updateMax.getFirst()];
				// System.out.print(arr[updateMax.getFirst()]);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 4, 7, 8, 4, 5, 6, 2, 4, 1};
		int[] arr1 = {4, 3, 5, 4, 3, 3, 6, 7};
		int[] r = movingWindowMax(arr1, 3);
		System.out.print(Arrays.toString(r));
	}
}
