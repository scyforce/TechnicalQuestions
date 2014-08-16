package com.interview.leetcode;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.

	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	   
 * @author shuchun.yang
 */
public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {
		UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
		System.out.println(u.generateTrees(3).size());
	}
	
	public ArrayList<TreeNode> generateTrees(int n) {       
        return generateTrees(1, n);       
    }
	
	public ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();  
        if(start > end){  
        	result.add(null);          // 相当于占位符  
            return result;  
        }  
          
        for(int i=start; i<=end; i++){  
            ArrayList<TreeNode> left = generateTrees(start, i-1);   // left和right至少会有一个元素null！  
            ArrayList<TreeNode> right = generateTrees(i+1, end);  
              
            for(int j=0; j<left.size(); j++){            
                for(int k=0; k<right.size(); k++){  
                    TreeNode root = new TreeNode(i);     
                    root.left = left.get(j);  
                    root.right = right.get(k);  
                    result.add(root);  
                }  
            }  
        }         
        System.out.println(result.size());
        return result;  
	}
}
