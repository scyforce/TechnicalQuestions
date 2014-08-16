package com.interview.leetcode;

import java.util.ArrayList;

/**

	Given numRows, generate the first numRows of Pascal's triangle.
	
	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]

 * @author shuchun.yang
 *
 */
public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if (numRows<0) {
        	return null;
        }
		
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();   
        for (int i=0; i<numRows; i++) {
        	ArrayList<Integer> rows = new ArrayList<Integer>();
        	rows.add(1);
        	
        	if (i>1) {
        		ArrayList<Integer> previousRows = results.get(i-1);
        		for (int j=1; j<i; j++) {
            		rows.add(previousRows.get(j-1) + previousRows.get(j));
            	}
        	}
        	
        	if (i>0) {
        		rows.add(1);
        	}
        	
        	results.add(rows);
        } 
        return results;
    }
}
