package com.interview.algorithm.dp;

public class DynamicProgramming {
	
	public static int findLongestIncreasingSubsequence(int[] array) {
	   int[] results = new int[array.length];
	   int max = 0;
	 
	   /* Initialize results for all indexes */
	   for (int i = 0; i < results.length; i++ ) {
		   results[i] = 1;
	   }
	    
	   /* Compute optimized results values in bottom up manner */
	   for (int i = 1; i < results.length; i++) {
		   for (int j = i-1; j >= 0; j--) {
			   if (array[i] > array[j]) {
			        results[i] = Math.max(results[i], results[j] + 1);
			   }
		   }
	   }
	    
	   /* Pick maximum of all results */
	   for (int i = 0; i < results.length; i++ ) {
		   if (max<results[i]) {
			   max = results[i];
		   }
	   }
	   
	   return max;
	}
	
	public static void main(String[] args) {
		int[] array = {3,5,7,9,1,8};
		DynamicProgramming.findLongestIncreasingSubsequence(array);
	}
}
