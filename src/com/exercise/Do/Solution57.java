package com.exercise.Do;

import java.util.Deque;
import java.util.LinkedList;

public class Solution57 {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {   
        if(pNode == null){
            return null;
        }
        
        TreeLinkNode root = pNode;
        while(root.next != null){
            root = root.next;
        }
        
        boolean flag = false;
        Deque<TreeLinkNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                if(flag){
                    return root;
                }
                flag = root == pNode ? true:flag;
                root = root.right;
            }
        }
        return null;
    }
}
