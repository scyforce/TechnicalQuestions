package com.interview.leetcode;


import com.interview.algorithm.util.MathUtils;

/**

	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	
	For example,
	Given n = 3,
	
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]

 * @author shuchun.yang
 *
 */
public class SpiralMatrixII {
	public static void main(String[] args) {
		SpiralMatrixII s = new SpiralMatrixII();
		int[][] matrix = s.generateMatrix(3);
		MathUtils.printMatrix(matrix);
	}
	
	public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n<1) {
        	return matrix;
        }
        
        generateMatrix(matrix, n, n, 0, 1);
        
        return matrix;        
    }
	
	 private void generateMatrix(int[][] matrix, int rows, int columns, int level, int number) {
		 if (rows<=0||columns<=0) {
			 return;
		 }
		 
		// single row for not square matrix
    	if (rows == 1) {
    	    for (int j = 0; j < columns; j++) {
    	    	matrix[level][level+j] = number;
    	    	number++;
    	    }
    	    return;
    	 }
    	 // single row for not square matrix
    	 if (columns == 1) {
    	    for (int i = 0; i < rows; i++) {
    	    	matrix[level+i][level] = number;
    	    	number++;
    	    }
    	    return;
    	 }
		 
		 // print from top left
    	 for (int j = 0; j < columns - 1; j++) {
    		 matrix[level][level+j] = number;
    		 number++;
    	 }
    	 // print from top right
    	 for (int i=0; i<rows-1; i++) {
    		 matrix[level+i][level+columns-1] = number;
    		 number++;
    	 }
    	 // print from bottom right
    	 for (int j=0; j<columns-1; j++) {
    		 matrix[level+rows-1][level+columns-1-j] = number;
    		 number++;
    	 }
    	 // print from bottom left
    	 for (int i=0; i<rows-1; i++) {
    		 matrix[level+rows-1-i][level] = number;
    		 number++;
    	 }
    	 generateMatrix(matrix, rows-2, columns-2, level+1, number);
	 }
}
