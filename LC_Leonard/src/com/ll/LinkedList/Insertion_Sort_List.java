package com.ll.LinkedList;

import com.ll.LinkedList.Reverse_linked_list_ii.ListNode;

public class Insertion_Sort_List {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
    public ListNode insertionSortList(ListNode head) {
       if (head == null){
    	   return head;
       }
       ListNode dummy = new ListNode(0);
       ListNode current = head;
       
       while (current != null){
    	   ListNode node = dummy;
    	   while (node.next != null && node.next.val < current.val){
    		   node = node.next;
    	   }
    	   
    	   //swap
    	   ListNode temp = current.next;
    	   current.next = node.next;
    	   node.next = current;
    	   current = temp;
    	   
       }
       return dummy.next;
       
    }
}
