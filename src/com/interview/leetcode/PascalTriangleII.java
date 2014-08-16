package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	Given an index k, return the kth row of the Pascal's triangle.
	
	For example, given k = 3,
	Return [1,3,3,1].
	
	Note:
	Could you optimize your algorithm to use only O(k) extra space?

 * @author shuchun.yang
 *
 */
public class PascalTriangleII {	
	public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> results = new ArrayList<Integer>(rowIndex+1);
        if (rowIndex<0) {
        	return results;
        }
        
        for (int i=0; i<rowIndex+1; i++) {
        	results.add(i, 1);
        }
        
        //first and last will always be 1
        for (int i=1; i<rowIndex; i++) {
        	int previous = 1;
        	for (int j=1; j<=i; j++) {
        		//always save the current index value
        		int temp = results.get(j);
        		//set current index value to add results
        		results.set(j, previous+results.get(j));
        		//set value to previous
        		previous = temp;
        	}
        }
        return results;   
    }
	
	public static void main(String[] args) {
		PascalTriangleII pt = new PascalTriangleII();
		System.out.println(Arrays.toString(pt.getRow(5).toArray()));
	}
}
