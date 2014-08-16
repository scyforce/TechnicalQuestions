package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	
	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	
	You should return [1,2,3,6,9,8,7,4,5].

 * @author shuchun.yang
 *
 */
public class SpiralMatrix {
	public static void main(String[] args) {
		SpiralMatrix s = new SpiralMatrix();
		int[][] matrix = {{1,2,3},
				          {8,9,4},
				          {7,6,5}};
		
		ArrayList<Integer> results = s.spiralOrder(matrix);
		System.out.println(Arrays.toString(results.toArray()));
	}
	
	
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		if (matrix==null||matrix.length==0) {
			return results;
		}
		
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        spiralOrder(results, matrix, rows, columns, 0);
        
        return results;
    }

    private void spiralOrder(ArrayList<Integer> results, int[][] matrix, int rows, int columns, int level) {
    	//end recursion case
    	if (rows <= 0 || columns <= 0) {
    		return; 
    	}
    	// single row
    	if (rows == 1) {
    	    for (int j = 0; j < columns; j++) {
    	    	results.add(matrix[level][level+j]);
    	    }
    	    return;
    	 }
    	 if (columns == 1) {
    	    for (int i = 0; i < rows; i++) {
    	    	results.add(matrix[level+i][level]);
    	    }
    	    return;
    	 }
    	 
    	 // print from top left
    	 for (int j = 0; j < columns - 1; j++) {
    		 results.add(matrix[level][level+j]);
    	 }
    	 // print from top right
    	 for (int i=0; i<rows-1; i++) {
    		 results.add(matrix[level+i][level+columns-1]);
    	 }
    	 // print from bottom right
    	 for (int j=0; j<columns-1; j++) {
    		 results.add(matrix[level+rows-1][level+columns-1-j]);
    	 }
    	 // print from bottom left
    	 for (int i=0; i<rows-1; i++) {
    		 results.add(matrix[level+rows-1-i][level]);
    	 }
    	 spiralOrder(results, matrix, rows-2, columns-2, level+1);
    }
}
