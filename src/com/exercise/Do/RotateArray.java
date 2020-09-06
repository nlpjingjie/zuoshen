package com.exercise.Do;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] t = {1,3,4,5,6,7,8};
		Solution solve = new Solution();
		solve.rotate(t, 3);

	}
}

class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[k];
        for (int i=nums.length - k; i< nums.length;i++) {
        	temp[i-nums.length + k] = nums[i];
        }
        // int xcind = nums.length - k;
        for (int i=nums.length-k; i > 0 ; i--){
            nums[i+k-1] = nums[i-1];
        }
        for (int i=0;i<k;i++) {
        	nums[i] = temp[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}
