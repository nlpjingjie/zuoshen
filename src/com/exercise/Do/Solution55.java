package com.exercise.Do;

import com.exercise.Do.Solution56.ListNode;

public class Solution55 {
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {	
		
		// 同左区别在于初始赋值fast和last指针是否相同，这依赖于base的判断情况。
        if(pHead == null || pHead.next == null){
            return null;
        }
        
        ListNode last = pHead;
        ListNode fast= pHead;
        
        while(fast != null && fast.next != null){
            last = last.next;
            fast = fast.next.next;
            if(fast == last){
                break;
            }
        }
        
        if(fast == null || fast.next == null){
            return null;
        }
        
        fast = pHead;
        while(last != fast){
            last = last.next;
            fast = fast.next;
        }
        return last;
    }
}
