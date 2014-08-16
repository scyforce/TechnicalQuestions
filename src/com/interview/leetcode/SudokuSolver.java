package com.interview.leetcode;


/**

	Write a program to solve a Sudoku puzzle by filling the empty cells.
	
	Empty cells are indicated by the character '.'.
	
	You may assume that there will be only one unique solution.
	
	
	A sudoku puzzle...
	
	
	...and its solution numbers marked in red.

 * @author shuchun.yang
 *
 */
public class SudokuSolver {
	
	public void solveSudoku(char[][] board) { 
		if (board==null) {
			return;
		}
		solveSudoku(board,0,0);  
	} 
	
	private boolean solveSudoku(char[][] board, int i, int j) {
		
		//after solving row by row, solve the problem column by column
		if (j >= 9) {
			return solveSudoku(board, i + 1, 0);
		}
			
		if (i == 9) {
			return true;
		}
		
		if (board[i][j] == '.') {
			for (int k = 1; k <= 9; k++) {
				board[i][j] = (char) (k + '0');
				
				if (isValid(board, i, j)) {
					if (solveSudoku(board, i, j + 1)) {
						return true;
					}
						
				}
				board[i][j] = '.';
			}
		} else {
			//start solving the problem row by row
			return solveSudoku(board, i, j + 1);
		}
		return false;
	}

	private boolean isValid(char[][] board, int i, int j) {
		//only need to check row i
		for (int k = 0; k < 9; k++) {
			if (k != j && board[i][k] == board[i][j]) {
				return false;
			}
				
		}
		//only need to check column j
		for (int k = 0; k < 9; k++) {
			if (k != i && board[k][j] == board[i][j]) {
				return false;
			}
				
		}
		
		//only check that sub grid
		for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
			for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
				if ((row != i || col != j) && board[row][col] == board[i][j]) {
					return false;
				}					
			}
		}
		return true;
	}
}
