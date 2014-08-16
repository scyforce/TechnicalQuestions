package com.interview.leetcode;

/**

	The count-and-say sequence is the sequence of integers beginning as follows:
	1, 11, 21, 1211, 111221, ...
	
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth sequence.
	
	Note: The sequence of integers will be represented as a string.

 * @author shuchun.yang
 *
 */
public class CountAndSay {
	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay(10));
	}
	
	
	public String countAndSay(int n) {
        if (n<1) {
        	return "";
        }		
        String result = "1";
		if (n==1) {
        	return result;
        }
		for (int i=1; i<n; i++) {
			result = countAndSay(result);			
		}
		
        return result;      
    }
	
	//char->int c-'0' || int->char i+'0'
	public String countAndSay(String previous) {
		StringBuilder current = new StringBuilder();
		int count = 1;
		int previousDigit = previous.charAt(0)-'0';
		char[] cArray = previous.toCharArray();
		for (int i=1; i<cArray.length; i++) {
			int currentDigit = cArray[i]-'0';
			if (currentDigit!=previousDigit) {
				current.append(count);
				current.append(previousDigit);
				previousDigit = currentDigit;
				count = 0;
			}
			count++;			
		}
		
		current.append(count);
		current.append(previousDigit);
		
		return current.toString();
	}
}
