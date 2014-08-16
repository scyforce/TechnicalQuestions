package com.interview.leetcode;

/**

	Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
	
	You may assume no duplicates in the array.
	
	Here are few examples.
	[1,3,5,6], 5 -> 2
	[1,3,5,6], 2 -> 1
	[1,3,5,6], 7 -> 4
	[1,3,5,6], 0 -> 0

 * @author shuchun.yang
 *
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        if (A==null) {
            return 0;
        }
        int targetIndex = 0;
        int index = 0;
        while (index<A.length) {
            if (A[index]==target) {
                targetIndex = index;
                break;
            } else if (A[index]>target) {
            	targetIndex = index;
            	break;
            } else {
            	if (index+1==A.length) {
            		targetIndex = A.length;
            	}
            }          
            index++;
        }
        return targetIndex;
    }
	
	public static void main(String[] args) {
		SearchInsertPosition s = new SearchInsertPosition();
		System.out.println(s.searchInsert(new int[]{1}, 0));
		
		System.out.println(s.searchInsert(new int[]{1}, 3));
		
		System.out.println(s.searchInsert(new int[]{1,2}, 3));
		
		System.out.println(s.searchInsert(new int[]{1,2}, 0));
		
		System.out.println(s.searchInsert(new int[]{1,2}, 2));
		
		System.out.println(s.searchInsert(new int[]{1,3}, 2));
	}
}
