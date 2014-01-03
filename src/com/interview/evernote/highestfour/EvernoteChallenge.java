package com.interview.evernote.highestfour;

/**
 * Write a function that finds the highest 4 numbers in an unordered list of integers in O(n) time. 
 * Use any language you desire. Your solution should be representative of the quality of code you'd write in a production system.
 * @author shuchun.yang
 *
 */
public class EvernoteChallenge {
	
	/**
	 * Find the highest 4 numbers in the array
	 * @param array
	 * @return highest 4 numbers in an array
	 */
	public int[] findHighestFourElementsInArray(int[] array) {
		final int NUMBER = 4;
		//error - array is null or the length of the array is less than 4
		if (array == null || array.length < NUMBER) {
			return null;
		}
		int[] results = new int[NUMBER];
		
		//Since we are finding the smallest value in a fixed length array, after looping through all elements in the array,
		//the time complexity should be O(n*4) which conceptually is O(n);
		for (int i=0; i<array.length; i++) {
			if (i<results.length) {
				results[i] = array[i];
			} else {
				int minIndex = findSmallestValueIndex(results);
				if (array[i] > results[minIndex]) {
	                results[minIndex] = array[i];
				}
			}
		}
		return results;
	}
	
	/**
	 * find the smallest value index in the given array
	 * @param array
	 */
	private int findSmallestValueIndex(int[] array) {
		//init the min value
	    int minValue = Integer.MAX_VALUE;
		int index = 0;
	    for (int i=0; i<array.length; i++) {
		    if (minValue>array[i]) {
		        index = i;
		        minValue = array[i];
		    }
		}	    
	    return index;
		
	}

}
