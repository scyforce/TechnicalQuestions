package com.interview.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 

	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	
	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]

 * @author shuchun.yang
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		TreeNode root = new TreeNode(5);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		b.levelOrder(root);
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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
				results.add(new ArrayList<Integer>(level));
				level.clear();
			}	
		}
		
		return results;		
    } 
}
