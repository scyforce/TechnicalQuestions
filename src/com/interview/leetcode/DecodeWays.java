package com.interview.leetcode;

/**

	A message containing letters from A-Z is being encoded to numbers using the following mapping:
	
	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	
	The number of ways decoding "12" is 2.

 * @author shuchun.yang
 *
 */
public class DecodeWays {
	
	public static void main(String[] args) {
		String s = "120";
		DecodeWays d = new DecodeWays();
		d.numDecodings(s);
	}
	
	public int numDecodings(String s) {
        if (s==null || s.isEmpty()) {
        	return 0;
        }
        
        //if the first char is 0, there is no way to decode
        if (s.charAt(0)=='0') {
        	return 0;
        }
        
        int[] results = new int[s.length()+1];
        results[0] = 1;
        results[1] = 1;
        
        for (int i=2; i<=s.length(); i++) {
        	char curr = s.charAt(i-1);
        	if (curr!='0') {
        		results[i] = results[i-1];
        	} 
        	
        	char previous = s.charAt(i-2);
        	if (previous!='0') {
        		int num = Integer.parseInt(s.substring(i-2, i));
        		//for 20, 10 cases, because curr is 0, results = 0 + results[i-2];
        		if (num>0 && num<=26) {
        			results[i] += results[i-2];
        		}
        	}
        	
        	
        }
        return results[s.length()];
    }
}
