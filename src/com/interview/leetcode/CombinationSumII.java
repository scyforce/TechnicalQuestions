package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	
	Each number in C may only be used once in the combination.
	
	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6]

 * @author shuchun.yang
 *
 */
public class CombinationSumII {
	public static void main(String[] args) {
		CombinationSumII c = new CombinationSumII();
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		ArrayList<ArrayList<Integer>> results = c.combinationSum2(num, target);
		for (ArrayList<Integer> result : results) {
			System.out.println(Arrays.toString(result.toArray()));
		}
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num==null||num.length==0) {
        	return results;
        }
        Arrays.sort(num);
        
        combinationSum2(results, new ArrayList<Integer>(), 0, num, target, 0);
        
        return results;
    }
	
	public void combinationSum2(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int sum, int[] num, int target, int level) {
		if (sum>target) {
			return;
		}
		
		if (sum==target) {
			ArrayList<Integer> solution = new ArrayList<Integer>(result);
			results.add(solution);
			return;
		}
		
		//since the passed num is sorted, use one previous value to track already added value to avoid duplicate solution
		int previous = -1;
		for (int i=level; i<num.length; i++) {
			if (num[i]!=previous) {
				result.add(num[i]);
				sum+=num[i];
				combinationSum2(results, result, sum, num, target, i+1);
				previous = num[i];
				sum-=num[i];
				result.remove(result.size()-1);
			}			
		}
	}
}
