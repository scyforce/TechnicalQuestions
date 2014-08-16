package com.interview.leetcode;

import java.util.ArrayList;

/**

	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]


 * @author shuchun.yang
 *
 */
public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSumII(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (root==null) {
        	return results;
        }
        
        pathSumII(results, new ArrayList<Integer>(), 0, root, sum);
        
        return results;
    }
	
	public void pathSumII(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> currentPath, int currentSum, TreeNode root, int sum) {
		if (root.left==null&&root.right==null) {
			if (currentSum+root.val==sum) {
				ArrayList<Integer> result = new ArrayList<Integer>(currentPath);
				result.add(root.val);
				results.add(result);
			}
		}
		
		currentPath.add(root.val);
		if (root.left!=null) {
			pathSumII(results, currentPath, currentSum+root.val, root.left, sum);
		}
		if (root.right!=null) {
			pathSumII(results, currentPath, currentSum+root.val, root.right, sum);
		}
		currentPath.remove(currentPath.size()-1);
		
	}
}
