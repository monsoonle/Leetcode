package com.ll.LinkedList;

import com.ll.LinkedList.Reverse_linked_list_ii.ListNode;

/***
 * 
 * @author Le
 *
 *         https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-II/
 */
public class Remove_Duplicates_from_Sorted_List_II {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null){
    		return head;
    	}
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;
    	
    	while (head.next != null && head.next.next != null){
    		if (head.next.val == head.next.next.val){
    			int val = head.next.val;
    			while (head.next != null && head.next.val == val){
    				head.next = head.next.next;
    			}
    		}else{
    			head = head.next;
    		}
    	}
    	return dummy.next;
	}
}
