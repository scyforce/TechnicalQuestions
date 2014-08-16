package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**

	Given a binary tree, return the postorder traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [3,2,1].
	
	Note: Recursive solution is trivial, could you do it iteratively?

 * @author shuchun.yang
 *
 */
public class BinaryTreePostorderTraversal {
	
	//LRM
	public ArrayList<Integer> postOrderTraversal(TreeNode root) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		if (root!=null) {
			Stack<TreeNode> child = new Stack<TreeNode>();
			Stack<TreeNode> parent = new Stack<TreeNode>();
			
			child.push(root);
			while (!child.isEmpty()) {
				TreeNode current = child.pop();
				parent.push(current);
				if (current.left!=null) {
					child.push(current.left);
				}
				if (current.right!=null) {
					child.push(current.right);
				}
			}
			
			while (!parent.isEmpty()) {
				TreeNode current = parent.pop();
				values.add(current.val);
			}
		}
		
		return values;
	}
}
