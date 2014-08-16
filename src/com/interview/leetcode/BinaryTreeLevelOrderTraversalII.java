package com.interview.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 

Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]

 * @author shuchun.yang
 *
 */
public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		
		if (root==null) {
			return results;
		}
			
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int currentLevelCount = 1;
        int nextLevelCount = 0;
        ArrayList<Integer> level = new ArrayList<Integer>();
		
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			currentLevelCount = currentLevelCount - 1;
			level.add(currentNode.val);
			if (currentNode.left!=null) {
				queue.add(currentNode.left);
				nextLevelCount++;
			}
			
			if (currentNode.right!=null) {
				queue.add(currentNode.right);
				nextLevelCount++;
			}
			
			if (currentLevelCount==0) {
				currentLevelCount = nextLevelCount;
				nextLevelCount = 0;	
				//the trick is here, always add the current level to the first position.
				results.add(0, new ArrayList<Integer>(level));
				level.clear();
			}	
		}
		
		return results;		
    } 
}
