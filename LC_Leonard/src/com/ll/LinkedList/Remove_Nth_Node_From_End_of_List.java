package com.ll.LinkedList;

/*
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Given n will always be valid. Try to do this in one pass.
 */
public class Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0) {
			return head;
		}
		ListNode cur = head, runner = head;
		for (int i = 0; i < n; i++) {
			runner = runner.next;
		}
		// nth node is head
		if (runner == null) {
		    return head.next;
		}	
		while (runner.next != null){
			cur = cur.next;
			runner = runner.next;
		}
		cur.next = cur.next.next;
		return head;
	}
}
