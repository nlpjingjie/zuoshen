package com.exercise.Do;

public class Solution62 {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}   
	   
	
	// 有问题，eclipse可以过，牛客不可以       跟调用方式有关，去掉静态变量，改成包作用域的可以正常。
	/*static TreeNode res = null;
    static int num = 0;
    
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        orderByIn(pRoot, k);
        return res;
    }

    public static void orderByIn(TreeNode root, int k){
        if(root == null){
            return;
        }
        
        orderByIn(root.left, k);
        num++;
        if(num == k){
            res = root;
        }
        orderByIn(root.right, k);
    }*/
    
    // 可以过
	static TreeNode KthNode(TreeNode pRoot, int k)
    {
        TreeNode[] res = new TreeNode[1];
        int[] num = new int[]{0};
        orderByIn(pRoot, num, res, k);
        return res[0];
    }
    
    public static void orderByIn(TreeNode root, int[] num, TreeNode[] res, int k){
        if(root == null){
            return;
        }
        
        orderByIn(root.left, num, res, k);
        num[0]++;
        if(num[0] == k){
            res[0] = root;
            
        }
        orderByIn(root.right, num, res, k);
    }
    
    // 用非递归的方式更好
//    TreeNode KthNode(TreeNode pRoot, int k)
//    {    
//        if(pRoot == null || k < 1){
//            return null;
//        }
//        int count = 0;
//        Deque<TreeNode> stack = new LinkedList<>();
//        while(!stack.isEmpty() || pRoot != null){
//            if(pRoot != null){
//                stack.push(pRoot);
//                pRoot = pRoot.left;
//            }else{
//                pRoot = stack.pop();
//                count++;
//                if(count == k){
//                    return pRoot;
//                }
//                pRoot = pRoot.right;
//            }
//        }
//        return null;
//    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(8);
    	root.left = new TreeNode(6);
    	root.right = new TreeNode(10);
    	root.left.left = new TreeNode(5);
    	root.left.right = new TreeNode(7);
    	root.right.left = new TreeNode(9);
    	root.right.right = new TreeNode(11);
    	
    	System.out.println(KthNode(root, 1).val);
	}
}
