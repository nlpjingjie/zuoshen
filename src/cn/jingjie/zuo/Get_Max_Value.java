package cn.jingjie.zuo;


public class Get_Max_Value {
	public static int  getMax(int[] arr, int left, int right) {
		if (left==right) {
			return arr[left];
		}
		int midindex = (left+right)/2;
		int leftMax = getMax(arr, left, midindex);
		int rightMax = getMax(arr, midindex+1, right);
		return Math.max(leftMax, rightMax);
	}
	
	public static void main(String[] args) {
		int[] arr = {3,5,67,88,9,1,54};
		int maxvalue = getMax(arr, 0, arr.length-1);
		System.out.println(maxvalue);
	}
}
