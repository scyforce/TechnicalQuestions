package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	
	For example,
	[1,1,2] have the following unique permutations:
	[1,1,2], [1,2,1], and [2,1,1].

 * @author shuchun.yang
 *
 */
public class PermutationsII {
	public static void main(String[] args) {
		int[] num = {2,2,1,1};
		
		PermutationsII p = new PermutationsII();
	
		ArrayList<ArrayList<Integer>> results = p.permuteUnique(num);
		
		for (ArrayList<Integer> result : results) {
			System.out.println(Arrays.toString(result.toArray()));
		}
	}
	
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num!=null && num.length>0) {
			permuteUnique(num, 0, result);
		}		
		return result;
	}
	
	
	public void permuteUnique(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
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
			if (noDuplicate(num, start, i)) {
				swap(num, i, start);
				permuteUnique(num, start+1, result);
				//swap back;
				swap(num, i, start);
			}			
		}
	}
	
	//why??
	private boolean noDuplicate(int[] num, int start, int end) {
		for (int i = start; i < end; i++) {
			if (num[i] == num[end]) {
				return false;
			}
		}
		return true;
	}
	
	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
