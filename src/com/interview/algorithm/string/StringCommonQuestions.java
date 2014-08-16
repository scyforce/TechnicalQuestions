package com.interview.algorithm.string;

public class StringCommonQuestions {	
		
	/*wip*/
	public static boolean findSubStringRollingHash(String str, String subStr) {
		int strLength = str.length();
		int subStrLength = subStr.length();
		
		if (subStrLength>strLength) {
			return false;
		}
		boolean hasFound = true;
		
		return hasFound;
	}
	
	public static boolean findSubString(String str, String subStr) {
		int strLength = str.length();
		int subStrLength = subStr.length();
		
		if (subStrLength>strLength) {
			return false;
		}
		boolean hasFound = true;
		
		for (int i=0; i<strLength-subStrLength+1;i++) {
			for (int j=0; j<subStrLength; j++) {
				if (str.charAt(i+j)!=subStr.charAt(j)) {
					hasFound = false;
					break;
				} else {
					hasFound = true;
				}
			}
			if (hasFound) {
				break;
			}
		}
		return hasFound;
	}
	
	/*public static boolean findSubString(String str, String subStr) {

		//sub string index
		int j = 0;
		
		char[] strArray = str.toCharArray();
		char[] subStrArray = subStr.toCharArray();
		
		boolean match = false;
		for (int i=0; i<strArray.length; i++) {
			System.out.println("i " + strArray[i] + " j " + subStrArray[j]);
			if (strArray[i]!=subStrArray[j]) {
				match = false;
				j=0;
			} else {
				match = true;
				if (j==subStrArray.length-1) {
					break;
				} else {
					j++;
				}
			}
			System.out.println(match);
		}
		return match;
	}*/
	
	public static void main(String[] args) {
		String s = "12";
		System.out.println(s.substring(0,1));
	}
}
