package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	
	The same repeated number may be chosen from C unlimited number of times.
	
	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] 

 * @author shuchun.yang
 *
 */
public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		CombinationSum c = new CombinationSum();
		ArrayList<ArrayList<Integer>> results = c.combinationSum(candidates, target);
		
		
		System.out.println(results);
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (candidates==null || candidates.length==0) {
			return results;
		}
        Arrays.sort(candidates);
		
        combinationSum(results, new ArrayList<Integer>(), 0, candidates, target, 0);
		
		return results;
    }
	
	//candidates need to be sorted
	public void combinationSum(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int sum, int[] candidates, int target, int level) {
		if (sum>target) {
			return;
		}
		if (sum==target) {
			ArrayList<Integer> solution = new ArrayList<Integer>(result);
			results.add(solution);
			return;
		}
		
		for (int i=level; i<candidates.length; i++) {
			sum = sum + candidates[i];
			result.add(candidates[i]);
			//we pass the current level in, so it will keep adding the current element until it is more than the target
			combinationSum(results, result, sum, candidates, target, i);
			result.remove(result.size()-1);
			sum = sum - candidates[i];
		}	
	}
}
