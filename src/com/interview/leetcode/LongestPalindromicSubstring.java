package com.interview.leetcode;

/**

	Given a string S, find the longest palindromic substring in S. 
	
	You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

 * @author shuchun.yang
 *
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "abba";
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome(s));
	}
	
	//time: O(n2), space: O(1)
	//idea if use one or two char as the middle point, then check the left and right char to see if it is the same
	public String longestPalindrome(String s) {
		if (s==null||s.isEmpty()) {
			return null;
		}
		
		if (s.length()==1) {
			return s;
		}
		
		String result = s.substring(0,1);
		for (int i=0; i<s.length(); i++) {
			//for string like aba, center of i
			String subStr = helper(s, i, i);
			if (subStr.length()>result.length()) {
				result = subStr;
			}
			
			//for string like abba, center of i, i+1
			subStr = helper(s, i, i+1);
			if(subStr.length()>result.length()) {
				result = subStr;
			}
		}
		
		return result;
	}
	
	public String helper(String s, int begin, int end) {
		while (begin>=0 && end<s.length() && s.charAt(begin)==s.charAt(end)) {
			begin = begin-1;
			end = end+1;
		}
		//because we compare begin and end, and in the last run, we reduce begin and increase end
		return s.substring(begin+1, end);
	}
	
	//time: O(n2), space: O(n2)
	public String longestPalindromeDP(String s) {
		if (s==null||s.isEmpty()) {
			return null;
		}
		
		if (s.length()==1) {
			return s;
		}
        

        int[][] table = new int[s.length()][s.length()];
        
        //all one char substring are palindrome
        for (int i=0; i<table.length; i++) {
        	table[i][i] = 1;   	
        }
        //calculate from 2 substring, 3 substring to n substring
        for (int length=2; length<table.length; length++) {
        	//BBBA from 0 to 2 when length=2
        	for (int i=0; i<=table.length-length; i++) {
        		int j=i+length-1;
        		if (s.charAt(i)==s.charAt(j)) {
        			if (length==2) {
        				table[i][j] = 2;
        		    //BBB, from 1 to 1 plus matched first B and third B
        			} else {
        				table[i][j] = table[i+1][j-1] + 2;
        			}
        		} else {
        			table[i][j] = Math.max(table[i][j-1], table[i+1][j]);
        		}
        	}
        }
        
        int maxLength = 0;
        String longestPalindrome = "";
        for (int i=0; i<table.length; i++) {
        	for (int j=0; j<table[i].length; j++) {
        		if (table[i][j]>maxLength) {
        			if (j+1==table[i].length) {
                		longestPalindrome = s.substring(j+1-table[i][j]);
                	} else {
                		longestPalindrome = s.substring(j+1-table[i][j], j+1);
                	} 
        			maxLength = table[i][j];
        		}
        	}
        }
        
        return longestPalindrome;
    }
}
