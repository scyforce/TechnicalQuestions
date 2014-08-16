package com.interview.leetcode;

import java.util.Arrays;

/**

	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
	
	Return the sum of the three integers. You may assume that each input would have exactly one solution.
	
	    For example, given array S = {-1 2 1 -4}, and target = 1.
	
	    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 * @author shuchun.yang
 *
 */
public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] num = {-1,2,1,-4};
		int target = 1;
		
		ThreeSumClosest s = new ThreeSumClosest();
		s.threeSumClosest(num, target);
	}
	
	public int threeSumClosest(int[] num, int target) {
        if (num==null || num.length<3) {
        	return -1;
        }
        //sort array first
        Arrays.sort(num);
        
        int result = 0;
        int finalDiff = Integer.MAX_VALUE;
        
        for (int i=0; i<num.length-2; i++) {
        	int start = i+1;
        	int end = num.length-1;
        	
        	while (start<end) {
        		int sum = num[i] + num[start] + num[end];
        		int diff = Math.abs(sum-target);
        		if (diff<finalDiff) {
        			finalDiff = diff;
        			result = sum;
        		}
        		
        		//move start if sum is less than target
        		if (sum<=target) {
        			start=start+1;
        		} else {
        			end=end-1;
        		}    		
        	}
        	
        	
        }
    	return result;
    }
}
