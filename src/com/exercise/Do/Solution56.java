package com.exercise.Do;

public class Solution56 {
	 public static class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
		}
	
	public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        
        ListNode head = null;
        
        ListNode pre = null;
        ListNode cur = pHead;
        ListNode deleted = null;
        
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                deleted = cur;
                cur = cur.next;
                if(pre != null){
                   pre.next = cur; 
                }
                while(cur != null && deleted.val == cur.val){
                    cur = cur.next;
                    if(pre != null){
                       pre.next = cur; 
                    }
                }
            }else{
                // pre第一次拿到节点为头
                if(pre == null){
                   head = cur;
                }
                pre = cur;
                cur = cur.next; 
            }
        }
        
        if(cur != null){
            if(head == null){
                head = cur;
            }
        }
        
        return head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next.next = new ListNode(1);
		
		ListNode res = deleteDuplication(head);
		
		if(res == null) {
			System.out.print("******");
		}
		
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		
	}
}
