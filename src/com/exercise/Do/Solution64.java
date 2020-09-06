package com.exercise.Do;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// �������ڵ����ֵ
public class Solution64 {
	public ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        if(num == null || num.length < size){
            return new ArrayList<Integer>();
        }
        
        int left = 0;
        int right = 0;
        
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> maxValue = new ArrayList<>();
        while(right < num.length){
            while(!deque.isEmpty() && num[right] >= num[deque.getLast()]){
                deque.pollLast();
            }
            deque.offerLast(right);
            
            // �Ȱ����ݼӽ������ﵽ���ڴ�С��ʱ����������
            if(right - left + 1== size){
                maxValue.add(num[deque.getFirst()]);
                if(left == deque.getFirst()){
                    deque.pollFirst();
                }
                left++;
            }
            
            right++;
        }
        return maxValue;
    }
}
