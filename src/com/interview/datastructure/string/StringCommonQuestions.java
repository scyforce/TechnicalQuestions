package com.interview.datastructure.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCommonQuestions {	
	
	public static int findLongestPalindromString1(String str) {
		if (str == null || str.length()==0) {
			return 0;
		}
		char[] array = str.toCharArray();
		
		int longest = 0;
		int start = 0;
		int end = 0;
		for (int i=0; i<array.length; i++) {
			if (array.length%2==0) {
				start = i;
			} else {
				start = i-1;
			}
			end = i+1;
			boolean isPalindrom = false;
			int length = 0;
			while (start>=0 && end<=array.length-1) {
				if (array[start] == array[end]) {
					isPalindrom = true;
					length = end-start+1;
				} else {
					break;
				}				
				end++;
				start--;
			}
			if (isPalindrom) {
				longest = Math.max(longest, length);
			}
		}
		
		return longest;
	}
	
	/*public static int findLongestPalindromString(String str) {
	        int n = str.length();
	        int[][] table = new int[n][n];
	         
	        for(int i=0; i<n; i++){
	            table[i][i] = 1; //when len=1
	        }
	         
	        //len is length of substring
	        for(int len=2; len<=n; len++){
	            //the start position of substring
	            for(int i=0; i<=n-len; i++){
	                int j = i+len-1;//the end position of substring
	                if(str.charAt(i)== str.charAt(j)){
	                    if(len == 2){
	                        table[i][j] = 2;
	                    }else{
	                        table[i][j] = table[i+1][j-1] + 2; //the element on down-left
	                    }
	                }else{
	                    table[i][j] = Math.max(table[i][j-1], table[i+1][j]);
	                }   
	            }
	        }
	         
	        return table[0][n-1];
	    }*/
	
	public static String findLongestNonRepeatedSubString(String str) {
		int start =0 , end =0 , length = 0;
		int finalStart=0, finalEnd=0;
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		
		char[] array = str.toCharArray();
		
		for (int i=0; i<array.length; i++) {
			Boolean used = map.get(array[i]);
			System.out.println(used);
			if (used!=null && used.booleanValue()) {
				System.out.println("repeat "+ start + " " + end);
				int newLength = end-start-1;
				if (newLength>length) {
					finalStart = start;
					finalEnd = end-1;
					length = newLength;
				}
				System.out.println("prefinal " + finalStart + " " + finalEnd);
				
				start = i;
				end = i;
				map.clear();
				map.put(array[i], true);
				continue;
			}			
			map.put(array[i], true);
			
			System.out.println(array[start] + " " +array[end]);
			end++;
		}
		System.out.println("last " + start + " " + end);
		int newLength = end-start;
		if (newLength>length) {
			finalStart = start;
			finalEnd = end;
			length = newLength;
		}
		
		System.out.println("last1 " + finalStart + " " + finalEnd);
		return str.substring(finalStart, finalEnd+1);
	}
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
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 1) {
	    	System.out.println(prefix+str);
	    } else {
	        for (int i = 0; i < n; i++) {	        	
	        	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));	
	        }
	    }
	}	
	
	/*
	 * C++ way
	 */
	public static void permute(String str) {
		int length = str.length();
		boolean[] used = new boolean[length];
		StringBuffer out = new StringBuffer();
		char[] in = str.toCharArray();
		doPermute(in, out, used, length, 0);
	}

	public static void doPermute(char[] in, StringBuffer out, boolean[] used, int length, int level) {
		if (level == length) {
			System.out.println(out.toString());
			return;
		}
		for (int i = 0; i < length; ++i) {
			if (used[i])
				continue;
			out.append(in[i]);
			used[i] = true;
			System.out.println("before rec " + out);
			doPermute(in, out, used, length, level + 1);
			used[i] = false;
			System.out.println("after rec " + out);
			out.setLength(out.length() - 1);
		}
	}
    
    public static void main(String[] args) throws Exception {
    	//StringCommonQuestions q = new StringCommonQuestions();
    	//q.permute("abc");
    	StringCommonQuestions.permutation("abcd");
    	//System.out.println(Arrays.toString(StringCommonQuestions.getPerms("abcd", new ArrayList<String>()).toArray()));
    }
}
