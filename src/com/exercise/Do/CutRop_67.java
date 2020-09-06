package com.exercise.Do;

import java.util.HashMap;
import java.util.Map;

// 剪绳子 暴力递归到动态规划
public class CutRop_67 {
	// 静态方法中使用
    public static Map<Integer, Integer> map = new HashMap<>();
    
    public int cutRope(int target) {
        if(target < 2 || target > 60){
            return 0;
        }
        
        return Math.max(process(target), target);
    }
    
    // cut
    // 递归改带备忘的动态规划
    public static int process(int n){
        if(n <= 4){
            return n;
        }
        int c = 1;
        // map中保存n对应的最大分割值
        if(map.containsKey(n)){
            return map.get(n);
        }
        for(int i=2; i <= n; i++){
            c = Math.max(i*process(n-i), c);
        }
        map.put(n, c);
        return c;
    }
}

//public class Solution {
//    
//    public int cutRope(int target) {
//        if(target <= 4){
//            return target;
//        }
//        int[] dp = new int[target+1]; 
//        for(int i = 0; i <= 4; i++){
//            dp[i] = i;
//        }
//        
//        for(int i=5; i < dp.length; i++){
//            for(int j=2; j <= i; j++){
//                dp[i] = Math.max(j*dp[i-j], dp[i]);
//            }
//        }
//        
//        return dp[target];
//    }
//}
