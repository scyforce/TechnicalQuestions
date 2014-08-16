package com.interview.leetcode;

/**
	
	Implement wildcard pattern matching with support for '?' and '*'.
	
	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") -> false
	isMatch("aa","aa") -> true
	isMatch("aaa","aa") -> false
	isMatch("aa", "*") -> true
	isMatch("aa", "a*") -> true
	isMatch("ab", "?*") -> true
	isMatch("aab", "c*a*b") -> false

 * @author shuchun.yang
 *
 */
public class WildcardMatching {
	public static void main(String[] args) {
		WildcardMatching wc = new WildcardMatching();
		System.out.println(wc.isMatch("aabcdd", "*c*e"));
	}
	
	public boolean isMatch(String s, String p) {
		if (s==null||p==null) {
			return false;
		}
		
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			//if p is ? or p[0] = s[0] then increase both pointer
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				i++;
				j++;
			//if p is *, mark the position of * and mark the position of current s and increase p pointer
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j;
				mark = i;
				j = j+1;
			//if p and q not match, but previous p was * then keep increasing mark and assign mark to i
		   // for aab and *c    a match*, a match*, b match*, but no char match c
			} else if (star != -1) {
				j = star + 1;
				mark = mark + 1;
				i = mark;
			} else {
				return false;
			}
		}
		
		// s="" p="*" or p="**"
		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}
		
		return j == p.length();
    }
}
