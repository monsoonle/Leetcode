package com.ll.tree;

public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root){
        return maxDepthHelper(root);
    }
    
    private int maxDepthHelper(TreeNode root){
    	if (root == null){
    		return 0;
    	}
    	
    	int left = maxDepthHelper(root.left);
    	int right = maxDepthHelper(root.right);
    	
    	return Math.max(left, right) + 1;
    }

}
