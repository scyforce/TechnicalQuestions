package com.interview.leetcode;

/**

	Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
	
	You have the following 3 operations permitted on a word:
	
	a) Insert a character
	b) Delete a character
	c) Replace a character

 * @author shuchun.yang
 *
 */
public class EditDistance {
	
	public static void main(String[] args) {
		EditDistance e = new EditDistance();
		System.out.println(e.minDistance("", ""));
	}
	
	/**
	 Key Analysis

	Let dp[i][j] stands for the edit distance between two strings with length i and j, i.e., word1[0,...,i-1] and word2[0,...,j-1].
	There is a relation between dp[i][j] and dp[i-1][j-1]. Let’s say we transform from one string to another. The first string has length i and it’s last character is “x”; the second string has length j and its last character is “y”. The following diagram shows the relation.
	
	if x == y, then dp[i][j] == dp[i-1][j-1]
	if x != y, and we insert y for word1, then dp[i][j] = dp[i][j-1] + 1
	if x != y, and we delete x for word1, then dp[i][j] = dp[i-1][j] + 1
	if x != y, and we replace x with y for word1, then dp[i][j] = dp[i-1][j-1] + 1
	When x!=y, dp[i][j] is the min of the three situations.
	Initial condition:
	dp[i][0] = i, dp[0][j] = j

	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		if (word1==null||word2==null) {
			return 0;
		}
		
        int length1 = word1.length();
        int length2 = word2.length();
        
        //this will handle "" "abc", "" "" case
        int[][] results = new int[length1+1][length2+1];
        
        for (int i=0; i<length1+1; i++) {
        	results[i][0] = i;
        }
        
        for (int j=0; j<length2+1; j++) {
        	results[0][j] = j;
        }
        
        for (int i=0; i<length1; i++) {
        	char c1 = word1.charAt(i);
        	for (int j=0; j<length2; j++) {
        		char c2 = word2.charAt(j);
        		if (c1==c2) {
        			//ab -> ab
            		results[i+1][j+1] = results[i][j];
            	} else {
            		//ab -> abd
            		int insert = results[i+1][j] + 1;
            		//abd -> ab
            		int delete = results[i][j+1] + 1;
            		//abc -> abd
            		int replace = results[i][j] + 1;
            		
            		results[i+1][j+1] = Math.min(insert, Math.min(delete, replace));
            	}
        	}      	
        }
        return results[length1][length2];
    }
}
