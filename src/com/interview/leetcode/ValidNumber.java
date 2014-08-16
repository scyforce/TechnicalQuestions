package com.interview.leetcode;

/**

	Validate if a given string is numeric.
	
	Some examples:
	"0" => true
	" 0.1 " => true
	"abc" => false
	"1 a" => false
	"2e10" => true
	Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

	http://leetcodenotes.wordpress.com/2013/11/23/leetcode-valid-number/
	
 * @author shuchun.yang
 *
 */
public class ValidNumber {
	public static void main(String[] args) {
		ValidNumber v = new ValidNumber();
		String s = "0";		
		System.out.println(v.isNumber(s));
		
		s = " -1. ";		
		System.out.println(v.isNumber(s));
		
		s = "abc";		
		System.out.println(v.isNumber(s));
		
		s = "1 a";		
		System.out.println(v.isNumber(s));
		
		s = "-1.e3";		
		System.out.println(v.isNumber(s));
	}
	
	//the idea is to split the string by e, then check the part before e and the part after e
	public boolean isNumber(String s) {
		if (s==null) {
			return false;
		}
		
	    s = s.trim(); 
	    //avoid "3e" which is false
	    if (s.length() > 0 && s.charAt(s.length() - 1) == 'e') {
	    	return false; 
	    }
	    
	    String[] parts = s.split("e");
	    if (parts.length == 0 || parts.length > 2) {
	    	return false;
	    }
	    //check the part before e
	    boolean res = isValid(parts[0], false); 
	    
	    //check the part after e, and second half can not have any dot
	    if (parts.length > 1) {
	    	res = res && isValid(parts[1], true);
	    }
	        
	    return res;
	}
	
	private boolean isValid(String s, boolean hasDot) {
		//avoid "+1", "+", "+."
	    if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
	    	s = s.substring(1);
	    }
	    
	    if (s.isEmpty() || s.equals(".")) {
	    	return false;
	    }
	        
	    for (int i = 0; i<s.length(); i++) {
	    	char c = s.charAt(i);
	        if (c == '.') {
	        	//can not have a second dot
	            if (hasDot) {
	            	return false;
	            }	                
	            hasDot = true;
	        } else if (!('0' <= c && c <= '9')) {
	            return false;
	        }
	    }
	    return true;
	}
	
	//".1", "3.", "-1.", "+3.", "2e1", "2e+1", "2e-1", "-1.e1", "1.e3"
	public boolean isNumber1(String s) {
		if (s==null) {
			return false;
		}
		
		s = s.trim();       // Get rid of leading and trailing whitespaces
        if (s.isEmpty()) {
        	return false;
        }
            
        boolean isFractional = false;   // Indicate appearance of '.'
        boolean isExponential = false;  // Indicate appearance of 'e/E'
        boolean valid = false;          // Indicate whether preceding digits are valid
        boolean expoBefore = false;     // Indicate whether the preceding digit is 'e/E'
        boolean validFrac = true;       // Indicate whether the number is a vaild fraction (true by default)
        boolean validExpo = true;       // Indicate whether the number is a valid exponential (true by default)
        
        int i = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')   // Consider sign
            i = 1;
        
        // Process each digit in sequence
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            //2e-1, 2e+1
            if (c == '+' || c == '-') {     // +/- is valid only after e/E
                if (!expoBefore) {
                	return false;
                }                   
                expoBefore = false;
                valid = false;
            } else if (c == 'e' || c == 'E') {  // Only one e/E is valid; preceding digits should be valid
                if (isExponential || !valid) {
                	return false;
                }                    
                isExponential = true;
                valid = false;
                expoBefore = true;
                validExpo = false;
            } else if (c == '.') {  // Only one '.' is valid; cannot appear as an exponential
                if (isFractional || isExponential) {
                	return false;
                }                    
                isFractional = true;
                // Must have fractional part
                if (!valid) {
                	validFrac = false;
                }                  
            } else if (c >= '0' && c <='9') {   // Regular digits
                valid = true;
                expoBefore = false;
                validFrac = true;
                validExpo = true;
            } else {
                return false;
            }
        }
        
        // After reaching the end, make sure the number is indeed valid
        if (!valid || !validFrac || !validExpo) {
        	 return false;
        } else {
        	 return true; 
        }
           
    }
}
