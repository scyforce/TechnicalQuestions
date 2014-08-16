package com.interview.leetcode;

import java.util.Arrays;

/**

	Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
	
	Below is one possible representation of s1 = "great":
	
	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
	To scramble the string, we may choose any non-leaf node and swap its two children.
	
	For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
	
	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t
	We say that "rgeat" is a scrambled string of "great".
	
	Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
	
	    rgtae
	   /    \
	  rg    tae
	 / \    /  \
	r   g  ta  e
	       / \
	      t   a
	We say that "rgtae" is a scrambled string of "great".
	
	Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

 * @author shuchun.yang
 *
 */
public class ScrambleString {
	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgtae";
		
		ScrambleString s = new ScrambleString();
		System.out.println(s.isScramble(s1, s2));
	}
	
	public boolean isScramble(String s1, String s2) {
        if (s1==null || s2==null || s1.length()!=s2.length()) {
        	return false;
        }
		
        //this is to judge when recursion only pass one letter
        if(s1.length()==1 && s2.length()==1){  
            return s1.charAt(0) == s2.charAt(0);  
        }
        
        char[] cArray1 = s1.toCharArray();
        char[] cArray2 = s2.toCharArray();
        Arrays.sort(cArray1);
        Arrays.sort(cArray2);
        
        if (!String.valueOf(cArray1).equals(String.valueOf(cArray2))) {
        	return false;
        }
        
        for (int i=1; i<s1.length(); i++) {
        	String s11 = s1.substring(0, i);
        	String s12 = s1.substring(i);
        	String s21 = s2.substring(0, i);
        	String s22 = s2.substring(i);
        	
        	//test front part
        	if (isScramble(s11,s21) && isScramble(s12, s22)) {
        		return true;
        	}
        	
        	//test the back part
        	s21 = s2.substring(s2.length()-i);
        	s22 = s2.substring(0, s2.length()-i);
        	if (isScramble(s11, s21) && isScramble(s12, s22)) {
        		return true;
        	}
        }     
        return false;
    }
}
