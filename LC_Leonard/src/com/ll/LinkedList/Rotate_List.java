package com.ll.LinkedList;
/*
 * https://oj.leetcode.com/problems/rotate-list/
 */
public class Rotate_List {
    public ListNode rotateRight(ListNode head, int n) {
    	if (n <= 0 || head == null || head.next == null){
    		return head;
    	}
    	
    	ListNode cur = head, runner = head;
    	int k = 0;
    	while (runner != null){
    		runner = runner.next;
    		k ++;
    	}
    	// k : length of list
    	
    	if (n % k == 0){
    		// rotated but keep position as original
    		return head;
    	}
    	if (n > k){
    		// length of list is less than n 
    		n = n % k;
    	}
    	
    	runner = head;
    	for (int i = 0; i < n; i++){
    		runner = runner.next;
    	}
    	
    	//2 ports to find (k-n)th node as new head 
    	while (runner.next != null){
    		cur = cur.next;
    		runner = runner.next;
    	}
    	runner.next = head;
    	head = cur.next;
    	cur.next = null;
    	
        return head;
    }
}
