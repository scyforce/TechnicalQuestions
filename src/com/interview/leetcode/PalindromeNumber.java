package com.interview.leetcode;

/**

	Determine whether an integer is a palindrome. Do this without extra space.
	
	Some hints:
	Could negative integers be palindromes? (ie, -1)
	
	If you are thinking of converting the integer to string, note the restriction of using extra space.
	
	You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
	
	There is a more generic way of solving this problem.

 * @author shuchun.yang
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		//negative number is not a palindrome
        if (x<0) {
        	return false;
        }
		
		int number = x;
        int reverse = 0;
        
        while (number!=0) {
        	int remainder = number%10;
        	reverse = reverse * 10 + remainder;
        	number = number / 10;
        }
        
        return x==reverse; 
    }
}
