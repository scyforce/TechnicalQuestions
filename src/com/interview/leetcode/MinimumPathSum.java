package com.interview.leetcode;

/**

	Given a m x n grid filled with non-negative numbers, 
	
	find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	
	Note: You can only move either down or right at any point in time.

 * @author shuchun.yang
 *
 */
public class MinimumPathSum {
	
	//http://www.mathblog.dk/project-euler-81-find-the-minimal-path-sum-from-the-top-left-to-the-bottom-right-by-moving-right-and-down/
	public int minPathSum(int[][] grid) {
		int rows=grid.length;
        if(rows==0) {
        	return 0;
        }
        
        int columns=grid[0].length;
        if(columns==0) {
        	return 0;
        }
        
        int[][] results = new int[rows][columns];

        /*
         * [1  2  3  4
         *  5  6  7  8
         *  9 10 11 12
         * ]
         * 
         * look at grid[2][3]=12, it can come from grid[1][3]=8 or grid[2][2]=11, so we pick the minimum one plus 12
         * 
         */
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {               
                if(i==0&&j==0) {
                	results[0][0]=grid[0][0];
                //on first column
                } else if (j==0) {
                	results[i][0]=results[i-1][0]+grid[i][0];
                //on first row
                } else if(i==0) {
                	results[0][j]=results[0][j-1]+grid[0][j];
                //always compare previous path find the smaller one add the current node value
                } else {
                	results[i][j]=Math.min(results[i-1][j],results[i][j-1])+grid[i][j];
                }
            }
        }
        return results[rows-1][columns-1];  
    }
}
