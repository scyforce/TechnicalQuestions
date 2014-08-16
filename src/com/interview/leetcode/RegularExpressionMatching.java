package com.interview.leetcode;

/**

	Implement regular expression matching with support for '.' and '*'.
	
	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") -> false
	isMatch("aa","aa") -> true
	isMatch("aaa","aa") -> false
	isMatch("aa", "a*") -> true
	isMatch("aa", ".*") -> true
	isMatch("ab", ".*") -> true
	isMatch("aab", "c*a*b") -> true

 * @author shuchun.yang
 *
 */
public class RegularExpressionMatching {
	public static void main(String[] args) {		
		RegularExpressionMatching r = new RegularExpressionMatching();
		System.out.println(r.isMatch("aa", "a"));
		System.out.println(r.isMatch("aa", "aa"));
		System.out.println(r.isMatch("aaa", "aa"));
		System.out.println(r.isMatch("aa", "a*"));
		System.out.println(r.isMatch("aa", ".*"));
		System.out.println(r.isMatch("ab", ".*"));
		System.out.println(r.isMatch("ab", "c*a*b"));
		System.out.println(r.isMatch("", "a*"));
	}
	
	public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
        	return s.isEmpty();
        }
        
        /**
         * there are two cases:
         * 1. the second char is *, then if the first char is . or the first char matches the first char of s then continue matching
         * 2. the second char is not *, then if the first char is . or the second char matches the second char of s then continue matching
         */
        if (p.length()==1 || p.charAt(1)!='*') {
        	if (s.length()<1 || !(p.charAt(0)=='.' || p.charAt(0) == s.charAt(0))) {
        		return false;
        	}
        	return isMatch(s.substring(1), p.substring(1));
        } else {
        	int i=-1;
        	while (i<s.length() && (i<0 || p.charAt(0)=='.' || p.charAt(0)==s.charAt(i))) {
        		//this is to continue matching, from the next char of *
        		if (isMatch(s.substring(i+1), p.substring(2))) {
        			return true;
        		}
        		i++;
        	}
        	return false;
        }
    }
}
