package com.interview.leetcode;

import java.util.LinkedList;

/**

	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	
	For example, this binary tree is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.

 * @author shuchun.yang
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root==null) {
        	return true;
        }
        
        return isSymmetric(root.left, root.right);
    }
	
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left==null) {
			return right==null;
		}
		//left is not null
		if (right==null) {
			return false;
		}		
		//both left and right are not null
		if (left.val != right.val) {
			return false;
		}
		
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		
	}
	
	public boolean isSymmetricIter(TreeNode root) {
        if(root==null) return true;
        LinkedList<TreeNode> l = new LinkedList<TreeNode>(),
                            r = new LinkedList<TreeNode>();
        l.add(root.left);
        r.add(root.right);
        while(!l.isEmpty() && !r.isEmpty()){
            TreeNode temp1=l.poll(), temp2=r.poll();
            if(temp1==null && temp2!=null || temp1!=null && temp2==null)
                return false;
            if(temp1!=null){
                if(temp1.val!=temp2.val) return false;
                l.add(temp1.left);
                l.add(temp1.right);
                r.add(temp2.right);
                r.add(temp2.left);
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(2);
		SymmetricTree t = new SymmetricTree();
		t.isSymmetric(tree);
	}
}
