package com.exercise.Do;
import java.util.*;


/*
题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，
第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
*/
public class CharFlowFirstNoRepeat54 {
	// 用hash 和 queue 这两个数据结构
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
