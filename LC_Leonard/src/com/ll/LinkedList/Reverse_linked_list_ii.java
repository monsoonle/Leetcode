package com.ll.LinkedList;

/**
 * 
 * @author Le http://oj.leetcode.com/problems/reverse-linked-list-ii/
 */
public class Reverse_linked_list_ii {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode start = dummy;
		// find pre node
		for (int i = 0; i < m - 1; i++) {
			start = start.next;
		}

		// m node will be the tail after reverse
		ListNode end = start.next;
		ListNode current = start.next.next;

		for (int i = 0; i < n - m; i++) {
			ListNode next = current.next;
			current.next = start.next;
			start.next = current;
			current = next;
			// link tail to original list
			if (i == n - m - 1) {
				end.next = next;
			}
		}
		return dummy.next;
	}
}
