package com.interview.leetcode;

/**

	Given two sorted integer arrays A and B, merge B into A as one sorted array.
	
	Note:
	You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
	
	The number of elements initialized in A and B are m and n respectively.

 * @author shuchun.yang
 *
 */
public class MergeSortedArray {
	
	public void merge1(int A[], int m, int B[], int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		
		while (i>0&&j>0) {
			if (A[i]>B[j]) {
				A[k--] = A[i--];
			} else {
				A[k--] = B[j--];
			}
		}
		
		while (j>0) {
			A[k--] = B[j--];
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public void merge(int A[], int m, int B[], int n) {
    	//merged array index
    	int k = m+n-1;
    	//A index
    	int i = m-1;
    	//B index
    	int j = n-1;
    	
        //the idea behind is merge from the end elements of two arrays;
    	while (i>0 && j>0) {
        	if (A[i]>=B[j]) {
        		A[k--] = A[i--];
        	} else {
        		A[k--] = B[j--];
        	}
        }
        //if B has leftover elements, merge to A
        while (j>0) {
        	A[k--] = B[j--];
        }
    	
    }
    
    public void merge2(int A[], int m, int B[], int n) {
    	int i = m - 1; //A
    	int j = n - 1; //B
    	int k = m + n - 1;
     
    	while (k >= 0) {
    		//j<0 is for if B has leftover elements
    		if (j < 0 || (i >= 0 && A[i] > B[j])) {
    			A[k--] = A[i--];
    		} else {
    			A[k--] = B[j--];
    		}
    			
    	}
    }
    
    
}
