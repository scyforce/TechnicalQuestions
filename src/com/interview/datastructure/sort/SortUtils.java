package com.interview.datastructure.sort;

public class SortUtils {
    public static void swap(int[] data, int i, int j) {
    	int temp = data[i];
    	data[i] = data[j];
    	data[j] = temp;
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
