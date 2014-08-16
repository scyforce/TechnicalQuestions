package com.interview.leetcode;

import java.util.Arrays;

/**

	Given a string, find the length of the longest substring without repeating characters. 
	
	For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
	
	which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

 * @author shuchun.yang
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "aa";
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring(s));
	}
	
	public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0) {
        	return 0;
        }
        
        //ASCII char set is size of 256
        int[] ascii = new int[256];
        Arrays.fill(ascii, -1);
        
        int start = 0;
        int end = 0;
        int results = 0;
        
        while (end<s.length()) {
        	char currentChar = s.charAt(end);
        	if (ascii[currentChar] >= start) {
        		start = ascii[currentChar] + 1;
        	}
        	
        	ascii[currentChar] = end;
        	int currentLength = end-start+1;
        	results = Math.max(results, currentLength);
        	end = end + 1;
        }
        return results;
    }
}
