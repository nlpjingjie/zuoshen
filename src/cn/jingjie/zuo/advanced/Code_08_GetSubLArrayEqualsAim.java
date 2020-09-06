package cn.jingjie.zuo.advanced;

import java.util.HashMap;

// ����Ŀ��ֵ�������ۼӺ͵���aim���������.   �����е����ݿ�������0
// ��map��¼�����ۼӺ�sum,������һ�γ��ֵ�λ�á���map�в���sum-aim�Ƿ���ֹ��������鳤�Ⱦ���sum-aim��������sum������
public class Code_08_GetSubLArrayEqualsAim {
	public static int getSubArray(int[] arr, int aim) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		
		int res = 0;
		int sum = 0;
		// map��¼�����ۼӺ�sum,������һ�γ��ֵ�λ��
		HashMap<Integer, Integer> map = new HashMap<>(); 
		for(int i=0; i < arr.length; i++) {
			sum += arr[i];
			if(map.containsKey(sum - aim)) {
				res = Math.max(res, i - map.get(sum - aim));
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return res;
	}
	
	// ��һ�����飬��������ż����ȵ��������
	// ��������1��ż����0����ż��Ŀ��ȵ��������Ϊ0
	public static int getSubArrayOddEEvent(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int[] helpArr = new int[arr.length];
		
		for(int i=0; i < arr.length; i++) {
			if(arr[i]%2 == 0) {
				helpArr[i] = -1;
			}else {
				helpArr[i] = 1;
			}
		}
		
		int res = 0;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>(); 
		for(int i=0; i < helpArr.length; i++) {
			sum += helpArr[i];
			if(map.containsKey(sum)) {
				res = Math.max(res, i - map.get(sum));
				if(sum == 0) {
					res = Math.max(res, i+1);
				}
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {8, 4, 5, 6, 2, 3, 2, 2, 5, 1};
		System.out.println(getSubArray(arr, 15));
		System.out.println(getSubArrayOddEEvent(arr));
	}
}
