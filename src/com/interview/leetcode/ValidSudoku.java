package com.interview.leetcode;

/**

	Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	
	The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	
	A partially filled sudoku which is valid.
	
	Note:
	A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
	
	Rule of Sudoku:
	1. Each row must have the number 1-9 occuring just once.
	
	2. Each column must have the number 1-9 occuring just once.
	
	3. The number 1-9 must occur just once in each of sub-boxes of the grid.
	
	..4...63.
	.........
	5......9.
	...56....
	4.3.....1
	...7.....
	...5.....
	.........
	.........

 * @author shuchun.yang
 *
 */
public class ValidSudoku {
	public static void main(String[] args) {
		String sudoku = "..4...63..........5......9....56....4.3.....1...7........5.......................";
		
		char[][] board = new char[9][9];
		int index = 0;
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				board[i][j] = sudoku.charAt(index);
				index++;
			}
		}
		
		ValidSudoku v = new ValidSudoku();
		System.out.println(v.isValidSudokuR(board));
	}
	
	//O(3*n^2) n=9
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}
					
		for (int i = 0; i < 9; i++) {
			boolean[] map = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int curr = board[i][j] - '1';
					if (map[curr]) {
						return false;
					}
					map[curr] = true;
				}
			}
		}
		
		for (int j = 0; j < 9; j++) {
			boolean[] map = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					int curr = board[i][j] - '1';
					if (map[curr]) {
						return false;
					}
					map[curr] = true;
				}
			}
		}
		
		//i = block/3 *3, j = block%3*3
		for (int block = 0; block < 9; block++) {
			boolean[] map = new boolean[9];
			for (int i = block/3 * 3; i < block/3 * 3 + 3; i++) {
				for (int j = block%3 * 3; j < block%3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						int curr = board[i][j] - '1';
						if (map[curr]) {
							return false;
						}
						map[curr] = true;
					}
				}
			}
		}
		return true;
	}  
	
	
	public boolean isValidSudokuR(char[][] board) {
        if (board==null || board.length!=9 || board[0].length!=9) {
        	return false;
        }
        
        for (int i=0; i<9; i++) {
        	for (int j=0; j<9; j++) {
        		if (board[i][j]!='.') {
        			if (!isValidSudokuR(board, i, j)) {
        				return false;
        			}
        		}
        	}
        }
        return true;
    }
	
	private boolean isValidSudokuR(char[][] board, int row, int column) {
		char data = board[row][column];
		//check row;
		for (int i=row+1; i<board.length; i++) {
			if (board[i][column]==data) {
				return false;
			}
		}
		
		//check column;
		for (int j=column+1; j<board[0].length; j++) {
			if (board[row][j]==data) {
				return false;
			}
		}
		
		//check sub grid, number of sub grid is from 0 to 8
		for(int i=0;i<9;i++){
			//row index
            int row_s=3*(row/3) + i/3; 
            //column index
            int column_s=3*(column/3) + i%3;
            if((row_s>row || column_s>column) && board[row_s][column_s]==data) {
            	return false;
            }            
        }
		return true;
	}
}
