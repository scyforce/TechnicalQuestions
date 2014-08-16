package com.interview.leetcode;

import java.util.Arrays;

/**

	Implement strStr().
	
	Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.

 * @author shuchun.yang
 *
 */
public class ImplementStrStr {
	public static void main(String[] args) {
		String haystack = "BBC ABCDAB ABCDABCDABDE";
		String needle = "ABCDABD";
		
		haystack = "mississippi";
		needle = "a";
		ImplementStrStr imp = new ImplementStrStr();
		System.out.println(imp.strStr(haystack, needle));
		
		System.out.println(Arrays.toString(imp.computePartialMatchTable(needle)));
	}
	
	public String strStrNaive(String haystack, String needle) {
        if (haystack==null||needle==null||haystack.length()<needle.length()) {
        	return null;
        }
        
        //bruteforce algorithm calculate to the last start of needle string, O(m*n)
        int diffLength = haystack.length() - needle.length() + 1;
        
        for (int i=0; i<diffLength; i++) {
        	if (haystack.substring(i).startsWith(needle)) {
        		return haystack.substring(i);
        	}
        }
        
        return null;
    }
	
	public int[] computePartialMatchTable1(String needle) {
		int[] results = new int[needle.length()];
		
		int position = 1;
		results[0] = 0;
		
		while (position<needle.length()) {
			int previousValue = results[position-1];
			if (needle.charAt(previousValue)==needle.charAt(position)) {
				results[position] = previousValue + 1;
			} else {
				results[position] = 0;
			}
			position = position + 1;
		}
		
		return results;
	}
	
	public String strStr1(String haystack, String needle) {
		if (haystack==null||needle==null||needle.length()>haystack.length()) {
			return null;
		}
		
		if (needle.isEmpty()) {
			return haystack;
		}
		
		int hPointer = 0;
		int nPointer = 0;
		int subIndex = 0;
		
		int[] partialMatchTable = computePartialMatchTable1(needle);
		
		while (hPointer<haystack.length()) {
			if (haystack.charAt(hPointer) == needle.charAt(nPointer)) {
				if (nPointer==needle.length()-1) {
					return haystack.substring(subIndex);
				}
				hPointer = hPointer+1;
				nPointer = nPointer+1;
			} else {
				if (nPointer==0) {
					hPointer = hPointer+1;					
				} else {
					int partialIndex = partialMatchTable[nPointer-1];
					hPointer = (partialIndex>0) ? hPointer-partialIndex : subIndex+1;					
				}
				nPointer = 0;
				subIndex = hPointer;
			}
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//KMP O(2n) = O(n)
	public String strStr(String haystack, String needle) {
		if (haystack==null||needle==null||haystack.length()<needle.length()) {
        	return null;
        }
		
		if (needle.length()==0) {
			return haystack;
		}
		
		//haystack pointer
		int hPointer = 0;
		//needle pointer
		int nPointer = 0;
		int[] partialMatchTable = computePartialMatchTable(needle);
		//this is used to track the needle start point
		int subIndex = 0;
		while(hPointer<haystack.length()) {
			if (needle.charAt(nPointer)==haystack.charAt(hPointer)) {
				if (nPointer==needle.length()-1) {
					return haystack.substring(subIndex);
				}
				nPointer=nPointer+1;
				hPointer=hPointer+1;				
			} else {
				//first element does not match
				if (nPointer==0) {
					hPointer = hPointer+1;
			    //partial match happens
				} else {
					//find the last match point
					int partialMatch = partialMatchTable[nPointer-1];
					//only back to the partialMatch starting point
					hPointer = partialMatch>0?(hPointer-partialMatch):subIndex+1;
				}
				nPointer = 0;
				subIndex = hPointer;
			}
		}		
		return null;
	}
	
	//the idea of this table is to get the number of common substrings from prefix and suffix table
	//http://blog.sina.com.cn/s/blog_64f7baa40101dsz5.html
	//ABCDABA - [0,0,0,0,1,2,0]
	public int[] computePartialMatchTable(String needle) {
		int[] results = new int[needle.length()];
		int position = 1;		
		results[0] = 0;
		
		while (position<needle.length()) {
			if (needle.charAt(results[position-1])==needle.charAt(position)) {
				results[position] = results[position-1] + 1;
			} else {
				results[position] = 0;
			}
			position = position + 1;
		}			
		return results;
	}
}
