package com.interview.leetcode;

/**

	Implement atoi to convert a string to an integer.
	
	Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
	
	Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
	
	Requirements for atoi:
	The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
	
	Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
	
	The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
	
	If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
	
	If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
	
	"  -0012a42" will return -12
 * @author shuchun.yang
 *
 */
public class StringToIntegerAtoi {
	public static void main(String[] args) {
		String str = " 2147483650";
		StringToIntegerAtoi s = new StringToIntegerAtoi();
		System.out.println(s.atoi(str));
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Overall:
	 * 1. starting whitespace
	 * 2. first + and - sign
	 * 3. negative overflow and positive overflow
	 * @param str
	 * @return
	 */
	public int atoi(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}

		char[] cStr = str.toCharArray();
		int index = 0;
		// skip all whitespace
		while (index < cStr.length) {
			if (!Character.isWhitespace(cStr[index])) {
				break;
			}
			index = index + 1;
		}

		boolean isNegative = false;
		if (index < cStr.length) {
			if (cStr[index] == '-') {
				isNegative = true;
				index = index + 1;
			} else if (cStr[index] == '+') {
				index = index + 1;
			}
		}

		int number = 0;
		boolean isOverflow = false;
		while (index < cStr.length) {
			char current = cStr[index];
			// check digit
			if (!Character.isDigit(current)) {
				break;
			}
			long lNumber = number * 10l;
			if (lNumber>Integer.MAX_VALUE) {
				isOverflow = true;
				break;
			} else {
				number = number * 10;
			}
			lNumber = lNumber + (current - '0');
			if (lNumber>Integer.MAX_VALUE) {
				isOverflow = true;
				break;
			} else {
				number = number + (current - '0');
			}
			index = index + 1;
		}

		// "21474836488"
		if (isOverflow) {
			if (isNegative) {
				number = Integer.MIN_VALUE;
			} else {
				number = Integer.MAX_VALUE;
			}
		//-12345
		} else if (isNegative) {
			number = number * -1;
		}

		return number;
    }
}
