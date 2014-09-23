package com.ll.tree;

import java.util.Stack;

public class TreeTraversal {
	public int getTreeHeight(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return 1 + Math
				.max(getTreeHeight(root.left), getTreeHeight(root.right));
	}

	// 前序遍历 递归

	public void preOrderR(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			preOrderR(root.left);
			preOrderR(root.right);
		}
	}

	// 前序遍历 非递归
	public void preOrderI(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			while (p != null) {
				stack.push(p);
				System.out.print(p.val); // read left node first
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				p = p.right;
			}

		}
	}

	// 中序遍历 非递归
	public void inOrderI(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				System.out.print(p.val); // read root first
				p = p.right;
			}

		}
	}

	// 后续遍历 非递归
	/*
	 * 只需保证每个节点都要在其左右孩子节点之后进行访问 也就是说当该节点没有孩子节点或者有孩子节点但孩子节点已经被访问时才能进行访问
	 */
	public void postOrderI(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode cur = null;
		TreeNode pre = null;
		s.push(root);
		while (!s.isEmpty()) {
			cur = s.peek();
			if ((cur.left == null && cur.right == null)
					|| (pre != null && (pre == cur.left || pre == cur.right))) {
				System.out.print(cur.val);
				s.pop();
				pre = cur;
			} else {
				if (cur.right != null)
					s.push(cur.right);
				if (cur.left != null)
					s.push(cur.left);
			}
		}
		
	}
	
    /** 非递归实现后序遍历 4 双栈法 */  
    protected static void postorderIDoubleStack(TreeNode p) {  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        Stack<TreeNode> temp = new Stack<TreeNode>();  
        TreeNode node = p;  
        while (node != null || stack.size()> 0) {  
            while (node != null) {  
                temp.push(node);  
                stack.push(node);  
                node = node.right;  
            }  
            if (stack.size() > 0) {  
                node = stack.pop();  
                node = node.left;  
            }  
        }  
        while (temp.size() > 0) {  
            node = temp.pop();  
            System.out.println(node.val);
        }  
    } 
}
