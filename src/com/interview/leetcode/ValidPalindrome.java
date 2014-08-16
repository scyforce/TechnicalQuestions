package com.interview.leetcode;

/**

	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	
	Note:
	Have you consider that the string might be empty? This is a good question to ask during an interview.
	
	For the purpose of this problem, we define empty string as valid palindrome.

 * @author shuchun.yang
 *
 */
public class ValidPalindrome {
	public static void main(String[] args) {
		String s = "a   b  ";
		
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome(s));
	}
	
	public boolean isPalindrome(String s) {
        if (s==null) {
        	return false;
        }
        if (s.isEmpty()) {
        	return true;
        }
        
        s = s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        
        while (i<j) {
        	char c1 = s.charAt(i);
        	char c2 = s.charAt(j);
        	if (c1==c2) {
        		i = i+1;
        		j = j-1;
        	} else {
        		if (!Character.isLetterOrDigit(c1) || !Character.isLetterOrDigit(c2)) {
        			if (!Character.isLetterOrDigit(c1)) {
        				i = i+1;
        			}
        			if (!Character.isLetterOrDigit(c2)) {
        				j = j-1;
        			}
        		} else {
        			return false;
        		}
        	}    	
        }        
        return true;
    }
}
