package com.exercise.Do;

public class Solution51 {
	public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        
        B[0] = 1;
        for(int i = 1; i < A.length; i++){
            B[i] = A[i-1]*B[i-1];
        }
        
        
        // tmp用来存储右边的连乘积
        int tmp = 1;
        for(int i = A.length-2; i >= 0; i--){
            tmp *= A[i+1];
            B[i] *= tmp;
        }
        
        return B;
    }
}
