package com.interview.leetcode;

/**

	Given a binary tree, find the maximum path sum.
	
	The path may start and end at any node in the tree.
	
	For example:
	Given the below binary tree,
	
	       1
	      / \
	     2   3
	Return 6.

 * @author shuchun.yang
 *
 */
public class BinaryTreeMaximumPathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		System.out.println(b.maxPathSum(root));
	}
	
	public int maxPathSum(TreeNode root) {
		int[] maxNode = new int[1];
		maxNode[0] = Integer.MIN_VALUE;
		findMax(root, maxNode);		
		return maxNode[0];
    }
	
	/*
	 1. Node only (there may be negative value in node)
	 2. L-sub + Node
	 3. R-sub + Node
	 4. L-sub + Node + R-sub
	 
	 we need to compare each situation to find the max
	 */
	public int findMax(TreeNode root, int[] maxNode) {
		if (root==null) {
			return 0;
		}
		
		int left = findMax(root.left, maxNode);
		int right = findMax(root.right, maxNode);
		
		int currentMax = Math.max(root.val, Math.max(root.val+left, root.val+right));
		maxNode[0] = Math.max(maxNode[0], Math.max(currentMax, root.val+left+right));
				
		return currentMax;		
	}
}
