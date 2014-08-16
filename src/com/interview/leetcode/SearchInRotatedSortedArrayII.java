package com.interview.leetcode;

/**

	Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?
	
	Would this affect the run-time complexity? How and why?
	
	Write a function to determine if a given target is in the array.

 * @author shuchun.yang
 *
 */
public class SearchInRotatedSortedArrayII {
	//difference [1,3,1,1,1], can not determine which half is increasing
	public boolean searchII(int[] A, int target) {
        if (A==null || A.length==0) {
        	return false;
        }
        
        int left = 0;
        int right = A.length-1;
        
        while (left<=right) {
        	int middle = left+(right-left)/2;
        	if (A[middle]==target) {
        		return true;
        	}
        	//the left part is increasing
        	if (A[middle]>A[left]) {
        		if (A[left]==target) {
        			return true;
        		} 
        		if (target>A[left]&&target<A[middle]) {
        			 right = middle-1;
        		} else {
        			 left = middle+1;
        		}
        	//the right part is increasing
        	} else if (A[middle]<A[left]){
        		if (A[right]==target) {
        			return true;
        		}
        		if (target>A[middle]&&target<A[right]) {
        			left = middle+1;
        		} else {
        			right = middle-1;
        		}	
        	} else {
        		left = left + 1;
        	}
        }
        return false;
    }
}
