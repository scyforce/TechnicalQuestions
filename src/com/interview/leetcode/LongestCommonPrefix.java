package com.interview.leetcode;

/**

	Write a function to find the longest common prefix string amongst an array of strings.

 * @author shuchun.yang
 *
 */
public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String[] strs = {"abab","aba","a"};
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(strs));
		
	}
	
	public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) {
        	return "";
        }
        
        int finalIndex = -1;
        String str = strs[0];
        for (int i=0; i<str.length(); i++) {
        	boolean isSame = true;
        	for (int j=1; j<strs.length; j++) {
        		//"aa" "a" || "ab" "ac"
        		if (i==strs[j].length() || str.charAt(i)!=strs[j].charAt(i)) {
        			isSame = false;
        		}
        	}
        	if (isSame) {
        		finalIndex = i;
        	} else {
        		return str.substring(0, finalIndex+1);
        	}
        }
        
        if (finalIndex<0) {
        	return "";
        }
        return str.substring(0, finalIndex+1);
        
    }
}
