package com.exercise.Do;

// 机器人走方格
public class Solution66 {
	
	
	public int movingCount(int threshold, int rows, int cols)
    {    
        if(rows == 0 && cols == 0){
            if(threshold < 0){
                return 0;
            }
            return 1;
        }
        int[][] arr = new int[rows][cols];
        
        process(arr, 0, 0, threshold, rows, cols);
        
        int res = 0;
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                res += arr[i][j] == 1 ? 1:0;
            }
        }
       
        return res;
    }
    
    public static void process(int[][] arr, int i, int j, int k, int M, int N){
        if(i < 0 || i >= M || j < 0 || j >= N){
            return;
        }
        boolean flag = getV(i, j, k);
        if(arr[i][j] == 1 || !flag){
            return;
        }
        arr[i][j] = 1;
        process(arr, i, j+1, k, M, N); 
        process(arr, i+1, j, k, M, N);
        process(arr, i, j-1, k, M, N);
        process(arr, i-1, j, k, M, N);
    }
    
    public static boolean getV(int i, int j, int k){
        i = dToSum(i);
        j = dToSum(j);
        return i+j <= k;
    }
    
    public static int dToSum(int i){
        if(i < 10){
            return i;
        }else{
            return i%10 + dToSum(i/10);
        }
    }
}
