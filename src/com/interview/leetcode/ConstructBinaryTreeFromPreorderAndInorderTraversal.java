package com.interview.leetcode;

/**
 * 

	Given preorder and inorder traversal of a tree, construct the binary tree.
	
	Note:
	You may assume that duplicates do not exist in the tree.
	
	Example:
	in-order:   4 2 5  (1)  6 7 3 8
	pre-order:  (1) 2 4 5 3 7 6 8

 * @author shuchun.yang
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		int[] inorder = {4,2,5,1,6,7,3,8};
		int[] preorder = {1,2,4,5,3,7,6,8};
		
		ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		TreeNode t = c.buildTree(preorder, inorder);
		System.out.println(t);
		
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, inorder.length-1, inorder, 0, preorder.length-1, preorder);
    }
	
	public TreeNode buildTree(int inStart, int inEnd, int[] inorder, int preStart, int preEnd, int[] preorder) {
		if(inStart > inEnd || preStart > preEnd) {
			return null;
		} 
		
		int rootValue = preorder[preStart];
		int rootIndexInorder = 0;
		
		for (int i=inStart; i<=inEnd; i++) {
			if (inorder[i]==rootValue) {
				rootIndexInorder = i;
			    break;
			}
		}
		//left sub tree length
		int length = rootIndexInorder - inStart;
		TreeNode root = new TreeNode(rootValue);
		root.left = buildTree(inStart, rootIndexInorder-1, inorder, preStart+1, preStart+length, preorder);
		root.right = buildTree(rootIndexInorder+1, inEnd, inorder, preStart+length+1, preEnd, preorder);
		
		return root;
	}
}
