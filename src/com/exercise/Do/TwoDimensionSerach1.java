package com.exercise.Do;

/*
 * ��Ŀ����
��һ����ά�����У�ÿ��һά����ĳ�����ͬ����
ÿһ�ж����մ����ҵ�����˳������
ÿһ�ж����մ��ϵ��µ�����˳������
�����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
*/
public class TwoDimensionSerach1 {
	// �����ϻ������¿�ʼ���ң���Ϊÿ���жϿ����ų�һ�л���һ�е�Ӱ��
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
