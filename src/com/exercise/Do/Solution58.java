package com.exercise.Do;

import com.exercise.Do.Solution62.TreeNode;

public class Solution58 {
	
	
    public static boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null || pRoot.left == null && pRoot.right == null){
            return true;
        }
        
        if(pRoot.left == null || pRoot.right == null){
            return false;
        }
        
        String str1 = serialBypre(pRoot.left);
        String str2 = serialBypre2(pRoot.right);
        System.out.println(str1);
        System.out.println(str2);
        return str1.equals(str2);
    }
    
    public static String serialBypre(TreeNode head){
        if(head == null){
            return "#!";
        }
        String res = head.val + "!";
        res += serialBypre(head.left);
        res += serialBypre(head.right);
        return res;
    }
    
    // 先序遍历序列化的变体
    public static String serialBypre2(TreeNode head){
        if(head == null){
            return "#!";
        }
        String res = head.val + "!";
        res += serialBypre2(head.right);
        res += serialBypre2(head.left);
        return res;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(3);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.left.left = new TreeNode(2);
    	root.left.left.left.left = new TreeNode(1);
    	root.right.right = new TreeNode(4);
    	root.right.right.right = new TreeNode(2);
    	root.right.right.right.right = new TreeNode(1);
    	
    	System.out.println(isSymmetrical(root));
	}
}
