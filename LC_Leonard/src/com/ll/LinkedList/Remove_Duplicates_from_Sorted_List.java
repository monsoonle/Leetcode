package com.ll.LinkedList;

import com.ll.LinkedList.Reverse_linked_list_ii.ListNode;

/***
 * 
 * @author Le
 *
 *         https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Remove_Duplicates_from_Sorted_List {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		// 维护两个指针，一个指向当前不重复的最后一个元素，一个进行依次扫描，遇到不重复的则更新第一个指针，继续扫描，否则就把前面指针指向当前元素的下一个（即把当前元素从链表中删除）。
		//时间上只需要一次扫描，所以是 O(n)，空间上两个额外指针，是 O(1)。

		while (node.next != null) {
			if (node.val == node.next.val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}
}
