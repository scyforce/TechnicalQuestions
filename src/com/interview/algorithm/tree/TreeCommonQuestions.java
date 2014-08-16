package com.interview.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.algorithm.linkedlist.Node;
import com.interview.algorithm.util.LinkedListUtils;
import com.interview.algorithm.util.TreeUtils;

public class TreeCommonQuestions {
	
	public static TreeNode findLCAInBST(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root==null || node1==null || node2==null) return null;
		
		if (Math.max(node1.getValue(), node2.getValue()) < root.getValue()) {
			return findLCAInBST(root.getLeft(), node1, node2);
		} else if (Math.min(node1.getValue(), node2.getValue()) > root.getValue()) {
			return findLCAInBST(root.getRight(), node1, node2);
		} else {
			return root;
		}
	
	}
	
	/**
	 * Tree diameter means the longest path from a leaf to another leaf
	 * There are three cases to consider when trying to find the longest path between two nodes in a binary tree (diameter):
		1. The longest path passes through the root,
		2. The longest path is entirely contained in the left sub-tree,
		3. The longest path is entirely contained in the right sub-tree.
		The longest path through the root is simply the sum of the heights of the left and right sub-trees + 1 (for the root node), and the other two can be found recursively:
	 * @param node
	 * @return
	 */
	public static int getDiameter(TreeNode node) {
		if (node == null){
			return 0;
		}
		
		int rootDiameter = getHeight(node.getLeft()) + getHeight(node.getRight()) + 1;
		int leftDiameter = getDiameter(node.getLeft());
		int rightDiameter = getDiameter(node.getRight());
		
		return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
		
	}
	
	public static int getHeight(TreeNode node) {
		if (node == null ){
			return 0;
		}
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}
	

	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		
		/*TreeNode node = TreeUtils.createTreeNode();//TreeCommonQuestions.convertSortedArrayToBST(array);
		TreeCommonQuestions.printTreeLevelByLevel(node);
		System.out.println();
		TreeCommonQuestions.serializeTree(node);
		System.out.println();
		System.out.println(TreeCommonQuestions.getDiameter(node));
		//TreeTraversal.inOrderTraversalRec(node);*/
		
	}
}
