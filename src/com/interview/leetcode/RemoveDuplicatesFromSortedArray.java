package com.interview.leetcode;

/**

	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	
	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	For example,
	Given input array A = [1,1,2],
	
	Your function should return length = 2, and A is now [1,2].

 * @author shuchun.yang
 *
 */
public class RemoveDuplicatesFromSortedArray {
	//remove duplicates
	public int removeDuplicates(int[] A) {
        if (A==null || A.length==0) {
        	return 0;
        }
        //Remove element
        int count = 1;
		int previous = A[0];
        for (int i=1; i<A.length; i++) {
        	if (A[i] != previous) {
        		A[count] = A[i];
        		count = count+1;
        	}
        	previous = A[i];
        }
        return count;
		
    }
}
