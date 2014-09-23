package com.ll.LinkedList;

/*
 * https://oj.leetcode.com/problems/reorder-list/
 */
public class Reorder_List {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode mid = findMiddle(head);
		ListNode tail = reverse(mid.next);
		mid.next = null;
		merge(head, tail);
	}

	private ListNode reverse(ListNode head) {

		ListNode newHead = null;

		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private void merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		int index = 0;

		while (l1 != null && l2 != null) {

			if (index % 2 == 0) {
				dummy.next = l1;
				l1 = l1.next;
			} else {
				dummy.next = l2;
				l2 = l2.next;
			}
			index++;
			dummy = dummy.next;
		}

		if (l1 != null) {
			dummy.next = l1;
		} else {
			dummy.next = l2;
		}
	}
}
