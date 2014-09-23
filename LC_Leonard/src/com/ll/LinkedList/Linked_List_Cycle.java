package com.ll.LinkedList;

/*
 *          https://oj.leetcode.com/problems/linked-list-cycle/
 *          http://oj.leetcode.com/problems/linked-list-cycle-ii/
 */
public class Linked_List_Cycle {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slow = head, fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		while (slow != head) {
			slow = slow.next;
			head = head.next;
		}
		return head;
	}

}
