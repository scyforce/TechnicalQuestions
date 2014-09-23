package com.interview.algorithm.sort;

import java.util.Arrays;

public class SortUtils {
    public static void swap(int[] data, int i, int j) {
    	int temp = data[i];
    	data[i] = data[j];
    	data[j] = temp;
    }
    
    
    public static void main(String[] args) {
    	int[] array = {5,2,4,3,1};
    	System.out.println(SortUtils.partition(array, 0, array.length-1, 0));
    	System.out.println(Arrays.toString(array));
    }
    
    
    public static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        //move pivotValue to right;
        swap(array, pivotIndex, right);
        int storedIndex = left;
        
        for (int i=left; i<right; i++) {
            if (array[i]<=pivotValue) {
                swap(array, i, storedIndex);
                storedIndex++;
            }
        }
        swap(array, storedIndex, right);
        return storedIndex;
    }
}
