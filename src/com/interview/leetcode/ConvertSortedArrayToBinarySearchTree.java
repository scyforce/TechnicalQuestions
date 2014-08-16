package com.interview.leetcode;

/**

	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 * @author shuchun.yang
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }
	
	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start>end) return null;
		int middle = start + (end-start)/2;
		TreeNode node = new TreeNode(num[middle]);
		node.left = sortedArrayToBST(num, start, middle-1);
		node.right = sortedArrayToBST(num, middle+1, end);		
		return node;	
	}
}
