package com.interview.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 

	Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
	
	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]

 * @author shuchun.yang
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = new TreeNode(5);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(7);
		TreeNode t5 = new TreeNode(8);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		System.out.println(b.zigzagLevelOrder(root));
	}
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		
		if (root==null) {
			return results;
		}
			
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int currentLevelCount = 1;
        int nextLevelCount = 0;
        ArrayList<Integer> level = new ArrayList<Integer>();
        boolean fromLeftToRight = true;
		
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			currentLevelCount = currentLevelCount - 1;
			//when adding from right to left order, we need to append to the first position
			if (fromLeftToRight) {
				level.add(currentNode.val);
			} else {
				level.add(0, currentNode.val);
			}

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
				fromLeftToRight = !fromLeftToRight;
			}
			
		}
		
		return results;		
    }
}
