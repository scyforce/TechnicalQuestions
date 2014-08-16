package com.interview.leetcode;

/**

	Given a string S and a string T, count the number of distinct subsequences of T in S.
	
	A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters 
	
	without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	
	Here is an example:
	S = "rabbbit", T = "rabbit"
	
	Return 3.

 * @author shuchun.yang
 *
 */
public class DistinctSubsequences {
	public static void main(String[] args) {
		DistinctSubsequences d = new DistinctSubsequences();
		System.out.println(d.numDistinct("ra", "rd"));
	}
	
	/*
	 * Let W(i, j) stand for the number of subsequences of S(0, i) in T(0, j). 
	 * If S.charAt(i) == T.charAt(j), W(i, j) = W(i-1, j-1) + W(i-1,j),
	 * char at i & j not equal case + previous match count - because for a substring to match, if S=abc T=abc, then it only count if "ab"=="ab" and "abc"="abc" 
	 * Otherwise, W(i, j) = W(i-1,j).
	 */
	public int numDistinct(String S, String T) {
        if (S==null||T==null) {
        	return 0;
        }
        
        int[][] results = new int[S.length()+1][T.length()+1];
        
        //empty string is substring of any string
        for (int i=0; i<results.length; i++) {
        	results[i][0] = 1;
        }
        
        for (int i=1; i<results.length; i++) {
        	for (int j=1; j<results[i].length; j++) {
        		if (S.charAt(i-1) == T.charAt(j-1)) {
        			results[i][j] = results[i-1][j-1] + results[i-1][j];
        		} else {
        			results[i][j] = results[i-1][j];
        		}
        	}
        }
        
        return results[S.length()][T.length()];
    }
}
