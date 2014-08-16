package com.interview.leetcode;

/**

	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
	
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 * @author shuchun.yang
 *
 */
public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int nRows = 3;
		String result = z.convert(s, nRows);
		System.out.println(result);
		
		nRows = 4;
		result = z.convert(s, nRows);
		System.out.println(result);
		
	}
	
	//each zigzag is actually 2*m-1 chars
	public String convert(String s, int nRows) {
        if (s==null||s.isEmpty()||nRows<1) {
        	return "";
        }
        if (nRows==1) {
        	return s;
        }
        
        StringBuilder results = new StringBuilder();
        int size = 2*nRows-2;
        
        for(int i=0;i<nRows;i++)  {  
            for(int j=i;j<s.length();j+=size) {  
            	results.append(s.charAt(j));  
                //if not first and last row, we need to append the char in between.
            	int nextZig = j+size-2*i; //i is current row
            	if(i!=0 && i!=nRows-1 && nextZig<s.length()) {
                	results.append(s.charAt(nextZig));  
                }                	
            }                  
        }  
        return results.toString();
    }
}
