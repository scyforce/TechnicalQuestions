package com.interview.leetcode;

/**

	Follow up for "Unique Paths":
	
	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	
	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
	
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.
	
	Note: m and n will be at most 100.

 * @author shuchun.yang
 *
 */
public class UniquePathsII {
	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		
		UniquePathsII f = new UniquePathsII();
		System.out.println(f.uniquePathsWithObstacles(obstacleGrid));
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid==null||obstacleGrid.length==0) {
			return 0;
		}
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] results = new int[m][n];
        
		
        //initialize all values
        for (int i=0; i<m; i++) {
        	for (int j=0; j<n; j++) {
        		//if current element is an obstacle, set to 0
        		if (obstacleGrid[i][j]==1) {
        			results[i][j]=0;
        			continue;
        		}
        		
        		//first element in the grid
        		if (i==0&j==0) {
        			results[i][j]=1;
        		}
        		
        		if (i>0) {
        			//if previous element in the row is not obstacle and there is a path set to 1
        			if (obstacleGrid[i-1][j]==0 && results[i-1][j]==1) {
        				results[i][j] = 1;
        			}
        		}
        		
        		if (j>0) {
        			//if previous element in the column is not obstacle and there is a path set to 1
        			if (obstacleGrid[i][j-1]==0 && results[i][j-1]==1) {
        				results[i][j] = 1;
        			}
        		}  		
        	}
        }
        
        //formula: (i,j) = (i-1,j) + (i,j-1);
        for (int i=1; i<m; i++) {
        	for (int j=1; j<n; j++) {
        		//only compute if current element do have paths
        		if (results[i][j]!=0) {
        			results[i][j] = results[i-1][j] + results[i][j-1];
        		}       		
        	}
        }       
        return results[m-1][n-1];
    }
}
