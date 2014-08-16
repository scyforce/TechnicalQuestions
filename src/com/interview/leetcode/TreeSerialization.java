package com.interview.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**

	The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

	Here's an example:
	   1
	  / \
	 2   3
	    /
	   4
	    \
	     5
	     
	The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}"

 * @author shuchun.yang
 *
 */
public class TreeSerialization {
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t4.right = t5;
		
		TreeSerialization s = new TreeSerialization();
		String[] results = s.serializePreorder(t1);//s.serialize(t1);
		
		TreeNode root = s.deserializePreorder(results);//s.deserialize(results);
		
	}
	
	public TreeNode deserialize(String[] tree) {
		if (tree==null||tree.length==0) {
			return null;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int index = 0;
		TreeNode root = new TreeNode(Integer.parseInt(tree[index]));
		index = index+1;
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			String leftNode = tree[index];
			index = index + 1;
			if (!"#".equals(leftNode)) {
				node.left = new TreeNode(Integer.parseInt(leftNode));	
				queue.add(node.left);
			}
			String rightNode = tree[index];
			index = index + 1;
			if (!"#".equals(rightNode)) {
				node.right = new TreeNode(Integer.parseInt(rightNode));	
				queue.add(node.right);
			}			
		}
		
		return root;		
	}
	
	public String[] serialize(TreeNode root) {
		ArrayList<String> results = new ArrayList<String>();
		if (root==null) {
			return (String[])results.toArray();
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node==null) {
				results.add("#");
			} else {
				results.add(node.val+"");
				queue.offer(node.left);
				queue.offer(node.right);			
			}		
		}

		String[] s = new String[results.size()];
		results.toArray(s);
		return s;
	}
	
	public String[] serializePreorder(TreeNode root) {
		ArrayList<String> results = new ArrayList<String>();
		if (root==null) {
			return (String[])results.toArray();
		}
		
		serializePreorder(results, root);
		String[] s = new String[results.size()];
		results.toArray(s);
		return s;
	}
	
	public void serializePreorder(ArrayList<String> results, TreeNode root) {
		if (root==null) {
			results.add("#");
		} else {
			results.add(root.val+"");
			serializePreorder(results, root.left);
			serializePreorder(results, root.right);
		}
	}
	
	public TreeNode deserializePreorder(String[] tree) {
		if (tree==null||tree.length==0) {
			return null;
		}
		
		TreeNode root = deserializePreorder(null, tree, 0);
		return root;
	}
	
	public TreeNode deserializePreorder(TreeNode root, String[] tree, int index) {
		if (index==tree.length) {
			return null;
		}
		
		String node = tree[index];
		if (!"#".equals(node)) {
			root = new TreeNode(Integer.parseInt(node));
			TreeNode left = deserializePreorder(root.left, tree, index+1);
			root.left = left;
			TreeNode right = deserializePreorder(root.right, tree, index+1+1);			
			root.right = right;
		}
		return root;
	}
}
