package com.interview.leetcode;

/**

	Given an array and a value, remove all instances of that value in place and return the new length.
	
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 * @author shuchun.yang
 *
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        if (A==null) {
        	return 0;
        }
		
		int count = 0;
        for (int i=0; i<A.length; i++) {
        	if (A[i] != elem) {
        		A[count] = A[i];
        		count = count+1;
        	}
        }
        return count;
    }
	
	public static void main(String[] args) {
		RemoveElement ele = new RemoveElement();
		System.out.println(ele.removeElement(new int[]{4,5}, 4));
	}
}
