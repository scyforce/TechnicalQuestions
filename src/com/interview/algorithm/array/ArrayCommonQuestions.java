package com.interview.algorithm.array;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.interview.algorithm.search.BinarySearch;
import com.interview.algorithm.sort.QuickSort;
import com.interview.algorithm.sort.SortUtils;

public class ArrayCommonQuestions {
	
	/**
	 * Find top N elements in an unsorted array 
	 * e.g. [2,4,8,7,5,1], 3
	 * out - [8,7,5]
	 * @param array
	 * @param num
	 * @return
	 */
	public static int[] findTopNElementsInArray(int[] array, int num) {
        int pivotIndex = findTopNElementsInArray(array, 0, array.length-1, num);       
        int[] results = new int[num];
        int index = 0;
        for (int i=pivotIndex;i<array.length;i++) {
            results[index] = array[i];
            index++;
        }
        return results;
    }
    
    public static int findTopNElementsInArray(int[] array, int left, int right, int num) {
        int pivotIndex = SortUtils.partition(array, left, right, left);
        
        
        if (num==(array.length-pivotIndex)) {
            return pivotIndex;
        } else if ((array.length-pivotIndex)>num) {
            return findTopNElementsInArray(array, pivotIndex+1, right, num);
        } else {
            return findTopNElementsInArray(array, left, pivotIndex-1, num);
        }            
    }
	
    /**
     *  from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
	   	The array is [1 3 -1 -3 5 3 6 7], and w is 3.

		Window position                Max
		---------------               -----
		[1  3 -1] -3  5  3  6  7       3
 		1 [3  -1  -3] 5  3  6  7       3
 		1  3 [-1  -3  5] 3  6  7       5
 		1  3  -1 [-3  5  3] 6  7       5
 		1  3  -1  -3 [5  3  6] 7       6
 		1  3  -1  -3  5 [3  6  7]      7
		Input: A long array A[], and a window width w
		Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
		Requirement: Find a good optimal way to get B[i]
     * @param array
     * @param num
     * @return
     */
    public static int[] slideWindowMaximum(int[] array, int num) {
        int[] results = new int[array.length-num+1];
        int j = 0;
        for (int i=0; i<array.length-num+1; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int x=i; x<i+num; x++) {
                maxValue = Math.max(array[x], maxValue);
            }
            results[j++] = maxValue;
        }
        
