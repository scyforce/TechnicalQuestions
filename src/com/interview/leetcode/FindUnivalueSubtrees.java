package com.interview.leetcode;

/**
 * find the number of the uni value subtrees in a binary tree, that is each subtree contain only the same value as itself 
		such that : 
		  1 
		return 1 {1} 
		   1 
		  1 1 
		return 3 {1,1,{1,1,1}} 
		     1 
		   2  3 
		return 2  {2, 3} 
		    1 
		   2  3 
		  2 
		return 3 { 2, {2,2}, 3} 
		
		     1 
		   2   3 
		  2 
		4 
		return 2 {4,3} 

 * @author shuchun.yang
 *
 */
public class FindUnivalueSubtrees {
	int count = 0;
	
	public int getCount() {
		return count;
	}
	
	public boolean findIfUnivalueTree(TreeNode node) {
		if (node==null) {
			return true;
		}
		
		if (node.left!=null&&node.right!=null&&node.left.val!=node.right.val) {
			return false;
		}
		
		if ((node.left!=null && node.left.val!=node.val)||(node.right!=null && node.left.val!=node.val)) {
			return false;
		}
		
		boolean left = findIfUnivalueTree(node.left);
		boolean right = findIfUnivalueTree(node.right);

		return left&&right;
	}
	
	public boolean findUnivalueSubtrees(TreeNode node) {
		    if(node == null) {
		    	return true;
		    }
		    boolean left = findUnivalueSubtrees(node.left);
		    boolean right =  findUnivalueSubtrees(node.right);
		    if(left && right && 
		    		(node.left==null || node.left.val == node.val) && 
		            (node.right==null ||node.right.val == node.val)){
		        count++;
		        return true;
		    }
		    return false;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node_left = new TreeNode(1);
		TreeNode node_right = new TreeNode(1);
		node.left = node_left;
		node.right = node_right;
		
		FindUnivalueSubtrees f = new FindUnivalueSubtrees();
		f.findUnivalueSubtrees(node);
		System.out.println(f.findIfUnivalueTree(node));
	}
}
