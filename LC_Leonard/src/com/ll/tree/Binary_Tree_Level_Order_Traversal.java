package com.ll.tree;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size(); // get last level
			List<Integer> levelNode = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				levelNode.add(node.val);
			}
			result.add(levelNode);
		}
		return result;
	}

}
