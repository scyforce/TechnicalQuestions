package com.interview.leetcode;

/**

	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	
	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.

 * @author shuchun.yang
 *
 */
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) {
        	return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
               
        int start = 0;
        int end = m*n-1;
        
        while (start<=end) {
        	int middle = start + (end-start)/2;
        	int middleX = middle/n;
        	int middleY = middle%n;
        	
        	if (matrix[middleX][middleY]==target) {
        		return true;
        	} else if (matrix[middleX][middleY]>target) {
        		end = middle-1;
        	} else {
        		start = middle+1;
        	}
        }
        return false;
    }
}
