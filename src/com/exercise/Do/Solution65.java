package com.exercise.Do;

// 矩阵中的路径
public class Solution65 {
//	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
//    {
//        
//        if(matrix.length < str.length){
//            return false;
//        }
//        
//        char[][] m = getCharArray(matrix, rows, cols);
//        
//        boolean f = false;
//        for(int i=0; i < rows; i++){
//            for(int j = 0; j < cols; j++){
//                // 从str的首字符开始dfs
//                if(m[i][j] == str[0]){
//                	// 因为每次递归的过程会改变m的值，影响下一次dfs的结果，所以每次都复制一份m
//                	// 可以在递归程序中回溯，不需要复制数组，见改进版
//                    char[][] m1 = getCharArray(matrix, rows, cols);
//                    f |= process(m1, i, j, str, 0);
//                }
//            }
//        }
//        
//        return f;
//    }
//    
//    public static boolean process(char[][] m, int i, int j, char[] str, int index){
//        if(i <0 || j < 0 || i >= m.length || j >= m[0].length || m[i][j] == '*'){
//            return false;
//        }
//        
//        if(m[i][j] != str[index]){
//            return false;
//        }
//        
//        m[i][j] = '*';
//        if(index == str.length-1){
//            return true;
//        }
//        
//        return process(m, i, j+1, str, index+1) || process(m, i+1, j, str, index+1) || process(m, i, j-1, str, index+1) || process(m, i-1, j, str, index+1);
//    }
//    
//    // 生成字符数组
//    public static char[][] getCharArray(char[] matrix, int rows, int cols){
//        char[][] m = new char[rows][cols];
//        
//        for(int i=0; i < rows; i++){
//            for(int j = 0; j < cols; j++){
//                m[i][j] = matrix[i*cols+j];
//            }
//        }
//        
//        return m;
//    }
	
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        
        if(matrix.length < str.length){
            return false;
        }
        
        char[][] m = getCharArray(matrix, rows, cols);
        
        boolean f = false;
        for(int i=0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                // 从str的首字符开始dfs
                if(m[i][j] == str[0]){
                    f |= process(m, i, j, str, 0);
                }
            }
        }
        
        return f;
    }
    
    public static boolean process(char[][] m, int i, int j, char[] str, int index){
        if(i <0 || j < 0 || i >= m.length || j >= m[0].length || m[i][j] == '*'){
            return false;
        }
        
        if(m[i][j] != str[index]){
            return false;
        }
        
        char tmp = m[i][j];
        m[i][j] = '*';
        if(index == str.length-1){
            return true;
        }
        
        // 如果四个方向都不能匹配
        if(process(m, i, j+1, str, index+1) || process(m, i+1, j, str, index+1) || process(m, i, j-1, str, index+1) || process(m, i-1, j, str, index+1)){
            return true;
        }
        // 回溯复原改变的字符
        m[i][j] = tmp;
        
        return false;
    }
    
    public static char[][] getCharArray(char[] matrix, int rows, int cols){
        char[][] m = new char[rows][cols];
        
        for(int i=0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                m[i][j] = matrix[i*cols+j];
            }
        }
        
        return m;
    }
}
