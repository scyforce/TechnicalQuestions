package com.interview.datastructure.array;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.interview.datastructure.search.BinarySearch;
import com.interview.datastructure.sort.QuickSort;
import com.interview.datastructure.sort.SortUtils;

public class ArrayCommonQuestions {
	
	public static int findNthNumberInTwoSortedArray(int[] array1, int[] array2, int n) {
		if (n>array1.length+array2.length) {
			return -1;
		}
		
		int i = n/2;
		int j = n-i;
		
		while (i+j>n) {
			
		}
		return 0;
		
		
	}
	
	/**
	 * Find all subsets of a given set
	 * If we're given a set of integers such that S = {1, 2, 3}, how can we find all the subsets of that set?
	 * For example, given S, the subsets are {}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, and {1, 2, 3}.
	 * @param array
	 */
	public static void printSubsets(int[] array) {
		int numOfSubsets = 1 << array.length; 

		for(int i = 0; i < numOfSubsets; i++) {
			int pos = array.length - 1;
		    int bitmask = i;

		    System.out.print("{");
		    while(bitmask > 0) {
		    	if((bitmask & 1) == 1) {
		    		System.out.print(array[pos]+" ");
		    	}		     
		    	bitmask >>= 1;
		    	pos--;
		   }
		   System.out.print("}");
		}
	}
	
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
	
	/**
	 * Question: There are 2 sorted arrays A and B of size n each. 
	 * Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). 
	 * The complexity should be O(log(n))
	 * 
	 * NOT WORKING
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static int getMedianOfTwoSortedArray(int[] array1, int[] array2) {
		return getMedianOfTwoSortedArray(array1, array2, 0, array1.length-1, 0, array2.length-1);
	}
	
	
	public static int getMedianOfTwoSortedArray(int[] array1, int[] array2, int start1, int end1, int start2, int end2) {
		if ((end1-start1-1)==2&&(end2-start2-1)==2) {
			if ((array1.length+array2.length)%2==0) {
				return Math.min(array1[1], array2[1]);
			} else {
				return (Math.max(array1[0], array2[1]) + Math.min(array1[1], array1[1]))/2;
			}
		}
		
		int m1 = median(array1, start1, end1); /* get the median of the first array */
	    int m2 = median(array2, start2, end2); /* get the median of the second array */
	 
	    /* If medians are equal then return either m1 or m2 */
	    if (m1 == m2)
	        return m1;
	 
	     /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
	    int size1 = end1-start1-1;
	    int size2 = end2-start2-1;
	    int num1 = end1+start1;
	    int num2 = end2+start2;
	    
