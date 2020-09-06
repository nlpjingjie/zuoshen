package com.exercise.Do;

/*
 * 题目描述
在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/
public class TwoDimensionSerach1 {
	// 从右上或者左下开始查找，因为每次判断可以排除一行或者一列的影响
	public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) return false;
        
        int LD1 = array.length-1;
        int LD2 = 0;
        
        while(LD1 > -1 && LD2 < array[0].length){
            if(array[LD1][LD2] > target){
                LD1--;
            }else if(array[LD1][LD2] < target){
                LD2++;
            }else{
                return true;
            }
        }
        
        return false;
    }
}
