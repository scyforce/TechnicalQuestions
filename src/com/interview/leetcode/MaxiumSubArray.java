package com.interview.leetcode;

/**

	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	
	For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	the contiguous subarray [4,-1,2,1] has the largest sum = 6.
	
	More practice:
	If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 * @author shuchun.yang
 *
 */
//http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class MaxiumSubArray {
	public int maxSubArray(int[] A) {
        if (A==null || A.length==0) {
        	return 0;
        }
        
        int largestNegative = checkIfAllNegatives(A);
        if (largestNegative<0) {
        	return largestNegative;
        }
		
        //sum is to track the max sum
		int sum = 0;
		//sumEndHere is used to track positive sums
		int sumEndHere = 0;
		for (int i=0; i<A.length; i++) {
			sumEndHere += A[i];
			if (sumEndHere<0) {
				sumEndHere = 0;
			} else if (sum<sumEndHere) {
				sum = sumEndHere;
			}
		}
		return sum;      
    }
	
	public int checkIfAllNegatives(int[] A) {
		int largestNegative = Integer.MIN_VALUE;
		for (int i=0; i<A.length; i++) {
			if (A[i]>=0) {
				return 0;
			} else {
				if (largestNegative < A[i]) {
					largestNegative = A[i];
				}					
			}
		}
		
		return largestNegative;
	}
	
	public int maxSubArrayDP(int[] A) {
		if (A==null || A.length==0) {
        	return 0;
        }
		int sumSoFar = A[0];
		int currMax = A[0];
		
		for (int i=1; i<A.length; i++) {
			currMax = Math.max(A[i], currMax+A[i]);
			sumSoFar = Math.max(sumSoFar, currMax);
		}
		return sumSoFar;
	}
}
