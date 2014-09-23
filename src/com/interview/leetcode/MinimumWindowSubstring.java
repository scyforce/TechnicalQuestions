package com.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**

	Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	
	For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC".
	
	Note:
	If there is no such window in S that covers all characters in T, return the emtpy string "".
	
	If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 * @author shuchun.yang
 *
 */
public class MinimumWindowSubstring {
	public static void main(String[] args) {
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		String S = "ADOBECODEBANC";
		String T = "ABC";
		
		System.out.println(m.minWindow(S, T));
	}
	
	/*
	 * For
	   String S = "ADOBECODEBANC";
	   String T = "ABC";
	   
	   We first find ADOBEC which contains all ABC,
	   Then when we see the second B, do not stop because we haven't seen A yet.
	   Then we see the second A, we can move start pointer to C, so "CODEBA" but length is longer than ADOBEC,
	   Then when we see the second, we can move start pointer to B, since "BANC" also contains all ABC and is shorter than ADOBEC
	 */
	public String minWindow(String S, String T) {
		if (S==null||T==null){
            return null;
        }
        
        if((S.length()==0 && T.length()==0) || S.length()<T.length()) {
            return "";
        }
        
        Map<Character, Integer>needFind=new HashMap<Character, Integer>();
        Map<Character, Integer>alreadyFind=new HashMap<Character, Integer>();
        
        //build two maps: one is alreadyFind count, the other is needFind count
        for(int i=0; i<T.length(); i++){
            alreadyFind.put(T.charAt(i), 0);
            
            if (needFind.containsKey(T.charAt(i))){
                needFind.put(T.charAt(i), needFind.get(T.charAt(i))+1);
            }
            else{
                needFind.put(T.charAt(i), 1);
                
            }
        }
        
        int minStart=-1;
        int minEnd=S.length();
        int start=0;
        int len=0;
        
        for (int i=0; i<S.length(); i++){
        	char curr = S.charAt(i);
            if (alreadyFind.containsKey(curr)){
                alreadyFind.put(curr, alreadyFind.get(curr)+1);
                
                if (alreadyFind.get(curr)<=needFind.get(curr)){
                    len++;
                }
                
                if (len==T.length()){
                	//first condition is to filter non-valid char, second condition is to check if the char we found is more than needed
                    while (!needFind.containsKey(S.charAt(start)) || alreadyFind.get(S.charAt(start))>needFind.get(S.charAt(start))){
                        
                        if (needFind.containsKey(S.charAt(start))){
                            alreadyFind.put(S.charAt(start), alreadyFind.get(S.charAt(start))-1);
                        }
                        
                        start++;
                    }
                    
                    if (i-start<minEnd-minStart){
                        minStart=start;
                        minEnd=i;
                    }
                    
                }
            }
            
            
        }
        if (minStart==-1){
            return "";
        }
        
        return S.substring(minStart, minEnd+1);          
    }
}
