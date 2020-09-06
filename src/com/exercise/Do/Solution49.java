package com.exercise.Do;

public class Solution49 {
	public static int StrToInt(String str) {
        if(!isValid(str)) return 0;
        
        // if(str == null || str.length() == 0) return 0;
        
        
        return strToInt(str);
    }
    
    public static boolean isValid(String str){
        return str.matches("([\\+\\-]\\d+)|\\d+");
    }
    
    public static int strToInt(String str){
        char[] chs = str.toCharArray();
        char sign = '+';
        int i = 0;
        if(chs[0] == '+' || chs[0] == '-'){
            if(chs[0] == '-') sign = '-';
            i++;
        }
        
        int res = chs[i]-'0';

        for(int j = i+1; j < chs.length; j++){
            res = res*10 + (chs[j] - '0');
            if(res > Integer.MAX_VALUE/10) {
            	res =  Integer.MAX_VALUE;
            	break;
            }
        }
        
        return sign == '-' ? res*(-1):res;
    }
    
    public static void main(String[] args) {
		String str = "+2147483647";
		String str1 = "+2147483648";
		System.out.println(StrToInt(str));
		System.out.println(StrToInt(str1));
	}
}
