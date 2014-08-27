package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**

	Given a binary tree, return the inorder traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].
	
	Note: Recursive solution is trivial, could you do it iteratively?

 * @author shuchun.yang
 *
 */
public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(4);
		TreeNode ll1 = new TreeNode(1);
		TreeNode lr1 = new TreeNode(7);
		TreeNode rr1 = new TreeNode(5);
		
		root.left = l1;
		root.right = r1;
		
		l1.left = ll1;
		l1.right = lr1;
		r1.right = rr1;
		
		BinaryTreeInorderTraversal inorder = new BinaryTreeInorderTraversal();
		inorder.inorderTraversal(root);
		//inorder.inorderTraversalMorris(root);
	}
	
	//LMR
	public ArrayList<Integer> inorderTraversal(TreeNode root) {		
		//incoming node is root
	    Stack<TreeNode> nodes = new Stack<TreeNode>();
	    ArrayList<Integer> values = new ArrayList<Integer>();
	    while (!nodes.isEmpty() || root!=null) {
	        if (root != null) {
	            nodes.push(root);
	            root = root.left;
	        } else {
	        	root = nodes.pop();
	        	values.add(root.val);
	            root = root.right;
	        }
	    }     
	    return values;
    }
	
	/*
	 * 	1. Initialize current as root 
		2. While current is not NULL
   			If current does not have left child
      			a) Print currentÕs data
      			b) Go to the right, i.e., current = current->right
   			Else
      			a) Make current as right child of the rightmost node in current's left subtree
      			b) Go to this left child, i.e., current = current->left
	 */
	public ArrayList<Integer> inorderTraversalMorris(TreeNode root) {
		TreeNode cur = root;  
		ArrayList<Integer> values = new ArrayList<Integer>();   
		while (cur != null) {
			if (cur.left != null) {
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) { // set right to successor
					pre.right = cur;
					cur = cur.left;
				} else { // visit and revert the change
					pre.right = null;
					values.add(cur.val);
					cur = cur.right;
				}
			} else { // visit and move to successor
				values.add(cur.val);
				cur = cur.right;
			}
		}
		return values;
	}
}
