package com.ll.Frequency_5;

/***
 * 
 * @author Le
 *
 *         http://oj.leetcode.com/problems/validate-binary-search-tree/
 */

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Validate_Binary_Search_Tree {
	public boolean isValidBST(TreeNode root) {

		
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private boolean helper(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		boolean isLeftValid = helper(root.left, min, root.val);
		boolean isRightValid = helper(root.right, root.val, max);

		if (isLeftValid && isRightValid) {
			return true;
		}
		return false;
	}
}
