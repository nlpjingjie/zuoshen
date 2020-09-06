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
    	// basecase j�ľ������iҲ�ľ��򷵻�true
        if(j == pattern.length){
            return i == str.length;
        }
        // jû�ľ�,j֮����*�����
        if(j+1 == pattern.length || pattern[j+1] != '*'){
        	// ע��i�ı߽������Ҫ���
            return i != str.length && (pattern[j] == str[i] || pattern[j] == '.') && process(str, pattern, i+1, j+1);
        }
        // jû�ľ���j֮����*�����
        while(i < str.length && (pattern[j] == str[i] || pattern[j] == '.')){
            if(process(str, pattern, i, j+2)){
                return true;
            }
            i++;
        }  
        // jû�ľ���j֮����*�����,����i��j�޷�ƥ��
        return process(str, pattern, i, j+2);
    }
}
