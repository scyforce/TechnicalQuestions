package com.interview.leetcode;

/**

	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	
	You may assume no duplicate exists in the array.

 * @author shuchun.yang
 *
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
        if (A==null || A.length==0) {
        	return -1;
        }
        
        int left = 0;
        int right = A.length-1;
        
        while (left<=right) {
        	int middle = left+(right-left)/2;
        	if (A[middle]==target) {
        		return middle;
        	}
        	//the left part is increasing
        	if (A[middle]>=A[left]) {
        		if (A[left]==target) {
        			return left;
        		} 
        		if (target>A[left]&&target<A[middle]) {
        			 right = middle-1;
        		} else {
        			 left = middle+1;
        		}
        	//the right part is increasing
        	} else {
        		if (A[right]==target) {
        			return right;
        		}
        		if (target>A[middle]&&target<A[right]) {
        			left = middle+1;
        		} else {
        			right = middle-1;
        		}	
        	}      	
        }
        return -1;
    }
}
