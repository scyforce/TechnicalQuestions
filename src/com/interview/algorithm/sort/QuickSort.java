package com.interview.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	
	 public void quicksort(int[] data, int left, int right){
        if(left<right){
              int pivotIndex = left;
              int pivotNewIndex = SortUtils.partition(data, left,right, pivotIndex);
              quicksort(data, left, pivotNewIndex - 1);
              quicksort(data, pivotNewIndex + 1, right);
        }
     } 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{7,3,4,2,6,8};
		QuickSort qs = new QuickSort();
		qs.quicksort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));

	}

}
