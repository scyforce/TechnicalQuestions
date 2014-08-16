package com.interview.leetcode;

/**

	Given two numbers represented as strings, return multiplication of the numbers as a string.
	
	Note: The numbers can be arbitrarily large and are non-negative.

 * @author shuchun.yang
 *
 */
public class MultiplyStrings {
	public static void main(String[] args) {
		String num1 = "1234";
		String num2 = "34";
		
		MultiplyStrings m = new MultiplyStrings();
		System.out.println(Integer.parseInt(num1)*Integer.parseInt(num2));
		System.out.println(m.multiply(num1, num2));
	}
	
	public String multiply(String num1, String num2) {
		if (num1==null||num2==null||num1.isEmpty()||num2.isEmpty()) {
			return null;
		}
		
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();
		
		int[] results = new int[n1.length()+n2.length()];
		
		for (int i=0; i<n1.length(); i++) {
			for (int j=0; j<n2.length(); j++) {
				results[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
			}
		}
		
		/**
		 * 	1234 * 34
		 * 
		 * 	  4321
		 *   	43
		 *  ------------
		 *  16
		 *   24
		 *    17
		 *     10
		 *      3
		 *  ------------
		 *  65914 -> 41956    
		 */ 
		
		StringBuilder product = new StringBuilder();
		for (int i=0; i<results.length; i++) {
			int digit = results[i]%10;
			int carryOn = results[i]/10;
			
			if (i+1<results.length) {
				results[i+1] += carryOn;
			}
			product.insert(0, digit);
		}
		
		//if we allocate a larger results array, then clear all leading 0
		while (product.charAt(0)=='0' && product.length()>1) {
			product.deleteCharAt(0);
		}
		
		return product.toString();
    }
}
