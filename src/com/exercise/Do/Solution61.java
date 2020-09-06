package com.exercise.Do;

import java.util.LinkedList;
import java.util.Queue;

import com.exercise.Do.Solution62.TreeNode;

public class Solution61 {
	  String Serialize(TreeNode root) {
	        
	        if(root == null){
	            return "#!";
	        }
	        String str = root.val + "!";
	        str += Serialize(root.left);
	        str += Serialize(root.right);
	        return str;
	  }
	    
	    TreeNode Deserialize(String str) {
	       String[] chs = str.split("!");
	       Queue<String> q = new LinkedList<>();
	       for(int i=0; i < chs.length; i++){
	            q.offer(chs[i]);
	        }
	        
	       return Deserial(q);
	  }
	    
	    private TreeNode Deserial(Queue<String> q){
	        String vs = q.poll();
	        if(vs.equals("#")){
	            return null;
	        }
	        TreeNode n = new TreeNode(Integer.valueOf(vs));
	        n.left = Deserial(q);
	        n.right = Deserial(q);
	        return n;
	    }
}
