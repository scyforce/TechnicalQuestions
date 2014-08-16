package com.interview.leetcode;

import java.util.Arrays;

/**

	Given a non-negative number represented as an array of digits, plus one to the number.
	
	The digits are stored such that the most significant digit is at the head of the list.

 * @author shuchun.yang
 *
 */
public class PlusOne {
	//[1,2,4,9,9,9,9] + 1
	public int[] plusOne(int[] digits) {
        if (digits==null||digits.length==0) {
        	return new int[]{};
        }
        
        //only if all digits are 9, array lenght will be longer than digits length
        boolean longerLength = true;
        for (int i=0; i<digits.length; i++) {
        	if (digits[i]!=9) {
        		longerLength = false;
        	}
        }
        
        int length = longerLength?digits.length+1:digits.length;       
        int[] results = new int[length];
        int index = results.length-1;
        
        int carryOn = 1;
        for (int i=digits.length-1;i>=0;i--) {
        	int sum = digits[i]+carryOn;       	
        	results[index] = sum%10;       	
        	index--;
        	if (sum>=10) {
        		carryOn=1;
        		if (i==0) {
            		results[index] = 1;
            	}
        	} else {
        		carryOn = 0;
        	}
        }
        return results;
    }
	
	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int[] digits = {8,9,9,9,9};
		
		System.out.print(Arrays.toString(p.plusOne(digits)));
	}
}
