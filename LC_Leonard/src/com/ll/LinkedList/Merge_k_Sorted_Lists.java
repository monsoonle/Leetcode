package com.ll.LinkedList;

import java.util.*;

public class Merge_k_Sorted_Lists {
	
    public ListNode mergeKLists(List<ListNode> lists) {
    	if (lists.size() == 0){
    		return null;
    	}
    
    	Comparator<ListNode>  cmp = new Comparator<ListNode>(){
    		//调整为最小堆
			@Override
			public int compare(ListNode l1, ListNode l2) {
				// TODO Auto-generated method stub
				return l1.val - l2.val;
			}
    		
    	};
    	
    	Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), cmp);
    	//链表都放入堆中
    	for (int i = 0; i < lists.size(); i++){
    		if (lists.get(i) != null){
    			heap.offer(lists.get(i));
    		}
    	}
    	
    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;
    	
    	while (!heap.isEmpty()){
    		ListNode node = heap.poll();
    		
    		tail.next = node;
    		tail = node;
    		
    		if (node.next != null){
    			//下一个node放入堆中重新调整为最小堆
    			heap.offer(node.next);
    		}
    	}
    	
    	return dummy.next;
    	
    }
}
