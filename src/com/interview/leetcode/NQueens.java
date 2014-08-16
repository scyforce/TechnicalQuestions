package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
	
	Given an integer n, return all distinct solutions to the n-queens puzzle.
	
	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
	
	For example,
	There exist two distinct solutions to the 4-queens puzzle:
	
	[
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]

 * @author shuchun.yang
 *
 */
public class NQueens {
	public static void main(String[] args) {
		NQueens n = new NQueens();
		
		ArrayList<String[]> results = n.solveNQueens(9);
		
		for (String[] result : results) {
			System.out.println(Arrays.toString(result));
		}
		
	}
	
	public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> results = new ArrayList<String[]>();
        if (n<1) {
        	return results;
        }
        
        solveNQueens(0, n, new String[n], results);
        
        return results;       
    }
	
	private void solveNQueens(int currentRow, int n, String[] result, ArrayList<String[]> results ){
		//we start from 0
		if (currentRow==n) {
			results.add(result.clone());
			return;
		}
		
		for (int qColumn=0; qColumn<n; qColumn++) {
			//judge if putting Q at column i is correct
			if (!isValidPosition(qColumn, currentRow, result)) {
				continue;
			}
			
			//construct row when putting Q at column i
			char[] cArray = new char[n];
			Arrays.fill(cArray, '.');
			cArray[qColumn] = 'Q';
			
			result[currentRow] = String.valueOf(cArray);
			solveNQueens(currentRow+1, n, result, results);			
		}
	}
	
	private boolean isValidPosition(int currentQColumn, int currentRow, String[] result) {		
		for (int previousRow=0; previousRow<currentRow; previousRow++) {
			int previousQColumn = result[previousRow].indexOf("Q");
			//check condition one: Q can not be placed in the same column as previous rows
			if (previousQColumn==currentQColumn) {
				return false;
			}
			
			int columnDistance = Math.abs(currentQColumn-previousQColumn);
			int rowDistance = Math.abs(currentRow-previousRow);
			//check condition two: Math.abs(currentColumn-previousColumn)!=Math.abs(currentRow-previousRow)
			if (columnDistance==rowDistance) {
				return false;
			}
		}
		return true;

	}
	
}
