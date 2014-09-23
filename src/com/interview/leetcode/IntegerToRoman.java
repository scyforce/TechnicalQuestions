package com.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/**

	Given an integer, convert it to a roman numeral.
	
	Input is guaranteed to be within the range from 1 to 3999.

 * @author shuchun.yang
 *
 */
public class IntegerToRoman {
	
	public static void main(String[] args) {
		IntegerToRoman i = new IntegerToRoman();
		System.out.println(i.intToRoman(55));
	}
	
	/**
	 * 1 - I
	 * 2 - II
	 * 3 - III
	 * 4 - IV
	 * 5 - V
	 * 6 - VI
	 * 7 - VII
	 * 8 - VIII
	 * 9 - IX
	 * 10 - X
	 * 11 - XI
	 * 
	   I 1  
       V 5  
       X 10  
       L 50  
       C 100  
       D 500  
       M 1,000
       
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		if(num<1 || num>3999) {
			return "";
		}
	          
	    int digit = 1000;  
	    List<Integer> digits = new ArrayList<Integer>(4);  
	    while(digit>0) {  
	        digits.add(num/digit);  
	        num %= digit;  
	        digit /= 10;  
	    }  
	    
	    StringBuilder res = new StringBuilder();  
	    res.append(convert(digits.get(0),'M',' ', ' '));  
	    res.append(convert(digits.get(1),'C','D', 'M'));  
	    res.append(convert(digits.get(2),'X','L', 'C'));  
	    res.append(convert(digits.get(3),'I','V', 'X'));  
	    return res.toString();  
	}  
	
	public String convert(int digit, char one, char five, char ten) {  
	    StringBuilder res = new StringBuilder();  
	    switch(digit) {  
	        case 9:  
	            res.append(one);  
	            res.append(ten);  
	            break;  
	        case 8:  
	        case 7:  
	        case 6:  
	        case 5:  
	            res.append(five);  
	            for(int i=5;i<digit;i++) {
	            	res.append(one);
	            }	                  
	            break;  
	        case 4:  
	            res.append(one);  
	            res.append(five);  
	            break;     
	        case 3:  
	        case 2:  
	        case 1:  
	            for(int i=0;i<digit;i++) {
	            	res.append(one); 
	            }	                 
	            break;     
	        default:  
	            break;  
	    }  
	    return res.toString();  
	}  
}
