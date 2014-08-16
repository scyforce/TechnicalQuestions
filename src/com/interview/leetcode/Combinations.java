package com.interview.leetcode;

import java.util.ArrayList;

/**

	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	
	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]

 * @author shuchun.yang
 *
 */
public class Combinations {
	
	public static void main(String[] args) {
		Combinations c = new Combinations();
		c.combine(4, 2);
	}
	
	// k numbers out of 1 ... n.
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result= new ArrayList<Integer>();
        combine(result, results, 0, n, k);       
        return results;        
    }
		
	public void combine(ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results, int level, int n,  int k) {
		//if it reached the size of k
		if (result.size()==k) {
			//add all result to results
			results.add(new ArrayList<Integer>(result));
		} else {
			for (int i=level; i<n; i++) {
				result.add(i+1);
				combine(result, results, i+1, n, k);
				//why remove last element in the list, because the last element has been added to results with previous elements in the list
				//so no need to calculate again.
				result.remove(result.size()-1);
			}
		}		
	}
}
