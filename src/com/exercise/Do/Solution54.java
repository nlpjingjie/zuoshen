package com.exercise.Do;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution54 {
	HashMap<Character, Integer> map = new HashMap<>();
    Queue<Character> q = new LinkedList<>();
    
    public void Insert(char ch)
    {
        if(!map.containsKey(ch)){
            q.offer(ch);
            map.put(ch, 1);
        }else{
            map.put(ch, map.get(ch)+1);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while(!q.isEmpty()){
            if(map.get(q.peek()) == 1){
                return q.peek();
            }else{
                q.poll();
            }
        }
        return '#';
    }
}
