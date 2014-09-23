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
		// ά������ָ�룬һ��ָ��ǰ���ظ������һ��Ԫ�أ�һ����������ɨ�裬�������ظ�������µ�һ��ָ�룬����ɨ�裬����Ͱ�ǰ��ָ��ָ��ǰԪ�ص���һ�������ѵ�ǰԪ�ش�������ɾ������
		//ʱ����ֻ��Ҫһ��ɨ�裬������ O(n)���ռ�����������ָ�룬�� O(1)��

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
