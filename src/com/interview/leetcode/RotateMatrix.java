package com.interview.leetcode;

/**

	Rotate a matrix

 * @author shuchun.yang
 *
 */
public class RotateMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},
						  {4,5,6},
						  {7,8,9}
						 };
		RotateMatrix r = new RotateMatrix();
		
		r.rotateInPlace(matrix);
		
		for (int[] row : matrix) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	public void rotate(int[][] matrix) {
        if (matrix==null || matrix.length==0) {
        	return;
        }
        int n = matrix.length;
        
        int[][] newMatrix = new int[n][n];
        
        for (int i=0; i<n; i++) {
        	for (int j=0; j<n; j++) {
        		newMatrix[i][j] = matrix[n-j-1][i];
        	}
        }
        
        for (int i=0; i<newMatrix.length; i++) {
        	for (int j=0; j<newMatrix[i].length; j++) {
        		matrix[i][j] = newMatrix[i][j];
        	}
        }
        
    }
	
	public void rotateInPlace(int[][] matrix) {
		int n=matrix.length;  
        for(int i=0;i<n/2;i++) {  
            for(int j=0;j<(n+1)/2;j++) {  
            	//store top left   
            	int temp = matrix[i][j];
            	//set top left from bottom left - because j will increase in each loop, so move element from bottom left, element above bottom left etc.
    			matrix[i][j] = matrix[n-1-j][i];
    			//set bottom left from bottom right
    			matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
    			//set bottom right from top right
    			matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
    			//set top right from top left
    			matrix[j][n-1-i] = temp;
            }
        }       
    }
}