        return results;
    }
    
	public static int[] slideWindowMinimum(int[] array, int num) {
        int[] results = new int[array.length-num+1];
        int j = 0;
        for (int i=0; i<array.length-num+1; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int x=i; x<i+num; x++) {
                minValue = Math.min(array[x], minValue);
            }
            results[j++] = minValue;
        }
        
        return results;
    }
	
	public static int findKComplementary(int[] array, int sum) {
		QuickSort quickSort = new QuickSort();
		quickSort.quicksort(array, 0, array.length-1);
		int counter = 0;
		for (int i=0; i<array.length; i++) {
			int val = sum - array[i];
			System.out.println("finding - " + val);
			if (val<array[i]) {
				continue;
			}
			int find = BinarySearch.binarySearch(array, val, 0, array.length-1);
			if (find!=-1) {
				counter++;
			}
		}
		return counter;		
	}
	
	public static void finKComplementary(int[] array, int sum) {
		QuickSort quickSort = new QuickSort();
		quickSort.quicksort(array, 0, array.length-1);
		
		int first = 0;
		int last = array.length-1;
		
		while (first<last) {
			int s = array[first] + array[last];
			if (s==sum) {
				System.out.println(array[first] + " " + array[last]);
				first++;
				last--;
			} else if (s<sum) {
				first++;
			} else {
				last--;
			}
		}
		
	}
	
	
	public static int[] findCommonElementInArray(int[] array1, int[] array2) {
		int[] common = new int[array1.length>array2.length?array2.length:array1.length];
		
		//sort the first array
		QuickSort qs = new QuickSort();
		qs.quicksort(array1, 0, array1.length-1);
		
		int index=0;
		//do binary search to find if element appears in both arrays
		for (int value : array2) {
			if (BinarySearch.binarySearch(array1, value, 0, array1.length-1)>=0){
				common[index++] = value;
				System.out.println(index-1 + " - " + value);
			}
		}
		
		return common;
	}
	
	public static char findFirstNonRepeatedChar(String inputs) {
		char ch = '\u0000';
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		for (char input : inputs.toCharArray()) {
			Boolean count = map.get(input);
			if (count==null) {
				map.put(input, true);
			} else {
				map.put(input, false);
			}
		}
		
		for (char input : inputs.toCharArray()) {
			if (map.get(input).booleanValue()) {
				ch = input;
				break;
			}
		}	
		return ch;
	}
	
	public static int str2int(String input) {
		char[] inputArr = input.toCharArray();
		boolean isNeg = false;
		int startIndex = 0;
		int num = 0;
		if (inputArr[0]=='-') {
			isNeg=true;
			startIndex = 1;
		}
		
		for (int i = startIndex; i<inputArr.length; i++) {
			num *= 10;
			num +=inputArr[i]-'0';
		}
		
		if (isNeg) {
			num*=-1;
		}		
		return num;
	}
	
	public static String int2str(int number) {
		if (number==0) {
			return "0";
		}
		
		boolean isNeg = false;
		if (number<0) {
			number*=-1;
			isNeg = true;
		}
		
		StringBuilder str = new StringBuilder();
		while (number!=0) {		
			str.append(String.valueOf(number%10));
			number /= 10;
		}
		
		if (isNeg) {
			str.append("-");
		}
		
		str.reverse();
		
		return str.toString();
	}
	
	
	public static int x2(int value) {
		return 1<<value;
	}
    
    public static String reverse_rec(String str) {
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        return reverse_rec(str.substring(1)) + str.charAt(0);
    }


    public static String reverse(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        StringBuffer reverse = new StringBuffer(str.length());
        for (int i = str.length() - 1; i >= 0; i--) {
          reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }
    
    public static boolean isPalindrome(String str) {
    	boolean isPalindrome = true;
    	for (int i=0; i<str.length()/2; i++) {
    		if (str.charAt(i) != str.charAt(str.length()-i-1)) {
    			isPalindrome = false;
    			break;
    		}
    	}
    	return isPalindrome;
    }
    
	/**
	 * find pivot index (array[pivot] > array[pivot+1]) in a rotated array in O(logN) time;
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
    public static int findPivot(int[] array) {
    	return findPivot(array, 0, array.length-1);
    }
    
	private static int findPivot(int[] array, int start, int end) {
        if (start > end) {
        	return -1;
        }
		
		int mid = start + (end - start)/2;
       
        if (array[mid] > array[mid+1]) {
            return mid;
        }
        if (array[start] > array[mid]) {
            return findPivot(array,start,mid-1);
        } else {
            return findPivot(array,mid+1,end);
        }
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
    	int[] a = {1,2,3,4,5,6};
    	
    	
//    	int [] a = {1, 3 , -1,  -3, 5 , 3,  6,  7};
//    	ArrayCommonQuestions.slideWindowMaximum(a,  3);
//    	
//    	int[] array = {4, 11,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1};
//    	System.out.println(Arrays.toString(ArrayCommonQuestions.findTopNElementsInArray(array, 3)));
//    	ArrayCommonQuestions.canJump(array, 0);
//    	
//    	int[] array1 = {1,2,3};
//    	int[] array2 = {6,7,8,9,10};
//    	
//    	ArrayCommonQuestions.printSubsets(array1);
//    	
//    	int[] array3 = {1,2,3,3,4,5,6,7,7};
//    	
//    	ArrayCommonQuestions.finKComplementary(array3, 9);
    	
    	//System.out.println(ArrayCommonQuestions.getMedianOfTwoSortedArray(array1, array2));
    	
    	//ArrayCommonQuestions.finKComplementary(array, 6);
    	
//    	String str = "\u0048\u0065\u006C\u006C\u006F World";
//    	
//    	for (byte bt : str.getBytes("UTF-8")) {
//    		System.out.println(bt & 0xE0);
//    	}
    }
}
