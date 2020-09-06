package com.exercise.Do;
import java.util.*;


public class Solution63 {
	public static class myComparator implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2){
            return o2 - o1;
        }
    }
    
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new myComparator());
    
    public void Insert(Integer num) {
        if(minHeap.isEmpty()){
            minHeap.offer(num);
            return;
        }
        
        if(minHeap.peek() < num){
            minHeap.offer(num);
        }else{
            maxHeap.offer(num);
        }
        // µ÷ÕûÆ½ºâ
        if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.offer(minHeap.poll());
        }else if(minHeap.size() - maxHeap.size() < -1){
            minHeap.offer(maxHeap.poll());
        }
        
    }

    
    
    public Double GetMedian() {
        if((maxHeap.size() + minHeap.size()) % 2 == 0){
            return (Double.valueOf((maxHeap.peek()) + Double.valueOf(minHeap.peek()))/2);
        }else{
            Integer tmp = maxHeap.size() > minHeap.size() ? maxHeap.peek():minHeap.peek();
            return Double.valueOf(tmp);
        }
    }
}
