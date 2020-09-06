package cn.jingjie.zuo;



public class code_12_MaxGap {
	// һ�����飬�������֮����������������ֵ
	public static int maxGap(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		// �õ�������������ֵ����Сֵ
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
		// ����arr.length+1��Ͱ,ÿ��Ͱ��ά�����ֵ����Сֵ��Ͱ����ֵ�Ļ�����Ӧ��hasnumֵ��ΪTrue������Ϊ�ǿ�Ͱ��
		boolean[] hasnum = new boolean[arr.length+1];
		int[] min_in_bucket = new int[arr.length+1];
		int[] max_in_bucket = new int[arr.length+1];
		
		// �������齫ֵ�Ž���Ӧ��Ͱ��
		int b = 0;
		int len = arr.length;
		for(int i=0; i < arr.length; i++) {
			// �жϸ�ֵ�����Ǹ�Ͱ
			b = ofbucket(arr[i], min, max, len);
			// ���Ϊ��Ͱ��Ͱ������ֵ����Сֵ������ͬ��ֵ��������Ͱ��Ϊ�ǿ�Ͱ�����򣬸��¸�Ͱ�е����ֵ����Сֵ
			min_in_bucket[b] = hasnum[b] ? Math.min(arr[i], min_in_bucket[b]):arr[i];
			max_in_bucket[b] = hasnum[b] ? Math.max(arr[i], min_in_bucket[b]):arr[i];
			hasnum[b] = true;
		}
		// �ҵ��ǿ�Ͱ����������ǰһ���ǿ�����Ͱ�Ĳ�ֵ,�������ֵ��
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
