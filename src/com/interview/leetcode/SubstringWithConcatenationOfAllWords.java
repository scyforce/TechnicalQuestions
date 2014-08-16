package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**

	You are given a string, S, and a list of words, L, that are all of the same length. 
	
	Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
	
	For example, given:
	S: "barfoothefoobarman"
	L: ["foo", "bar"]
	
	You should return the indices: [0,9].
	(order does not matter).

 * @author shuchun.yang
 *
 */
public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		String S = "aaa";
		String[] L = {"a","a"};
		
		System.out.println(Arrays.toString(s.findSubstring(S, L).toArray()));
		
		S = "barfoothefoobarman";
		String[] L1 = {"foo", "bar"};
		
		System.out.println(Arrays.toString(s.findSubstring(S, L1).toArray()));
	}
	
	//each word in L has equal length
	public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (S==null||L==null||L.length==0) {
        	return results;
        }
        
        int length = L.length;
        int wordLength = L[0].length();
        
        if (S.length()<length*wordLength) {
        	return results;
        }
        
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String word : L) {
        	if (!wordCount.containsKey(word)) {
        		wordCount.put(word, 1);
        	} else {
        		wordCount.put(word, wordCount.get(word)+1);
        	}
        }
        
        int index = 0;
        // need <= because "aaa" "a" and "a" 1 <= (3-2) we need to calculate on index=1 too
        while (index<=(S.length()-wordLength*length)) {
        	String subStr = S.substring(index, index+wordLength*length);
        	@SuppressWarnings("unchecked")
			HashMap<String, Integer> map = (HashMap<String, Integer>)wordCount.clone();    	
        	while (!subStr.isEmpty()) { 
        		String word = subStr.substring(0, wordLength);
        		if (map.containsKey(word)) {
        			int num = map.get(word)-1;
        			if (num<0) {
        				break;
        			}
        			map.put(word, num);
        			subStr = subStr.substring(wordLength);
        			if (subStr.isEmpty()) {
        				results.add(index);
        			}
        		//no consecutive match, break the inner loop;
        		} else {
        			break;
        		}
        		
        	}
        	index = index + 1;
        }
        
        return results;
    }
}
