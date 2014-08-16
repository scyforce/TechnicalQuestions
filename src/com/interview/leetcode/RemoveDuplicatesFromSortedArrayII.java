package com.interview.leetcode;

/**

	Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	
	Your function should return length = 5, and A is now [1,1,2,2,3].

 * @author shuchun.yang
 *
 */
public class RemoveDuplicatesFromSortedArrayII {	
	public static void main(String[] args) {
		int[] array = {1,1,1,2,2,3};
		RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
		System.out.println(r.removeDuplicatesII(array));
	}
	
	public int removeDuplicatesII(int[] A) {
		if (A==null || A.length==0) {
        	return 0;
        }
        //Remove element
        int count = 1;
		int previous = A[0];
		boolean matchTwice = true;
        for (int i=1; i<A.length; i++) {
        	if (A[i] != previous) {
        		matchTwice = true;
        		A[count] = A[i];
        		count = count+1;
        	} else {
        		if (matchTwice) {
        			A[count] = A[i];
            		count = count+1;
        		}
        		matchTwice = false;
        	}
        	previous = A[i];
        }
        return count;
    }	
}
