package com.ll.tree;

public class Sum_Root_to_Leaf_Numbers {
	public int sumNumbers(TreeNode root) {
		int sum = 0;
		return helper(root, sum);
	}

	private int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		//Ç°Ğò±éÀú, ¸ù×óÓÒ
		sum = sum * 10 + root.val;

		if (root.left == null && root.right == null) {
			return sum;
		}

		return helper(root.left, sum) + helper(root.right, sum);

	}

}
