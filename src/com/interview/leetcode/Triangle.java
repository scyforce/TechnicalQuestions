package com.interview.leetcode;

import java.util.ArrayList;

/**

	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	
	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	
	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

 * @author shuchun.yang
 *
 */
public class Triangle {
	public static void main(String[] args) {
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);
		l2.add(3);
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(l1);
		triangle.add(l2);
		
		Triangle t = new Triangle();
		System.out.println(t.minimumTotal(triangle));
	}
	
	
	//bottom up
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] results = new int[triangle.size()];
        ArrayList<Integer> lastRow = triangle.get(results.length-1);      
        
        //set results to lastRow value
		for (int i=0; i<lastRow.size(); i++) {
			results[i] = lastRow.get(i);
		}
		
		//calculate from bottom up, the second to last row
		for (int i=triangle.size()-2; i>=0; i--) {
			ArrayList<Integer> currentRow = triangle.get(i);
			for (int j=0; j<currentRow.size(); j++) {
				//current row value + small value from row below (j, j+1);
				results[j] = currentRow.get(j) + Math.min(results[j], results[j+1]);
			}
		}
		
		return results[0];
    }
}
