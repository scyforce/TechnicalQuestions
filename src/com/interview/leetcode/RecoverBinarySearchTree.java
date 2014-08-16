package com.interview.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**

	Two elements of a binary search tree (BST) are swapped by mistake.
	
	Recover the tree without changing its structure.
	
	Note:
	A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 * @author shuchun.yang
 *
 */
public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(4);
		TreeNode r1 = new TreeNode(2);
		TreeNode ll1 = new TreeNode(1);
		TreeNode rr1 = new TreeNode(5);*/
		
		TreeNode root = new TreeNode(2);
		TreeNode l1 = new TreeNode(3);
		TreeNode r1 = new TreeNode(4);
		TreeNode ll1 = new TreeNode(1);
		TreeNode rr1 = new TreeNode(5);
		
		root.left = l1;
		root.right = r1;
		
		l1.left = ll1;
		r1.right = rr1;
		
		RecoverBinarySearchTree r = new RecoverBinarySearchTree();
		r.recoverTreeMorris(root);
		
		BinaryTreeInorderTraversal inorder = new  BinaryTreeInorderTraversal();
		System.out.println(Arrays.toString(inorder.inorderTraversal(root).toArray()));
		
	}
	
	private void swap(TreeNode t1, TreeNode t2) {
		int value = t1.val;
		t1.val = t2.val;
		t2.val = value;
	}
	
	public void recoverTreeMorris(TreeNode root) {
		if (root==null || (root.left==null&&root.right==null)) {
        	return;
        }
		
		TreeNode current = root;  
		TreeNode previous = null;
		TreeNode first = null;
		TreeNode second = null;
		while (current != null) {
			if (current.left != null) {
				TreeNode pointer = current.left;
				while (pointer.right != null && pointer.right != current) {
					pointer = pointer.right;
				}
				if (pointer.right == null) { // set right to successor
					pointer.right = current;
					current = current.left;
				} else { // visit and revert the change
					pointer.right = null;
					if (previous!=null && current.val<previous.val) {
		        		if (first==null) {
		        			first = previous;
		        		} 
	        			second = current;
					}
					previous = current;
					current = current.right;
				}
			} else { // visit and move to successor
				if (previous!=null && current.val<previous.val) {
	        		if (first==null) {
	        			first = previous;
	        		} 
        			second = current;
				}
				previous = current;
				current = current.right;
			}
		}
		swap(first, second);
	}
	
	public void recoverTree(TreeNode root) {
        if (root==null || (root.left==null&&root.right==null)) {
        	return;
        }
        TreeNode current = root;
        TreeNode previous = null;
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> nodes = new Stack<TreeNode>();
	    while (!nodes.isEmpty() || current!=null) {
	        if (current != null) {
	            nodes.push(current);
	            current = current.left;
	        } else {
	        	current = nodes.pop();
	        	if (previous!=null && current.val<previous.val) {
	        		if (first==null) {
	        			first = previous;
	        			second = current;
	        		} else {
	        			second = current;
	        			break;
	        		}      	
	        	}
	        	previous = current;
	        	current = current.right;
	        }        
	    }  	    
	    swap(first, second);
    }
}
