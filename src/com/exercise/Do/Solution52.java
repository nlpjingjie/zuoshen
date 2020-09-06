package com.exercise.Do;

public class Solution52 {
	public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
            return false;
        }
        return process(str, pattern, 0, 0);
    }
    
    public static boolean process(char[] str, char[] pattern, int i, int j){
    	// basecase j耗尽。如果i也耗尽则返回true
        if(j == pattern.length){
            return i == str.length;
        }
        // j没耗尽,j之后不是*的情况
        if(j+1 == pattern.length || pattern[j+1] != '*'){
        	// 注意i的边界情况需要检查
            return i != str.length && (pattern[j] == str[i] || pattern[j] == '.') && process(str, pattern, i+1, j+1);
        }
        // j没耗尽，j之后是*的情况
        while(i < str.length && (pattern[j] == str[i] || pattern[j] == '.')){
            if(process(str, pattern, i, j+2)){
                return true;
            }
            i++;
        }  
        // j没耗尽，j之后是*的情况,并且i和j无法匹配
        return process(str, pattern, i, j+2);
    }
}
