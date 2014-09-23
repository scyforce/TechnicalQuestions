package com.interview.leetcode;

/**

	Given a roman numeral, convert it to an integer.
	
	Input is guaranteed to be within the range from 1 to 3999.

 * @author shuchun.yang
 *
 */
public class RomanToInteger {
	
	public static void main(String[] args) {
		RomanToInteger r = new RomanToInteger();
		System.out.println(r.romanToInt("XI"));
		System.out.println(r.romanToInt("IX"));
	}
	
	public int charToInt(char c) {
		if (c=='I') {
			return 1;
		} else if (c=='V') {
			return 5;
		} else if (c=='X') {
			return 10;
		} else if (c=='L') {
			return 50;
		} else if (c=='C') {
			return 100;
		} else if (c=='D') {
			return 500;
		} else if (c=='M') {
			return 1000;
		}
		return 0;
	}
	
	public int romanToInt(String s) {
		if (s==null||s.isEmpty()) {
			return 0;
		}
		int result = charToInt(s.charAt(0));
		int current = 0;
		int previous = 0;
		for (int i=1; i<s.length(); i++) {
			current = charToInt(s.charAt(i));
			previous = charToInt(s.charAt(i-1));
			if (current<=previous) {
				result += current;
			} else {
				//first remove already added previous value then do the subtraction
				result = (result-previous) + (current-previous);
			}
		}
		return result;
	}
}
