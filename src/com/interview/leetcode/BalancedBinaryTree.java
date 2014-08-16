package com.interview.leetcode;

/**

	Given a binary tree, determine if it is height-balanced.
	
	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 * @author shuchun.yang
 *
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if (root==null) {
        	return true;
        }
        
        int leftSubTreeHeight = getHeight(root.left);
        int rightSubTreeHeight = getHeight(root.right);
        
        //check if both leftSubTree and rightSubTree is balanced
        if (Math.abs(leftSubTreeHeight-rightSubTreeHeight)<=1 && isBalanced(root.left) && isBalanced(root.right)) {
        	return true;
        }
        return false;
    }
	
	public int getHeight(TreeNode node) {
		if (node == null ){
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
}
