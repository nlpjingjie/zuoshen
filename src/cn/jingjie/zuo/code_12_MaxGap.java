package cn.jingjie.zuo;



public class code_12_MaxGap {
	// 一个数组，如果排序之后相邻两数的最大差值
	public static int maxGap(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		// 得到数组里面的最大值和最小值
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		if(min == max) {
			return 0;
		}
		return bucketLike(arr, min, max);
	}

	private static int bucketLike(int[] arr, int min, int max) {
		// 建立arr.length+1个桶,每个桶里维持最大值和最小值，桶里有值的话将对应的hasnum值变为True，即变为非空桶。
		boolean[] hasnum = new boolean[arr.length+1];
		int[] min_in_bucket = new int[arr.length+1];
		int[] max_in_bucket = new int[arr.length+1];
		
		// 遍历数组将值放进对应的桶中
		int b = 0;
		int len = arr.length;
		for(int i=0; i < arr.length; i++) {
			// 判断该值属于那个桶
			b = ofbucket(arr[i], min, max, len);
			// 如果为空桶，桶里的最大值和最小值赋给相同的值，并将空桶置为非空桶。否则，更新该桶中的最大值和最小值
			min_in_bucket[b] = hasnum[b] ? Math.min(arr[i], min_in_bucket[b]):arr[i];
			max_in_bucket[b] = hasnum[b] ? Math.max(arr[i], min_in_bucket[b]):arr[i];
			hasnum[b] = true;
		}
		// 找到非空桶，计算其与前一个非空相邻桶的差值,保留最大值。
		int max_value = Integer.MIN_VALUE;
		for(int i=1; i < len+1; i++) {
			if(hasnum[i]) {
				for(int j=i-1; j >=0; j--) {
					if(hasnum[j]) {
						max_value = Math.max(min_in_bucket[i]-max_in_bucket[j], max_value);
						break;
					}
				}
			}
		}
		return max_value;
	}

	private static int ofbucket(int c, int min, int max, int len) {
		return (int)((c-min)*len/(max-min));
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 2, 8, 9, 3, 6, 15};
		System.out.println(maxGap(arr));
	}
}
