package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**

	Given a collection of integers that might contain duplicates, S, return all possible subsets.

	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,2], a solution is:
	
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]

 * @author shuchun.yang
 *
 */
public class SubsetsII {
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
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
				while(i<S.length-1 && S[i]==S[i+1]) {
					i++;
				}
			}
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup1(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num==null||num.length==0) {
			return results;
		}
		
		//num of elements
		int numOfSubsets = 1 << num.length; 

		for(int i = 0; i < numOfSubsets; i++) {
			int pos = num.length - 1;
		    int bitmask = i;
		    ArrayList<Integer> result = new ArrayList<Integer>();
		    //the idea is if the bit of i is 1, then add the element in the array to the result
		    while(bitmask > 0) {
		    	//check if that bit is 1
		    	if((bitmask & 1) == 1) {
		    		result.add(num[pos]);
		    	}	
		    	//move to the next bit
		    	bitmask >>= 1;
		        //move array position left
		    	pos--;
		   }
		   Collections.sort(result);
		   
		   if (!containsList(results, result)) {
			   results.add(result);
		   }	   
		}
		return results;
    }
	
	public boolean containsList(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result) {
		for (ArrayList<Integer> list : results) {
			if(list.size()==result.size()) {
				boolean contains = true;
				for (int i=0; i<list.size(); i++) {
					if (list.get(i)!=result.get(i)) {
						contains=false;
						break;
					}
				}
				if (contains) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		result.add(2);
		
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result1.add(2);
		result1.add(2);
		
		/*ArrayList<Integer> result2 = new ArrayList<Integer>();
		result1.add(2);
		result1.add(3);
		
		ArrayList<Integer> result3 = new ArrayList<Integer>();
		result1.add(2);
		result1.add(4);*/
		
		results.add(result1);
		results.add(result);
		
		
		SubsetsII s = new SubsetsII();
		int[] num = {1,2,2};
		System.out.println(s.subsetsWithDup(num));
		
		
	}
}
