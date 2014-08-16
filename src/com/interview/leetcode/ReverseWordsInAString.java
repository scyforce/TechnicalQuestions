package com.interview.leetcode;

/**

	Given an input string, reverse the string word by word.
	
	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
	
	click to show clarification.
	
	Clarification:
	What constitutes a word?
	A sequence of non-space characters constitutes a word.
	
	Could the input string contain leading or trailing spaces?
	Yes. However, your reversed string should not contain leading or trailing spaces.
	
	How about multiple spaces between two words?
	Reduce them to a single space in the reversed string.

 * @author shuchun.yang
 *
 */
public class ReverseWordsInAString {
	public static void main(String[] args) {
		ReverseWordsInAString r = new ReverseWordsInAString();
		String s = " the    sky is blue  test ";
		
		System.out.println(r.reverseWords(s));
	}
	
	public String reverseWords(String s) {
		if (s==null||s.isEmpty()) {
			return s;
		}
		
		s = s.trim();
		
		StringBuilder result = new StringBuilder();
		StringBuilder word = new StringBuilder();
		for (int i=s.length()-1; i>=0; i--) {
			char current = s.charAt(i);
			if (' '==current) {
				//avoid multiple spaces
				if (word.length()>0) {
					result.append(word.toString());
					result.append(" ");
					word.delete(0, word.length());
				}			
			} else {
				word.insert(0, current);
				if (i==0) {
					result.append(word.toString());
				}
			}
		}
		
		return result.toString();
    }
}
