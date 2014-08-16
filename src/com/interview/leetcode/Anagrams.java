package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**

	Given an array of strings, return all groups of strings that are anagrams.
	
	Note: All inputs will be in lower-case.

 * @author shuchun.yang
 *
 */
public class Anagrams {
	public static void main(String[] args) {
		String[] strs = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
		Anagrams a = new Anagrams();
		System.out.println(Arrays.toString(a.anagrams(strs).toArray()));
	}
	
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> results = new ArrayList<String>();
        if (strs==null||strs.length==0) {
        	return results;
        }
        Map<String, ArrayList<String>> table = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
        	char[] array = str.toCharArray();
        	Arrays.sort(array);
        	String sortedStr = String.valueOf(array);
        	ArrayList<String> anagrams = table.get(sortedStr);
        	if (anagrams==null) {
        		anagrams = new ArrayList<String>();
        		anagrams.add(str);
        		table.put(sortedStr, anagrams);
        	} else {
        		anagrams.add(str);
        	}
        }
        
        for (String key : table.keySet()) {
        	ArrayList<String> anagrams = table.get(key);
        	if (anagrams.size()>1) {
        		results.addAll(anagrams);
        	}       	
        }
        
        return results;
    }
}
