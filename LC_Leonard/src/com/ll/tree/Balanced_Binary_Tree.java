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
		
		//Math.abs(left - right) �߶Ȳ����ֵ����1 ��Ϊ��ƽ��
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		
		//��������������+1Ϊ��ǰ�������
		return Math.max(left, right) + 1;
	}
}
