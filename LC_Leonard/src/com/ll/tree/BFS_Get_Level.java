package com.ll.tree;

public class BFS_Get_Level {
	
//	public int findLeveL(TreeNode root, int target){
//		int answer = -1;
//		findLevelHelper(root, target, 1, answer);
//		return answer;
//	}
//	
//	private void findLevelHelper(TreeNode root, int target, int curlevel, int answer) {
//
//		if (root == null) {
//			answer = -1;
//		} else if (root.val == target) {
//			answer = curlevel;
//		} else {
//			findLevelHelper(root.left, target, curlevel + 1, answer);
//			if (answer == -1) {
//				findLevelHelper(root.left, target, curlevel + 1, answer);
//			}
//		}
//	}
	
	public int findLeveL(TreeNode root, int target) {

		return helper(root, target);
	}

	private int helper(TreeNode root, int target) {
		if (root == null) {
			return 0;
		} else if (root.val == target) {
			return 1;
		}

		if (root.val < target) {
			return helper(root.right, target);
		} else {
			return helper(root.left, target);
		}
	}

}
