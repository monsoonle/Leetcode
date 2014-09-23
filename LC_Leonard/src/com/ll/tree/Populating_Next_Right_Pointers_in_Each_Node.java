package com.ll.tree;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Populating_Next_Right_Pointers_in_Each_Node {
	public void connect(TreeLinkNode root) {
		if (root == null){
			return;
		}
		TreeLinkNode lastHead = root;
		TreeLinkNode currentHead = null;
		TreeLinkNode dummyNode = null;
		while (lastHead != null){
			TreeLinkNode currentNode = lastHead;
			while (currentNode != null){
				
				if (currentNode.left != null){
					if (currentHead == null){
						currentHead = currentNode.left;
						dummyNode = currentHead;
					} else {
						dummyNode.next = currentNode.left;
						dummyNode = dummyNode.next;
					}
				}
				
				if (currentNode.right != null){
					if (currentHead == null){
						currentHead = currentNode.right;
						dummyNode = currentHead;
					} else {
						dummyNode.next = currentNode.right;
						dummyNode = dummyNode.next;
					}
				}
				currentNode = currentNode.next;
			}
			
			lastHead = currentHead;
			currentHead = null;
		}
		
	}
}
 