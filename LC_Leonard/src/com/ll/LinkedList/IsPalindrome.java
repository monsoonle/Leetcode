package com.ll.LinkedList;

import java.util.Stack;

public class IsPalindrome {
	public boolean isPalindrome(ListNode node){
		if (node == null || node.next == null){
			return true;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode fast = node , slow = node;
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			stack.push(slow);
			slow = slow.next;
		}
		
		//list length is odd number  (fast.next == null but fast is not null)
		if(fast != null){
			slow = slow.next;
		}
		
		while (slow != null){
			ListNode target = stack.pop();
			if (slow.val != target.val){
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}

}
