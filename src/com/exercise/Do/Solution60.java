package com.exercise.Do;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.exercise.Do.Solution62.TreeNode;

public class Solution60 {
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null){
            return new ArrayList<ArrayList<Integer> >();
        }
        ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
        // 两个q轮流保存节点,q2保存q1的下一层，下次q1保存q2的下一层
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(pRoot);
        TreeNode node = null;
        while(!q1.isEmpty() || !q2.isEmpty()){
            if(!q1.isEmpty()){
                ArrayList<Integer> p = new ArrayList<>();
                while(!q1.isEmpty()){
                    node = q1.poll();
                    p.add(node.val);
                    if(node.left != null){
                        q2.offer(node.left);
                    }
                    if(node.right != null){
                        q2.offer(node.right);
                    }
                }
                if(p.isEmpty()){
                    break;
                }
                a.add(p);
            }else{
                ArrayList<Integer> p = new ArrayList<>();
                while(!q2.isEmpty()){
                    node = q2.poll();
                    p.add(node.val);
                    if(node.left != null){
                        q1.offer(node.left);
                    }
                    if(node.right != null){
                        q1.offer(node.right);
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
