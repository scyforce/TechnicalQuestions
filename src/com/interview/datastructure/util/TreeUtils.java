package com.interview.datastructure.util;

import com.interview.datastructure.tree.TreeNode;

public class TreeUtils {
	/* Tree Structure                    
	 *                     100
	 *           50                    125
	 *       25     80          105           150
	 *                  90                130 
	 */  
	public static TreeNode createTreeNode () {
		TreeNode root = new TreeNode();
		root.setValue(100);
		
		//creating left part of the tree
		TreeNode child_2L = new TreeNode();
		child_2L.setValue(50);
		root.setLeft(child_2L);
		
		TreeNode child_2L_3L = new TreeNode();
		child_2L_3L.setValue(25);
		child_2L.setLeft(child_2L_3L);
		
		TreeNode child_2L_3R = new TreeNode();
		child_2L_3R.setValue(80);
		child_2L.setRight(child_2L_3R);
		
		TreeNode child_2L_3R_4R = new TreeNode();
		child_2L_3R_4R.setValue(90);
		child_2L_3R.setRight(child_2L_3R_4R);
		
		//creating right part of the tree
		TreeNode child_2R = new TreeNode();
		child_2R.setValue(125);
		root.setRight(child_2R);
		
		TreeNode child_2R_3L = new TreeNode();
		child_2R_3L.setValue(105);
		child_2R.setLeft(child_2R_3L);
		
		TreeNode child_2R_3R = new TreeNode();
		child_2R_3R.setValue(150);
		child_2R.setRight(child_2R_3R);
		
		TreeNode child_2R_3R_4L = new TreeNode();
		child_2R_3R_4L.setValue(130);
		child_2R_3R.setLeft(child_2R_3R_4L);
		
		return root;
	}
}
