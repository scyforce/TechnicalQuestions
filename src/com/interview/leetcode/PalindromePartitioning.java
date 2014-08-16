package com.interview.leetcode;

import java.util.ArrayList;;

/**
	Given a string s, partition s such that every substring of the partition is a palindrome.
	
	Return all possible palindrome partitioning of s.
	
	For example, given s = “aab”,
	Return
	
	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]
 
 * @author shuchun.yang
 *
 */
public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning p = new PalindromePartitioning();
		p.partition("aabb");
	}
		
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		if (s==null||s.length()==0) {
			return results;
		}
		
		partition(results, new ArrayList<String>(), 0, s);
		
		return results;
	}
	
	public void partition(ArrayList<ArrayList<String>> results, ArrayList<String> result, int start, String s) {
		//reach the end of the string
		if (start == s.length()) {
			ArrayList<String> r = new ArrayList<String>(result);
			results.add(r);
			return;
		}
		
		for (int i=start+1; i<=s.length(); i++) {
			//test substring a -> a -> b
			String subString = s.substring(start, i);
			if (isPalindrome(subString)) {
				result.add(subString);
				partition(results, result, i, s);
				result.remove(result.size()-1);
			}			
		}
	}
	
	private boolean isPalindrome(String s) {
		for (int i=0; i<s.length()/2; i++) {
			if (s.charAt(i)!=s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
