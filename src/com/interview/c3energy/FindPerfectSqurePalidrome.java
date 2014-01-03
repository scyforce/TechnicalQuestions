package com.interview.c3energy;

public class FindPerfectSqurePalidrome {
	public void findPerfectSqurePalidrome(int digits) {
		//within long range
		assert (digits>0&&digits<18);
		
		long upperbound = 1l;
		long lowerbound = 1l;
		//the boundary should be 1E+14<=number<1E+15
		for (long i=0; i<digits; i++) {
			if (i<digits-1) {
				lowerbound *= 10;
			}
			upperbound *= 10;
		}
		
		upperbound -= 1;
		
		//get the rough square root of the boundary number
		lowerbound = (long)Math.ceil(Math.sqrt(lowerbound));
		upperbound = (long)Math.ceil(Math.sqrt(upperbound));
		
		//run from high boundary's square root to low boundary's square root
		for (long i=upperbound; i>lowerbound-1; i--) {
			if (isPalindrome(String.valueOf(i*i))){
				System.out.println(i*i);
				return;
			}
		}	
		System.out.println("Find nothing!");
	}
	
	//method to check if the input string is a palindrome
	public boolean isPalindrome(String str) {
    	boolean isPalindrome = true;
    	for (int i=0; i<str.length()/2; i++) {
    		if (str.charAt(i) != str.charAt(str.length()-i-1)) {
    			isPalindrome = false;
    			break;
    		}
    	}
    	return isPalindrome;
    }
	
	public static void main(String[] args) {
		FindPerfectSqurePalidrome finder = new FindPerfectSqurePalidrome();
		finder.findPerfectSqurePalidrome(15);		
	}
}