	    if (m1 < m2) {
	    	return getMedianOfTwoSortedArray(array1, array2, (size1%2==0)?num1/2-1:num1/2, end1, start2, num2/2);
	    //
	    } else { 
	    	return getMedianOfTwoSortedArray(array1, array2, start1, num1/2, (size2%2==0)?num2/2-1:num2/2, end2);
	    }
	}
	
	private static int median(int[] array, int start, int end) {
		int num = end-start-1;
		int median = (end+start)/2;
		if (num % 2 == 0) {
			return (array[median]+array[median-1])/2;
		} else {
			return array[median];
		}		
	}
	
	/**
	 *  Jump Game: Given an array, start from the index element and reach the last by jumping. 
	 	The jump length can be at most the value at the current position in the array. 
	 	The optimum result is when you reach the goal in minimum number of jumps.
		What is an algorithm for finding the optimum result?

		An example: given array A = {2,3,1,1,4} the possible ways to reach the end (index list) are

		0,2,3,4 (jump 2 to index 2, then jump 1 to index 3 then 1 to index 4)
		0,1,4 (jump 1 to index 1, then jump 3 to index 4)
		Since second solution has only 2 jumps it is the optimum result.
		
Answer: 
Overview

Given your array a and the index of your current position i, repeat the following until you reach the last element.

Consider all candidate "jump-to elements" in a[i+1] to a[a[i] + i]. For each such element at index e, calculate v = a[e] + e. If one of the elements is the last element, jump to the last element. Otherwise, jump to the element with the maximal v.

More simply put, of the elements within reach, look for the one that will get you furthest on the next jump. We know this selection, x, is the right one because compared to every other element y you can jump to, the elements reachable from y are a subset of the elements reachable from x (except for elements from a backward jump, which are obviously bad choices).

This algorithm runs in O(n) because each element need be considered only once (elements that would be considered a second time can be skipped).

Example

Consider the array of values a, indicies, i, and sums of index and value v.

i ->  0   1   2   3   4   5   6   7   8   9  10  11  12
a -> [4, 11,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1]
v ->  4  12   3   4   5   6   7   8   9  10  11  12  13
Start at index 0 and consider the next 4 elements. Find the one with maximal v. That element is at index 1, so jump to 1. Now consider the next 11 elements. The goal is within reach, so jump to the goal.
	 * @param array
	 * @param index
	 * @return
	 */
	public static int canJump(int[] array, int index) {
		if (index>=array.length) {
			return -1;
		}		
		int steps = 0;
		while (index<array.length) {
			int maxValue = Integer.MIN_VALUE;
			int interval = 0;
			steps++;
			//System.out.println(index + " " + array[index]);
			for (int i=1; i<=array[index]; i++) {	
				//System.out.println(maxValue + " " + interval);				
				if ((i+index)==(array.length-1)) {
					index = array.length;
					break;
				}
				int value = array[index+i] + i;
				if (maxValue!=Math.max(value, maxValue)) {
					interval = i;
					maxValue = Math.max(value, maxValue);
				}
			}
			System.out.println(maxValue + " " + interval);
			index += interval;
		}
		return steps;
	}
	
	
	public static int findElementInRotatedArray(int[] array, int num) {
		int left = 0;
		int right = array.length-1;
		
		while (left <= right) {
			int middle = (right+left) / 2;
			if (array[middle]==num) {
				return middle;
			}
			
			if (array[left]<=array[middle]) {
				if (array[left]==num) {
					return left;
				}
				if (array[left]<num && num<array[middle]) {
					right = middle-1;
				} else {
					left = middle+1;
				}
			} else {
				if (array[right]==num) {
					return right;
				}
				if (num>array[middle] && array[right]>num) {
					left = middle+1;
				} else {
					right = middle-1;
				}
			}
		}
		return -1;
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
	
    public static int[] shuffle(int[] array) {
    	Random rand = new Random();
    	for (int i=0; i<array.length; i++) {
    		int j = rand.nextInt(array.length);
    		int temp = array[i];
    		array[i] = array[j];
    		array[j] = temp;
    	}
    	
    	System.out.println(Arrays.toString(array));
        return array;
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
    	int [] a = {1, 3 , -1,  -3, 5 , 3,  6,  7};
    	ArrayCommonQuestions.slideWindowMaximum(a,  3);
    	
    	int[] array = {4, 11,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1};
    	System.out.println(Arrays.toString(ArrayCommonQuestions.findTopNElementsInArray(array, 3)));
    	ArrayCommonQuestions.canJump(array, 0);
    	
    	int[] array1 = {1,2,3};
    	int[] array2 = {6,7,8,9,10};
    	
    	ArrayCommonQuestions.printSubsets(array1);
    	
    	int[] array3 = {1,2,3,3,4,5,6,7,7};
    	
    	ArrayCommonQuestions.finKComplementary(array3, 9);
    	
    	//System.out.println(ArrayCommonQuestions.getMedianOfTwoSortedArray(array1, array2));
    	
    	//ArrayCommonQuestions.finKComplementary(array, 6);
    	
    	String str = "\u0048\u0065\u006C\u006C\u006F World";
    	
    	for (byte bt : str.getBytes("UTF-8")) {
    		System.out.println(bt & 0xE0);
    	}
    }
}
