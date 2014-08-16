package com.interview.leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author shuchun.yang
 *
 */
public class UniqueBinarySearchTrees {
	public int numTreesDP(int n) {
		int[] results = new int[n];
		results[0] = 1;
		results[1] = 1;
		
		for (int i=2; i<n; i++) {
			for (int j=0; j<i; j++) {
				results[i] += results[j] + results[i-j-1];
			}
		}      
        return results[n];
    }
		
	
	public int numTrees(int n) {
        return numTrees(1, n);
    }
	
	//当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
	//以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成, number=numberOfLeftChild*numberOfRightChild
	public int numTrees(int start, int end) {
        if (start>=end) {
        	return 1;
        }     
        int totalNum = 0;  
        for (int i=start; i<=end; i++) {
        	totalNum += numTrees(start,i-1)*numTrees(i+1,end); 
        }         
        return totalNum;  
    }
}
