package com.interview.leetcode;

import java.util.HashSet;
import java.util.Set;

/**

	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	
	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
	
	Your algorithm should run in O(n) complexity.

 * @author shuchun.yang
 *
 */
public class LongestConsecutiveSequence {
	//O(3n)
	public int longestConsecutive(int[] num) {
        Set<Integer> results = new HashSet<Integer>();
        
        //n
        for (int i : num) {
        	results.add(i);
        }
        
        int max = 1;
        //n+ 1*n = 2n
        for (int i: num) {
        	int left = i-1;
        	int right = i+1;
        	int count = 1;
        	//we need to remove the left and right boundary so it is only found once.
        	while (results.contains(left)) {
        		results.remove(left);
        		left = left-1;
        		count = count+1;
        	}
        	
        	while (results.contains(right)) {
        		results.remove(right);
        		right = right + 1;
        		count = count+1;
        	}
        	
        	max = Math.max(count, max);
        	
        }
        
        return max;
    }
}
