package com.ll.LinkedList;
/*
 *  https://oj.leetcode.com/problems/partition-list/
 */
public class Partition_List {
	public ListNode partition(ListNode head, int x) {
		
		ListNode dummyLess = new ListNode(0);
		ListNode dummyMore = new ListNode(0);
		ListNode curLess = dummyLess;
		ListNode curMore = dummyMore;
		
		while (head != null){
			if (head.val < x){
				curLess.next = head;
				curLess = curLess.next;
			}else {
				curMore.next = head;
				curMore = curMore.next;
			}
			
			head = head.next;
		}
		
		curLess.next = dummyMore.next;
		curMore.next = null;
		
		return dummyLess.next;
	}
}
