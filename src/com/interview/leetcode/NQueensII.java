package com.interview.leetcode;

import java.util.Arrays;

/**

	Follow up for N-Queens problem.
	
	Now, instead outputting board configurations, return the total number of distinct solutions.


 * @author shuchun.yang
 *
 */
public class NQueensII {
	
	public int totalNQueens(int n) {
        if (n<1) {
        	return 0;
        }
        
        int results = totalNQueens(0, n, new String[n]);      
        return results;       
    }
	
	private int totalNQueens(int currentRow, int n, String[] result){
		//we start from 0
		if (currentRow==n) {
			return 1;
		}
		int results = 0;
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
			results+=totalNQueens(currentRow+1, n, result);
		}
		return results;
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
