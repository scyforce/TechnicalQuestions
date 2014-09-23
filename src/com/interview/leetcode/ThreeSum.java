package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**

	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	
	Note:
	Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ² b ² c)
	The solution set must not contain duplicate triplets.
	    For example, given array S = {-1 0 1 2 -1 -4},
	
	    A solution set is:
	    (-1, 0, 1)
	    (-1, -1, 2)

 * @author shuchun.yang
 *
 */
public class ThreeSum {
	public static void main(String[] args) {
		int[] num = {-1,0,1,2,-1,-4};
		ThreeSum ts = new ThreeSum();
		
		ArrayList<ArrayList<Integer>> results = ts.threeSumHash(num);
		for (ArrayList<Integer> result : results) {
			System.out.println(Arrays.toString(result.toArray()));
		}
	}
	
	public ArrayList<ArrayList<Integer>> threeSumHash(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num==null||num.length<3) {
			return results;
		}
		
		HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
		int target = 0;
		
		for (int i=0; i<num.length-2; i++) {
			for (int j=i+1; j<num.length; j++) {
				if (map.containsKey(num[j])) {
					int[] pair = map.get(num[j]);
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(num[j]);
					result.add(pair[0]);
					result.add(pair[1]);
					results.add(result);
					map.remove(num[i]);
				} else {
					map.put(target-num[i]-num[j], new int[]{num[i], num[j]});
				}
			}
		}
		return results;
	}
	
	//O(n2)
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length<3) {
        	return results;
        }
        //sort array first
        Arrays.sort(num);
        
        int target = 0;
        
        //only need to calculate to i, i+1, i+2]
        for (int i=0; i<num.length-2; i++) {
        	//no need to find [-1,-1,2] and [-1,-1,2] again
    		if (i==0||num[i]>num[i-1]) {
            	int reverseTarget = target - num[i];
            	int start = i+1;
            	int end = num.length-1;
    			//apply two sum idea
    			while (start<end) {       		
        			if (num[start]+num[end]==reverseTarget) {
        				ArrayList<Integer> result = new ArrayList<Integer>();
        				result.add(num[i]);
        				result.add(num[start]);
        				result.add(num[end]);
        				results.add(result);
        				start = start + 1;
        				end = end - 1;
        				//compare current start and previous start, if same keep going
        				while (start<end&&num[start]==num[start-1]) {
        					start = start + 1;
        				}
        				while (start<end&&num[end]==num[end+1]) {
        					end = end - 1;
        				}
        			} else if (num[start]+num[end]<reverseTarget) {
        				start = start + 1;
        			} else {
        				end = end - 1;
        			}
        		}        		
        	}       	
        }
    	return results;
    }
}
