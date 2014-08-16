package com.interview.leetcode;

/**
 * 

	Given inorder and postorder traversal of a tree, construct the binary tree.
	
	Note:
	You may assume that duplicates do not exist in the tree.
	
	Example:
	in-order:   4 2 5  (1)  6 7 3 8
	post-order: 4 5 2  6 7 8 3  (1)

 * @author shuchun.yang
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public static void main(String[] args) {
		int[] inorder = {4,2,5,1,6,7,3,8};
		int[] postorder = {4,5,2,6,7,8,3,1};
		
		ConstructBinaryTreeFromInorderAndPostorderTraversal c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		TreeNode t = c.buildTree(inorder, postorder);
		System.out.println(t);
		
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(0, inorder.length-1, inorder, 0, postorder.length-1, postorder);
    }
	
	public TreeNode buildTree(int inStart, int inEnd, int[] inorder, int postStart, int postEnd, int[] postorder) {
		if(inStart > inEnd || postStart > postEnd) {
			return null;
		}            
		
		int rootValue = postorder[postEnd];
		int rootIndexInorder = 0;
		
		for (int i=inStart; i<=inEnd; i++) {
			if (rootValue == inorder[i]) {
				rootIndexInorder = i;
				break;
			}
		}
		
		//left sub tree length
		int length = rootIndexInorder-inStart;
		TreeNode root = new TreeNode(rootValue);
		
		//(rootIndex-inStart-1) is to get the length of left subtree.
		root.left = buildTree(inStart, rootIndexInorder-1, inorder, postStart, postStart+length-1, postorder);
		//left subtree end index + 1 is right subtree start index
		root.right = buildTree(rootIndexInorder+1, inEnd, inorder, postStart+length-1+1, postEnd-1, postorder);		
		return root;		
	}
}
