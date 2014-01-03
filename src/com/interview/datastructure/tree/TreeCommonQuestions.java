package com.interview.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.datastructure.linkedlist.Node;
import com.interview.datastructure.util.LinkedListUtils;
import com.interview.datastructure.util.TreeUtils;

public class TreeCommonQuestions {
	public static void serializeTree(TreeNode root) {
		if (root==null) {
			System.out.print("# ");
		} else {
			System.out.print(root.getValue() + " ");
			serializeTree(root.getLeft());
			serializeTree(root.getRight());
		}
	}
	
	public static TreeNode deserializeTree(int[] tree) {
		return null;
	}
	
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
	
	public static void printTreeLevelByLevel(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);

	    while(queue.size()>0){
	        TreeNode node = queue.remove();

	        System.out.print(node.getValue()+ " ");

	        if(node.getLeft()!=null)
	                queue.add(node.getLeft());

	        if(node.getRight()!=null)
	                queue.add(node.getRight());
	        }
	}
	
	/**
	 * Verify if a tree is a binary search tree
	 *         3
	 *       2   4
	 *     1       5
	 * @param node
	 * @return
	 */
	public static boolean isBST(TreeNode node) {
		return isBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private static boolean isBST(TreeNode node, int smallValue, int largeValue) {
		if (node==null) {
			return true;
		}
		
		if (!(node.getValue()>smallValue && node.getValue()<=largeValue)) {
			return false;
		}
		
		return isBST(node.getLeft(), smallValue, node.getValue()) && isBST(node.getRight(), node.getValue(), largeValue);
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
	
	/**
	 * convert a sorted array [1,2,3,4,5] to a BST, this method applies to both sorted and not sorted
	 *      3
	 *    2   4
	 *  1       5
	 * @param array
	 * @return
	 */
	public static TreeNode convertSortedArrayToBST(int[] array) {
		return convertSortedArrayToBST(array, 0, array.length-1);
	}
		
	private static TreeNode convertSortedArrayToBST(int[] array, int start, int end) {
		if (start>end) return null;
		int middle = start + (end-start)/2;
		TreeNode node = new TreeNode();
		node.setValue(array[middle]);
		TreeNode leftNode = convertSortedArrayToBST(array, start,middle-1);
		node.setLeft(leftNode);
		TreeNode rightNode = convertSortedArrayToBST(array, middle+1, end);
		node.setRight(rightNode);
		return node;
	}
	
	/**
	 * convert a sorted linkedlist 1->2->3->4->5 to a BST
	 *      3
	 *    2   4
	 *  1       5
	 * @param array
	 * @return
	 */
	public static TreeNode convertSortedListToBST(Node<Integer> head) {
		int length = 0;
		Node<Integer> previous = head;		
		while (previous.getNext()!=null) {
		    previous = previous.getNext();
			length++;
		}
		if (length == 0) {
			return null;
		}
		return convertSortedListToBST(head, 0, length);
	}
		
	private static TreeNode convertSortedListToBST(Node<Integer> head, int start, int end) {
		if (start>end) return null;
		int middle = start + (end-start)/2;
		TreeNode node = new TreeNode();
		node.setValue(head.getValue());
		TreeNode leftNode = convertSortedListToBST(head, start,middle-1);
		node.setLeft(leftNode);
		head = head.getNext();
		TreeNode rightNode = convertSortedListToBST(head, middle+1, end);
		node.setRight(rightNode);
		return node;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		System.out.println(TreeCommonQuestions.isBST(TreeCommonQuestions.convertSortedArrayToBST(array)));
		
		/*TreeNode node = TreeUtils.createTreeNode();//TreeCommonQuestions.convertSortedArrayToBST(array);
		TreeCommonQuestions.printTreeLevelByLevel(node);
		System.out.println();
		TreeCommonQuestions.serializeTree(node);
		System.out.println();
		System.out.println(TreeCommonQuestions.getDiameter(node));
		//TreeTraversal.inOrderTraversalRec(node);*/
		
		Integer[] array1 = {1,2,3,4,5,6,7,8};
		Node<Integer> head = LinkedListUtils.createLinkedList(array1);
		TreeNode node = TreeCommonQuestions.convertSortedListToBST(head);
		//System.out.println(TreeCommonQuestions.isBST(node));
		//TreeCommonQuestions.printTreeLevelByLevel(node);
		System.out.println(TreeCommonQuestions.getHeight(node));
		//TreeTraversal.inOrderTraversalRec(node);
		
	}
}
