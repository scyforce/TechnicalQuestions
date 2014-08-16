package com.interview.leetcode;

/**
	Given a binary tree, determine if it is a valid binary search tree (BST).
	
	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
 
 * @author shuchun.yang
 *
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	public boolean isValidBST(TreeNode root, int leftVal, int rightVal) {
		if (root==null) {
        	return true;
        }
		
		if (!(root.val>leftVal&&root.val<rightVal)) {
			return false;
		}
		
		//pass leftVal for left sub tree since root.left.val should less than root.val
		//pass rightVal for right sub tree since root.val should be less than root.right.val
		return isValidBST(root.left, leftVal, root.val) && isValidBST(root.right, root.val, rightVal);
	}
}
