package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**

	Given an array of integers, find two numbers such that they add up to a specific target number.
	
	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
	
	Please note that your returned answers (both index1 and index2) are not zero-based.
	
	You may assume that each input would have exactly one solution.
	
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2

 * @author shuchun.yang
 *
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] numbers = {-1,1,0,2,-2,3,5,-3};
		TwoSum t = new TwoSum();
		ArrayList<ArrayList<Integer>> results = t.twoSums(numbers);
		for (ArrayList<Integer> result : results) {
			System.out.println(Arrays.toString(result.toArray()));
		}
		
		//System.out.println(Arrays.toString(t.twoSums(numbers, 4)));
	}
	
	public ArrayList<ArrayList<Integer>> twoSums(int[] numbers) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (numbers==null||numbers.length<2) {
			return results;
		}
		
		int target = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int number : numbers) {
			if (map.containsKey(number)) {
				ArrayList<Integer> result = new ArrayList<Integer>();
				result.add(map.get(number));
				result.add(number);
				results.add(result);
			} else {
				map.put(target-number, number);
			}
		}
		
		return results;
		
	}
	
	public int[] twoSum(int[] numbers, int target) {
        int[] results = {0,0};
        if (numbers==null||numbers.length==0) {
        	return results;
        }
        
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
        
        //the idea is to put the other number in the map, if the other number is found, return the pair
        for (int i=0; i<numbers.length; i++) {
        	if (numberMap.containsKey(numbers[i])) {
        		results[0] = numberMap.get(numbers[i]) + 1;
        		results[1] = i+1;
        		break;
        	} else {
        		//store the other number and current index
        		numberMap.put(target-numbers[i], i);
        	}
        }
        return results;
    }
	
	public int[] twoSums(int[] numbers, int target) {
        int[] results = {0,0};
        if (numbers==null||numbers.length==0) {
        	return results;
        }
        
        Arrays.sort(numbers);
        
        //the idea is to put the other number in the map, if the other number is found, return the pair
        int i=0;
        int j=numbers.length-1;
        while (i<j) {
        	int sum = numbers[i]+numbers[j];
        	if (sum==target) {
        		results[0] = numbers[i];
        		results[1] = numbers[j];
        		break;
        	} else if (sum<target) {
        		i++;
        	} else {
        		j--;
        	}
        }       
        return results;
    }
}
