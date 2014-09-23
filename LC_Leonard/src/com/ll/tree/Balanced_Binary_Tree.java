package com.ll.tree;
/*
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 */
public class Balanced_Binary_Tree {
	public boolean isBalanced(TreeNode root) {
		return maxDepth(root) != -1;
	}

	private int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		//Math.abs(left - right) 高度差绝对值大于1 即为不平衡
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		
		//返回左右最大深度+1为当前子树深度
		return Math.max(left, right) + 1;
	}
}
