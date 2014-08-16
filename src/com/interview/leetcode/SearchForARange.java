package com.interview.leetcode;

/**
	
	Given a sorted array of integers, find the starting and ending position of a given target value.
	
	Your algorithm's runtime complexity must be in the order of O(log n).
	
	If the target is not found in the array, return [-1, -1].
	
	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].

 * @author shuchun.yang
 *
 */
public class SearchForARange {
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 3, 5, 5};
		
		SearchForARange s = new SearchForARange();
		s.searchRangeNew(A, 5);
	}
	
	public int[] searchRange(int[] A, int target) {
        int pos = searchTarget(A, target, 0, A.length -1);
        if (pos == -1) return new int[]{-1,-1};
        
        int start = 0;
        int end = A.length - 1;
        for (int i = pos - 1; i >= 0; i--) {
            if (A[i] != target) {
        		start = i+1;
        		break;
        	}       		
        }
        for (int i = pos + 1; i < A.length; i++) {
        	if (A[i] != target) {
        		end = i - 1;
        		break;
        	}
        }
        return new int[]{start,end};
    }
    
    public int searchTarget(int[] A, int target, int left, int right) {
    	if (left > right) return -1;
    	int mid = (left + right) / 2;
    	if (A[mid] == target) return mid;
    	if (A[mid] > target) return searchTarget(A, target, left, mid -1);
    	else return searchTarget(A, target, mid+1, right);   	
    }
	
    public int[] searchRangeNew(int[] A, int target) {
        int low = findLow(A, target, 0, A.length - 1);
        int high = findHigh(A, target, 0, A.length - 1);
        int[] ret = new int[2];
        ret[0] = low;
        ret[1] = high;
        return ret;
    }
    
    private int findLow(int[] A, int target, int left, int right) {
        int middle = 0;
        int ret = -1;
        while (left <= right) {
            middle = left + (right-left)/2;
            if (A[middle] == target) {
                ret = middle;
                //find the lower bound starting point
                int next = findLow(A, target, left, middle - 1);
                //if found, not found break;
                if (next != -1) {
                    ret = next;
                }
                break;
            } else if (A[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }           
        }
        return ret;
    }

    private int findHigh(int[] A, int target, int left, int right) {
        int middle = 0;
        int ret = -1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (A[middle] == target) {
                ret = middle;
                //find the upper bound end point
                int next = findHigh(A, target, middle + 1, right);
                //if found, not found break;
                if (next != -1) {
                    ret = next;
                }
                break;
            } else if (A[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return ret;
    }
}
