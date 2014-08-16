package com.interview.leetcode;

/**

	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
	
	If the last word does not exist, return 0.
	
	Note: A word is defined as a character sequence consists of non-space characters only.
	
	For example, 
	Given s = "Hello World",
	return 5.

 * @author shuchun.yang
 *
 */
public class LengthOfLastWord {
	public static void main(String[] args) {
		LengthOfLastWord l = new LengthOfLastWord();
		
		System.out.println(l.lengthOfLastWord("a bcd dddd"));
	}
	
	public int lengthOfLastWord(String s) {
		int length = 0;
		if (s==null||s.length()==0) {
			return length;
		}
		boolean spaceFound = false;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (c!=' ') {
				if (spaceFound) {
					length=0;
					spaceFound = false;
				}
				length++;
			} else {
				spaceFound = true;
			}
		}
        return length;
    }
}
