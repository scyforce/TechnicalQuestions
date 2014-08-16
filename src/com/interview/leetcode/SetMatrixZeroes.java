package com.interview.leetcode;

/**

	Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
	
	click to show follow up.
	
	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?

 * @author shuchun.yang
 *
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix==null||matrix.length==0) {
			return;
		}
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;
        
        //check if first row should be zero
        for (int j=0; j<matrix[0].length; j++) {
        	if (matrix[0][j]==0) {
        		isFirstRowZero = true;
        		break;
        	}
        }
        
        //check if first column should be zero
        for (int i=0; i<matrix.length; i++) {
        	if (matrix[i][0]==0) {
        		isFirstColumnZero = true;
        		break;
        	}
        }
        
        //check if the element is zero, if so set the corresponding first row and first column to zero
        for (int i=1; i<matrix.length; i++) {
        	for (int j=1; j<matrix[i].length; j++) {
        		if (matrix[i][j]==0) {
        			matrix[i][0]=0;
        			matrix[0][j]=0;
        		}
        	}
        }
        
        //set matrix to zero
        for (int i=1; i<matrix.length; i++) {
        	for (int j=1;j<matrix[0].length; j++) {
        		if (matrix[i][0]==0||matrix[0][j]==0) {
        			matrix[i][j]=0;
        		}
        	}
        }
        
        //set first row
        if (isFirstColumnZero) {
        	for (int i=0; i<matrix.length; i++) {
            	matrix[i][0]=0;
            }
        }
        
        //set first column
        if (isFirstRowZero) {
        	for (int j=0; j<matrix[0].length; j++) {
        		matrix[0][j]=0;
        	}
        }
        
 
    }
}
