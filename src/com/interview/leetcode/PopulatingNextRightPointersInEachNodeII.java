package com.interview.leetcode;

/**

	Follow up for problem "Populating Next Right Pointers in Each Node".
	
	What if the given tree could be any binary tree? Would your previous solution still work?
	
	Note:
	
	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL

 * @author shuchun.yang
 *
 */
public class PopulatingNextRightPointersInEachNodeII {
	//use level order traversal
	public void connect(TreeLinkNode root) {
		if (root==null){
            return;
        }   
        
        TreeLinkNode current=root;
        TreeLinkNode nextLevelHead=null;
        TreeLinkNode nextLevelEnd=null;
        while (current!=null) {
            if (current.left!=null){
                if (nextLevelHead==null) {
                   nextLevelHead=current.left;
                   nextLevelEnd=nextLevelHead;
                } else {
                    nextLevelEnd.next=current.left;
                    nextLevelEnd=nextLevelEnd.next;
                
                }
            }
            
            if (current.right!=null) {
                if (nextLevelHead==null) {
                   nextLevelHead=current.right;
                   nextLevelEnd=nextLevelHead;
                } else {
                    nextLevelEnd.next=current.right;
                    nextLevelEnd=nextLevelEnd.next;
                
                }
            }
            
            current=current.next;
            if (current==null) {                
                current=nextLevelHead;
                nextLevelHead=null;
                nextLevelEnd=null;
            }
        }
    }
}
