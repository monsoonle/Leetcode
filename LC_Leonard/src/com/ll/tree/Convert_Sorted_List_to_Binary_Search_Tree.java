package com.ll.tree;

public class Convert_Sorted_List_to_Binary_Search_Tree {
	static ListNode head;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		this.head = head;
		ListNode cur = head;
		int size = 0;
		while (cur != null) {
			cur = cur.next;
			size++;
		}
		return helper(0, size - 1);
	}

	private TreeNode helper(int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		// LNR
		TreeNode leftNode = helper(left, mid - 1);
		TreeNode root = new TreeNode(head.val);
		root.left = leftNode;
		head = head.next;
		root.right = helper(mid + 1, right);
		return root;
	}
}
