package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**

	Given a binary tree, return the preorder traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,2,3].
	
	Note: Recursive solution is trivial, could you do it iteratively?

 * @author shuchun.yang
 *
 */
public class BinaryTreePreorderTraversal {
	//MLR
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		if (root!=null) {	
			Stack<TreeNode> nodes = new Stack<TreeNode>();
			nodes.push(root);       
	        while(!nodes.isEmpty()) {
	            TreeNode node = nodes.pop();
	            values.add(node.val);
	            if (node.right!=null) {
	            	nodes.add(node.right);
	            }
	            if (node.left!=null) {
	            	nodes.add(node.left);
	            }            
	        }
		}	
        return values;
    }
}
