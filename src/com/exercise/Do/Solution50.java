package com.exercise.Do;

import java.util.HashSet;

public class Solution50 {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length == 0 || length == 1){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int i=0; i < length; i++){
            if(set.contains(numbers[i])){
                res = 1;
                duplication[0] = numbers[i];
                break;
            }
            set.add(numbers[i]) ;
        }
        return res == 1 ? true:false;
    }
}
