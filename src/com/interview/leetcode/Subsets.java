package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**

	Given a set of distinct integers, S, return all possible subsets.
	
	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]

 * @author shuchun.yang
 *
 */
public class Subsets {
	
	public static void main(String[] args) {
		int[] S = {3,2,1};
		Subsets s = new Subsets();
		ArrayList<ArrayList<Integer>> results = s.subsets(S);
		
		for (ArrayList<Integer> result : results) {
			System.out.println(Arrays.toString(result.toArray()));
		}
		
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S==null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		//All [] is a subset
		results.add(new ArrayList<Integer>());
		
		Arrays.sort(S);
		
		subsets(new ArrayList<Integer>(), results, 0, S);
		return results;		
	}
	
	public void subsets(ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results, int level, int[] S) {
			for (int i=level; i<S.length; i++) {
				result.add(S[i]);				
				results.add(new ArrayList<Integer>(result));
				subsets(result, results, i+1, S);
				result.remove(result.size()-1);				
			}
	}
	

	public ArrayList<ArrayList<Integer>> subsets1(int[] S) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (S==null||S.length==0) {
			return results;
		}
		
		//num of elements
		int numOfSubsets = 1 << S.length; 

		for(int i = 0; i < numOfSubsets; i++) {
			int pos = S.length - 1;
		    int bitmask = i;
		    ArrayList<Integer> result = new ArrayList<Integer>();
		    //the idea is if the bit of i is 1, then add the element in the array to the result
		    while(bitmask > 0) {
		    	//check if that bit is 1
		    	if((bitmask & 1) == 1) {
		    		result.add(S[pos]);
		    	}	
		    	//move to the next bit
		    	bitmask >>= 1;
		        //move array position left
		    	pos--;
		   }
		   Collections.sort(result);
		   results.add(result);
		}
		return results;
    }
}
