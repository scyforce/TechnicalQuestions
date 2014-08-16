package com.interview.leetcode;

import java.util.ArrayList;

/**

	Given a collection of numbers, return all possible permutations.
	
	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

 * @author shuchun.yang
 *
 */
public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num!=null) {
			permute(num, 0, result);
		}		
		return result;
    }
	
	public void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
		//if start equals to array length, need to add the current array to results;
		if (start == num.length) {
			ArrayList<Integer> afterPermutation = new ArrayList<Integer>();
			for (int i=0; i<num.length;i++) {
				afterPermutation.add(num[i]);
			}
			result.add(afterPermutation);
		}
		
		for (int i=start; i<num.length; i++) {
			//will change from [1,2,3] -> [1,2,3];
			//[1,2,3] -> [2,1,3];
			//[1,2,3] -> [3,2,1];
			swap(num, i, start);
			permute(num, start+1, result);
			//swap back;
			swap(num, i, start);
		}
	}
	
	
	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
