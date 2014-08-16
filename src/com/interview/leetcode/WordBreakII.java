package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**

	Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
	
	Return all such possible sentences.
	
	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "sand", "dog"].
	
	A solution is ["cats and dog", "cat sand dog"].

 * @author shuchun.yang
 *
 */
public class WordBreakII {
	public static void main(String[] args) {
		WordBreakII w = new WordBreakII();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		System.out.println(Arrays.toString(w.wordBreakNaive(s, dict).toArray()));
	}
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> results = new ArrayList<String>();
        
        if (s==null || dict==null || dict.isEmpty() || s.isEmpty()) {
			return results;
		}
        
        //record from 0 to i, i<s.length, if s.substring(0, i) can be word break;		
  		boolean[] canBreak = new boolean[s.length()+1];
  		canBreak[0] = true;
  		
  		//because we add the first element, so need to be less than s.length+1
  		for (int i=1; i<s.length()+1; i++) {
  			for (int j=0; j<i; j++) {
  				//"eaterror" -> check j=3 eat and (j,i) (3,8) error is in library
  				canBreak[i] = canBreak[j] && dict.contains(s.substring(j, i));
  				//if there is a match, break for this position
  				if (canBreak[i]) {
  					break;
  				}
  			}
  		}
  		
  		if (canBreak[s.length()]) {
  			wordBreak(results, new StringBuilder(), 0, s, dict, canBreak);
  		}       
        return results;
    }
	
	public void wordBreak(ArrayList<String> results, StringBuilder curr, int start, String s, Set<String> dict, boolean[] canBreak) {
		if (s.isEmpty()) {
			curr.deleteCharAt(curr.length()-1);
			results.add(curr.toString());
			return;
		}
		
		for (int i=1; i<=s.length(); i++) {
			if (canBreak[i+start]) {
				String word = s.substring(0, i);
				if (dict.contains(word)) {
					int oldLength = curr.length();
					curr.append(word + " ");
					wordBreak(results, curr, start+i, s.substring(i), dict, canBreak);
					curr.delete(oldLength, curr.length());
				}
			}		
		}
	}
	
	public ArrayList<String> wordBreakNaive(String s, Set<String> dict) {
		ArrayList<String> results = new ArrayList<String>();
        
        if (s==null || dict==null || dict.isEmpty() || s.isEmpty()) {
			return results;
		}
        
        wordBreakNaive(results, new StringBuilder(), 0, s, dict);        
        return results;
	}
	
	private void wordBreakNaive(ArrayList<String> results, StringBuilder curr, int start, String s, Set<String> dict) {
		if (s.isEmpty()) {
			curr.deleteCharAt(curr.length()-1);
			results.add(curr.toString());
			return;
		}
		
		for (int i=1; i<=s.length(); i++) {
			String word = s.substring(0, i);
			if (dict.contains(word)) {
				int oldLength = curr.length();
				curr.append(word + " ");
				wordBreakNaive(results, curr, start+i, s.substring(i), dict);
				//remove the appended word
				curr.delete(oldLength, curr.length());
			}		
		}
	}
}
