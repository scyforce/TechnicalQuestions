package com.interview.leetcode;

/**

	Given an unsorted integer array, find the first missing positive integer.
	
	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.
	
	Your algorithm should run in O(n) time and uses constant space.

 * @author shuchun.yang
 *
 */
public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] A = {3,4,-1,1};
		FirstMissingPositive f = new FirstMissingPositive();
		System.out.println(f.firstMissingPositive(A));
	}
	
	public int firstMissingPositive(int A[]) {
		if (A==null||A.length==0) {
			return 1;
		}
		
		int i=0;
		while (i<A.length) {			
			//1. Move A[i] to A[A[i]]  
            //2. if not valid skip  
			if (A[i]>0 && A[i]<A.length && i!=A[i] && A[i]!=A[A[i]]) {
				swap(A, i, A[i]);
			} else {
				i = i+1;
			}
		}
		
		//the first element is not used
		for (int j=1; j<A.length; j++) {
			if (A[j]!=j) {
				return j;
			}
		}
		
		return A[0]==A.length?A.length+1:A.length;
	}
	
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
