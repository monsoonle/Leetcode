package com.ll.LinkedList;

import com.ll.LinkedList.Reverse_linked_list_ii.ListNode;

public class Sort_List {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = findMiddle(head);

		ListNode right = sortList(mid.next);
		// 断开链表保证两段排序
		mid.next = null;
		ListNode left = sortList(head);

		return mergeList(left, right);

	}

	private ListNode findMiddle(ListNode node) {
		ListNode slow = node, fast = node.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode mergeList(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode lastNode = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				lastNode.next = l2;
				l2 = l2.next;
			} else {
				lastNode.next = l1;
				l1 = l1.next;
			}
			lastNode = lastNode.next;
		}

		if (l1 != null) {
			lastNode.next = l1;
		} else {
			lastNode.next = l2;
		}

		return dummy.next;
	}
}
