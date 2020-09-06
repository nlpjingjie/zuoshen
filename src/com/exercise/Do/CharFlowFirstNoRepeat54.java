package com.exercise.Do;
import java.util.*;


/*
��Ŀ����
��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ��
��һ��ֻ����һ�ε��ַ���"g"��
���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
*/
public class CharFlowFirstNoRepeat54 {
	// ��hash �� queue ���������ݽṹ
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
