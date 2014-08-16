package com.interview.leetcode;

/**

	Given a binary tree
	
	    struct TreeLinkNode {
	      TreeLinkNode *left;
	      TreeLinkNode *right;
	      TreeLinkNode *next;
	    }
	Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	
	Initially, all next pointers are set to NULL.
	
	Note:
	
	You may only use constant extra space.
	You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
	For example,
	Given the following perfect binary tree,
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \  / \
	    4->5->6->7 -> NULL

 * @author shuchun.yang
 *
 */

public class PopulatingNextRightPointersInEachNode {
	public static void main(String[] args) {
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		
		t1.left = t2;
		t1.right = t3;
		
		t2.left = t4;
		t2.right = t5;
		
		PopulatingNextRightPointersInEachNode t = new PopulatingNextRightPointersInEachNode();
		t.connect(t1);
	}
	
	
	//perfect tree
	public void connect(TreeLinkNode root) {
		if (root==null) {
			return;
		}		
		if (root.left!=null) {
			root.left.next = root.right;
		}
		
		if (root.right!=null) {
			root.right.next = (root.next==null) ? null : root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}
}
