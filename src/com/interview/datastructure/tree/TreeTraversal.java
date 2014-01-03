package com.interview.datastructure.tree;

import java.util.Stack;

import com.interview.datastructure.util.TreeUtils;

public class TreeTraversal {	
	public static void preOrderTraversalRec(TreeNode root) {
		if (root==null) return;
		System.out.print(root.getValue()+" ");
		preOrderTraversalRec(root.getLeft());
		preOrderTraversalRec(root.getRight());
	}
	
	public static void preOrderTraversal(TreeNode root) {
		if (root==null) return;	
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode item = stack.pop();
			System.out.print(item.getValue()+" ");
			if (item.getRight()!=null) stack.push(item.getRight());
			if (item.getLeft()!=null) stack.push(item.getLeft());
		}		
	}
	
	public static void inOrderTraversalRec(TreeNode root) {
		if (root==null) return;		
	    inOrderTraversalRec(root.getLeft());
	    System.out.print(root.getValue()+" ");
	    inOrderTraversalRec(root.getRight());
	}
	
	public static void inOrderTraversal(TreeNode root) {	
		//incoming node is root
	    Stack<TreeNode> nodes = new Stack<TreeNode>();
	    while (!nodes.isEmpty() || root!=null) {
	        if (root != null) {
	            nodes.push(root);
	            root = root.getLeft();
	        } else {
	        	root = nodes.pop();
	            System.out.print(root.getValue() + " ");
	            root = root.getRight();
	        }
	    }     
	}
	
	public static void postOrderTraversalRec(TreeNode root) {
		if (root==null) return;		
		postOrderTraversalRec(root.getLeft());
		postOrderTraversalRec(root.getRight());
	    System.out.print(root.getValue()+" ");
	}
	
	public static void postOrderTraversal(TreeNode root) {
		if (root==null) return;	
		Stack<TreeNode> child = new Stack<TreeNode>();
		Stack<TreeNode> parent = new Stack<TreeNode>();

        child.push(root); 
           
        while (!child.isEmpty()) { 
            TreeNode current = child.pop(); 
            parent.push(current); 
            if (current.getLeft()!=null) child.push(current.getLeft());                
            if (current.getRight()!=null) child.push(current.getRight());           
        } 
           
        //Printing the post order traversal     
        while (!parent.empty()) {         
            TreeNode current = parent.pop();
            System.out.print(current.getValue() + " ");
        }  
	}
	
	
	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTreeNode();
		System.out.println("---------------------Pre Order Traverse-----------------");
		preOrderTraversalRec(root);
		System.out.println();
		System.out.println("---------------------Pre Order Traverse Non Rec-----------------");
		preOrderTraversal(root);
		System.out.println();
		System.out.println("---------------------In Order Traverse-----------------");
		inOrderTraversalRec(root);
		System.out.println();
		System.out.println("---------------------In Order Traverse Non Rec-----------------");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("---------------------Post Order Traverse-----------------");
		postOrderTraversalRec(root);
		System.out.println();
		System.out.println("---------------------Post Order Traverse Non Rec-----------------");
		postOrderTraversal(root);
		System.out.println();
	}
}
