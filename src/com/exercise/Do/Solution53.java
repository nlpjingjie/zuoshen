package com.exercise.Do;

public class Solution53 {
	
	public boolean isNumeric(char[] str) {
	boolean sign = false;
    boolean hasE = false;
    boolean hasdot = false;
    
    for(int i = 0; i < str.length; i++){
        if(str[i] == 'e' || str[i] == 'E'){
            if(hasE || i+1 == str.length) return false;
            hasE = true;
        }else if(str[i] == '+' || str[i] == '-'){
            if(sign && str[i-1] != 'e' && str[i-1] != 'E') return false;
            
            if(!sign && i != 0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
            
            sign = true;
        }else if(str[i] == '.'){
            if(hasdot || hasE) return false;
            
            if(!hasdot && i !=0 && (str[i-1] == 'e' || str[i-1] == 'E' || i+1 == str.length)) return false; 
            
            hasdot = true;
        }else if(str[i] >= '0' && str[i] <= '9'){
            
        }else{
            return false;
        }
    }
    return true;
}
}
