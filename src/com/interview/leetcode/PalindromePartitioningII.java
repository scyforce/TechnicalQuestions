package com.interview.leetcode;

import java.util.ArrayList;

/**

	Given a string s, partition s such that every substring of the partition is a palindrome.
	
	Return the minimum cuts needed for a palindrome partitioning of s.
	
	For example, given s = "aab",
	Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 * @author shuchun.yang
 *
 */
public class PalindromePartitioningII {
	public static void main(String[] args) {
		PalindromePartitioningII p = new PalindromePartitioningII();
		String s = "abbab";
		System.out.println(p.minCut(s));
	}
	
	public int minCut(String s) {
		//a   b   a   b   b   b   a   b   b   a   b   a
		//        i               j  j+1              n
		//D[i] = min(1+D[j])    i<=j<n
		//P[i][j] = (str[i]==str[j] && P[i+1][j-1])
		int[] results = new int[s.length()+1];
		boolean[][] palindrome = new boolean[s.length()+1][s.length()+1];
		
		//initially assign the max cut time for each i from 0-s.length
		//"aab", -1, a 0, aa 1, aab 2
		for (int i=0; i<=s.length(); i++) {
			results[i] = i-1;
		}
		
		for (int j=2; j<=s.length(); j++) {
			for (int i=1; i<=j; i++) {
				//j-i==1, two char are the same, j-i==0, same char
				if (s.charAt(i-1)==s.charAt(j-1) && ((j-i)<2||palindrome[i+1][j-1])) {
					palindrome[i][j]=true;
					results[j] = Math.min(results[j], results[i-1]+1);
				}
			}
		}
		
		return results[s.length()];
		
	}
	
	public int minCutNaive(String s) {
        if (s==null||s.isEmpty()) {
        	return 0;
        }
        
        int[] results = new int[1];
        results[0] = Integer.MAX_VALUE;
        minCutNaive(results, new ArrayList<String>(), 0, s);
        
        return results[0];
    }
	
	
	public void minCutNaive(int[] results, ArrayList<String> result, int start, String s) {
		if (start == s.length()) {
			int partition = result.size()-1;
			if (partition<results[0]) {
				//three elements in the list, only need to two partition
				results[0] = partition;
			}
			return;
		}
		
		for (int i=start+1; i<=s.length(); i++) {
			String sub = s.substring(start, i);
			if (isPalindrome(sub)) {
				result.add(sub);
				minCutNaive(results, result, i, s);
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
