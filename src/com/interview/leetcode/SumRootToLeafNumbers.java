package com.interview.leetcode;

/**

	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	
	An example is the root-to-leaf path 1->2->3 which represents the number 123.
	
	Find the total sum of all root-to-leaf numbers.
	
	For example,
	
	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.
	
	Return the sum = 12 + 13 = 25.

 * @author shuchun.yang
 *
 */
public class SumRootToLeafNumbers {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		System.out.println(s.sumNumbers(t1));
	}
	
	public int sumNumbers(TreeNode root) {
        if (root==null) {
        	return 0;
        }
        
        return sumNumber(root, 0);
    }
	
	public int sumNumber(TreeNode root, int number) {
		//if leaf node, return the final path integer
		if (root.left==null && root.right==null) {
			return number*10 + root.val;
		}
		
		int leftVal = 0;
		int rightVal = 0;
		
		if (root.left!=null) {
			leftVal = sumNumber(root.left, number*10+root.val);
		}
		
		if (root.right!=null) {
			rightVal = sumNumber(root.right, number*10+root.val);
		}
		return leftVal + rightVal;
	}
}
