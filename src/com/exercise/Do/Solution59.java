package com.exercise.Do;
import java.util.*;

import com.exercise.Do.Solution62.TreeNode;

public class Solution59 {
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null){
            return new ArrayList<ArrayList<Integer> >();
        }
        ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
        // 使用两个栈代替队列
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        q1.offerLast(pRoot);
        TreeNode node = null;
        while(!q1.isEmpty() || !q2.isEmpty()){
            if(!q1.isEmpty()){
                ArrayList<Integer> p = new ArrayList<>();
                while(!q1.isEmpty()){
                    node = q1.pollLast();
                    p.add(node.val);
                    if(node.left != null){
                        q2.offerLast(node.left);
                    }
                    if(node.right != null){
                        q2.offerLast(node.right);
                    }
                }
                if(p.isEmpty()){
                    break;
                }
                a.add(p);
            }else{
                ArrayList<Integer> p = new ArrayList<>();
                while(!q2.isEmpty()){
                    node = q2.pollLast();
                    p.add(node.val);
                    if(node.right != null){
                        q1.offerLast(node.right);
                    }
                    if(node.left != null){
                        q1.offerLast(node.left);
                    }
                }
                if(p.isEmpty()){
                    break;
                }
                a.add(p);
            }
        }
        return a;
    }
}
