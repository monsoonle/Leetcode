package com.ll.LinkedList;

public class Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode point = new ListNode(0);
		point.next = head;
		head = point;
		
		while (point.next != null && point.next.next != null){
			//  p->1->2->3->4

			ListNode temp = point.next.next.next;   //save 3
			point.next.next.next = point.next; // 2 -> 1
			point.next = point.next.next; // p -> 2
			point.next.next.next = temp;
			point = point.next.next;  
			
		}
		return head.next;
	}
}
