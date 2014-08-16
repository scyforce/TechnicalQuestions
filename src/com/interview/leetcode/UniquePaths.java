package com.interview.leetcode;

/**

	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	
	How many possible unique paths are there?
	
	
	Above is a 3 x 7 grid. How many possible unique paths are there?
	
	Note: m and n will be at most 100.

 * @author shuchun.yang
 *
 */
public class UniquePaths {
	//dynamic programming - http://www.mathblog.dk/project-euler-15/
	public int uniquePaths(int m, int n) {
        int[][] results = new int[m][n];
        
        //initialize all values
        for (int i=0; i<m; i++) {
        	for (int j=0; j<n; j++) {
        		results[i][j] = 1;
        	}
        }
        
        //formula: (i,j) = (i-1,j) + (i,j-1);
        for (int i=1; i<m; i++) {
        	for (int j=1; j<n; j++) {
        		results[i][j] = results[i-1][j] + results[i][j-1];
        	}
        }
        
        return results[m-1][n-1];
    }
}
