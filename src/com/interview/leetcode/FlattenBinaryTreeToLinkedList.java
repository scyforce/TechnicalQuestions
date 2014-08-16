package com.interview.leetcode;

import java.util.Stack;

/**

	Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	     
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
	click to show hints.
	
	Hints:
	If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

 * @author shuchun.yang
 *
 */
//TODO - add in place solution
public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		
		root.left = left;
		root.right = right;
		
		FlattenBinaryTreeToLinkedList l = new FlattenBinaryTreeToLinkedList();
		l.flatten(root);
	}
	
	//in the flattened tree, each node's right child points to the next node of a pre-order traversal.
	//this is not in place, do in place using recursive next round
	public void flatten(TreeNode root) {
		if (root!=null) {
			 Stack<TreeNode> stack = new Stack<TreeNode>();
			 stack.push(root);
			 
			 while (!stack.isEmpty()) {
				 TreeNode node = stack.pop();
				 
				 TreeNode rightNode = node.right;
				 if (rightNode!=null) {
					 stack.push(rightNode);
				 }	
				 
				 TreeNode leftNode = node.left;
				 if (leftNode!=null) {
					 stack.push(leftNode);
				 }			 
				 	
				 if (!stack.isEmpty()) {
					 node.right = stack.peek();
				 }				 
				 node.left = null;
			 }
		}       		
    }
}
