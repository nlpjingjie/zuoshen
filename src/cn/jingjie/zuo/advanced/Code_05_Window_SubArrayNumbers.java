package cn.jingjie.zuo.advanced;

import java.util.Deque;
import java.util.LinkedList;


// 最大值减去最小值小于等于num的子数组数量，滑动窗口更新窗口内的最大值和最小值
// 如：以0开头的子数组，0到x范围都是达标的，0到x+是不达标的。数量是x+1个.
public class Code_05_Window_SubArrayNumbers {
	public static int subArrayNumbers(int[] arr, int num) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int res = 0;
		int L = 0;
		int R = 0;
		Deque<Integer> minQueue = new LinkedList<>();
		Deque<Integer> maxQueue = new LinkedList<>();
		while(L != arr.length) {
			while(R != arr.length) {
				// >= 等于的也要进行操作，因为越靠近右边的有效期越长
				while(!maxQueue.isEmpty() && arr[R] >= arr[maxQueue.getLast()]) {
					maxQueue.pollLast();
				}
				maxQueue.offerLast(R);
				while(!minQueue.isEmpty() && arr[R] <= arr[minQueue.getLast()]) {
					minQueue.pollLast();
				}
				minQueue.offerLast(R);
				// 
				if(arr[maxQueue.getFirst()] - arr[minQueue.getFirst()] > num) {
					break;
				}
				R++;
			}
			// 去除过期左边界的值
			if(minQueue.getFirst() == L) {
				minQueue.pollFirst();
			}
			if(maxQueue.getFirst() == L) {
				maxQueue.pollFirst();
			}
			res += R-L;
			L++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {6, 14, 26};
		System.out.print(subArrayNumbers(arr, 5));
	}
}
