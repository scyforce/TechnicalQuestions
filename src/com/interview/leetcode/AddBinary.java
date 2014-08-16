package com.interview.leetcode;

/**

	Given two binary strings, return their sum (also a binary string).
	
	For example,
	a = "11"
	b = "1"
	Return "100". 

 * @author shuchun.yang
 *
 */
public class AddBinary {
	public static void main(String[] args) {
		AddBinary a = new AddBinary();
		System.out.println(a.addBinary("111", "111"));
	}
	
	
	public String addBinary(String a, String b) {
		if (a==null||b==null||a.length()==0||b.length()==0) {
			return "";
		}
		
        StringBuilder results = new StringBuilder();
		
        String longer = "";
        String shorter = "";
        if (a.length()<b.length()) {
        	longer = b;
        	shorter = a;
        } else {
        	longer = a;
        	shorter = b;
        }

		int addition = 0;
		//add from the last position
        for (int i=longer.length()-1; i>=0; i--) {
        	int iShorter = 0;
        	if (i-longer.length()+shorter.length()>=0) {
        		iShorter = shorter.charAt(i-longer.length()+shorter.length())-'0';
        	}
        	int iLonger = longer.charAt(i)-'0';
        	
        	
        	int result = (iShorter+iLonger+addition)%2;
        	addition = (iShorter+iLonger+addition)/2;
        	
        	results.append(result);       	
        }
		if (addition>0) {
			results.append(addition);
		}	
		return results.reverse().toString();
    }
}
