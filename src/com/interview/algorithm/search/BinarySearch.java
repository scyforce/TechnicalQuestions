package com.interview.algorithm.search;

import java.util.Collections;
import java.util.List;

public class BinarySearch {
    
	public static int binarySearch(int[] arrays, int num, int start, int end) {			
		if (start > end) {
			return -1;
		} else if (start==end && arrays[start]!=num) {
			return -2;
		}
		
		//check for unordered arrays
		if( arrays[start] > arrays[end] ) {
			return -3;
		}
	
		int middle = (end+start)/2;
		if (arrays[middle] > num) {
			//System.out.println(start + " " + end);
			return binarySearch(arrays, num, start, middle-1);
		} else if (arrays[middle] < num){
			//System.out.println(start + " " + end);
			return binarySearch(arrays, num, middle+1, end);
		} else {
			//System.out.println(start + " " + end);
			return middle;
		}
	}
	
	public static int binarySearch(int[] array, int num) {
		if (array==null || array.length<1) {
			return -1;
		}
		
		int start = 0;
		int end = array.length-1;
		
		while (start<end) {
			int middle = start + (end-start)/2;
			if (array[middle] == num) {
				return middle;
			} else if (array[middle]>num){
				end = middle-1;
			} else {
				start = middle+1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		System.out.println(BinarySearch.binarySearch(array, 2));
		System.out.println(BinarySearch.binarySearch(array, 0));
		System.out.println(BinarySearch.binarySearch(array, 5));
		
		int[] array1 = {1,2,3,4,4,6};
		System.out.println(BinarySearch.binarySearch(array, 2));
		System.out.println(BinarySearch.binarySearch(array, 0));
		System.out.println(BinarySearch.binarySearch(array, 4));
		System.out.println(BinarySearch.binarySearch(array, 7));
		
		List<String> empty = Collections.emptyList();
		empty.add("123");
		System.out.println(empty);
		
	}
}
