package com.interview.leetcode;


/**

	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 * @author shuchun.yang
 *
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root==null) {
			return false;
		}		
        return hasPathSum(root, 0, sum);
    }
	
	public boolean hasPathSum(TreeNode root, int currentSum, int sum) {
		if (root.left==null&&root.right==null) {
			if ((currentSum+root.val)==sum) {
				return true;
			} else {
				return false;
			}
		}
		
		boolean hasLeftPathSum = false;
		if (root.left!=null) {
			hasLeftPathSum = hasPathSum(root.left, currentSum+root.val, sum);
		}
		boolean hasRightPathSum = false;
		if (root.right!=null) {
			hasRightPathSum = hasPathSum(root.right, currentSum+root.val, sum);
		}
		return hasLeftPathSum||hasRightPathSum;
	}
}
