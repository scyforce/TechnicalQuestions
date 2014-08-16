package com.interview.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**

	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	
	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".

 * @author shuchun.yang
 *
 */
public class WordBreak {
	public static void main(String[] args) {
		//String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		//Set<String> dict = new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
		String s = "eaterror";
		Set<String> dict = new HashSet<String>(Arrays.asList("eat","eater","error"));
		
		WordBreak w = new WordBreak();
		System.out.println(w.wordBreak(s, dict));
	}
	
	//not passing leetcode
	public boolean wordBreakRecursive(String s, Set<String> dict) {
		if (s==null) {
			return false;
		}
        if (s.length()==0) {
        	return true;
        }
        
        //divide the word into two parts, first part check if in dictionary, second part check recursively
        for (int i=1; i<=s.length(); i++) {
        	String currentWord = s.substring(0, i);
        	String nextWord = s.substring(i);
        	if (dict.contains(currentWord) && wordBreakRecursive(nextWord, dict)) {
        		return true;      		
        	}
        }
        return false;
    }
	
	public boolean wordBreak(String s, Set<String> dict) {
		if (s==null || dict==null) {
			return false;
		}
		
		if (dict.size()==0) {
			return s.length()==0;
		}
		//record from 0 to i, i<s.length, if s.substring(0, i) can be word break;		
		boolean[] results = new boolean[s.length()+1];
		results[0] = true;
		
		//because we add the first element, so need to be less than s.length+1
		for (int i=1; i<s.length()+1; i++) {
			for (int j=0; j<i; j++) {
				//"eaterror" -> check j=3 eat and (j,i) (3,8) error is in library
				results[i] = results[j] && dict.contains(s.substring(j, i));
				//if there is a match, break for this position
				if (results[i]) {
					break;
				}
			}
		}
		return results[s.length()];
	}
}
