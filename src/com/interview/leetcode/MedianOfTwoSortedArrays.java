package com.interview.leetcode;

/**

	There are two sorted arrays A and B of size m and n respectively. 
	
	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

	http://blog.csdn.net/fightforyourdream/article/details/17351395
	
 * @author shuchun.yang
 *
 */
public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		int[] A = {1,2};
		int[] B = {};
		
		System.out.println(m.findMedianSortedArrays(A, B));
		
		int[] A1 = {};
		int[] B1 = {3};
		
		System.out.println(m.findMedianSortedArrays(A1, B1));
	}
	
	//O(m+n)
	public double findMedianSortedArraysNaive(int A[], int B[]) {
        if (A==null||B==null) {
        	return 0d;
        }
        
        int[] merged = new int[A.length+B.length];
        
        int i=0;
        int j=0;
        int k=0;
        
        while (i<A.length && j<B.length) {
        	if (A[i]>B[j]) {
        		merged[k] = B[j];
        		j++;
        	} else {
        		merged[k] = A[i];
        		i++;
        	}
        	k++;
        }
		
        if (i<A.length) {
        	merged[k]=A[i];
        	k++;
        	i++;
        }
        
        if (j<B.length) {
        	merged[k]=B[j];
        	k++;
        	j++;
        }
        
        int middle = merged.length/2;
        if (merged.length%2==0) {
        	return (merged[middle-1] + merged[middle])/2d;
        } else {
        	return merged[middle]/1d;
        } 
    }
	
	//O(log(m+n))
	public double findMedianSortedArrays(int A[], int B[]) {
		if (A==null||B==null) {
        	return 0d;
        }
		
		int length = A.length + B.length;		
		int middle = length/2;
		//this algorithm has to pass the natural kth not index
		if (length%2==0) {
			return (findKthElement(A, B, middle+1, 0, A.length-1) + findKthElement(A, B, middle, 0, A.length-1))/2d;
		} else {
			return (findKthElement(A, B, middle+1, 0, A.length-1))/1d;
		}
	}
	
	public int findKthElement(int A[], int B[], int k, int low, int high) {
		int n = B.length;
		
		//kth element is not in A, so do a binary search in B
		if (low>high) {
			return findKthElement(B, A, k, 0, n-1);
		}
		
		int i = low + (high - low) / 2;  
		//0 to i-1 has i elements, 0 to k-1-i-1 has k-1-i elements
		//now we need to compare A[i] with B[k-1-i-1] B[k-1-i];
		//k = (i-1+k-1-i-1)+ 1(A[i]);
        int j = k -1 - i - 1; 
        
        // find the kth smallest element
        // the additional j<n and j+1>=0 is for edge case where A[] or B[] is empty
        // A[i] >= B[k - 1 - i - 1]  and A[i] <= B[k - 1 - i]. If so, just returnA[i] as the result
        if ((j < 0 || (j < n && A[i] >= B[j])) && (j+1 >= n || (j+1 >= 0 && A[i] <= B[j+1]))) {  
            return A[i];  
        // kth element in lower part of A, because any element after A[i] will be larger than B[j+1]
        } else if (j < 0 || (j+1 < n && A[i] > B[j+1])) {
            return findKthElement(A, B, k, low, i-1);  
        // kth element in upper part of A, because any element before A[i] will be smaller than B[j]
        // A[i] < B[j] means A[i] is less than (n-i) + (m-(k-1-i)+1) = m+n-k+2 = k+2
        } else {
            return findKthElement(A, B, k, i+1, high);  
        }     
	}
}
