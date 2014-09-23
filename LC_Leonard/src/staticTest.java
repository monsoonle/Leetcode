import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import com.ll.tree.Convert_Sorted_Array_to_Binary_Search_Tree;
import com.ll.tree.TreeNode;

public class staticTest {
	public static void hill(Integer[] v) {
		// Write your code here
		// To print results to the standard output you can use
		// System.out.println()
		// Example: System.out.println("Hello world!");
		if (v == null || v.length == 0) {
			System.out.println(0);
		}
		Integer[] original = v.clone();
		Arrays.sort(v);
		int max_difference = 0;

		for (int i = 0; i < v.length; i++) {
			int difference = Math.abs(original[i] - v[i]);
			max_difference = Math.max(difference, max_difference);
		}

		System.out.println(max_difference);
	}

	public TreeNode deleteBST(TreeNode root, int min, int max) {
		if (root == null) {
			return null;
		}
		root.left = deleteBST(root.left, min, max);
		root.right = deleteBST(root.right, min, max);

		if (root.val > max) {
			return root.left;
		} else if (root.val < min) {
			return root.right;
		}

		return root;
	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (root == null) {
			return rst;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;

		while (!stack.isEmpty() || current != null) {

			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			if (!stack.isEmpty()) {
				current = stack.pop();
				rst.add(current.val);
				current = current.right;
			}

		}
		return rst;

	}

	public static void main(String[] args) {
		staticTest demo = new staticTest();

	}
}
