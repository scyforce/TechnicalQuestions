package com.interview.company.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InterviewQuestions {
	 /**
     * Big integer add input string
     * @param int1
     * @param int2
     * @return
     */
    public static String bigIntegerAdd(String int1, String int2) {
    	char[] intArray1 = int1.toCharArray();
    	char[] intArray2 = int2.toCharArray();
    	
    	StringBuilder results = new StringBuilder();
    	
    	int carryOn = 0;
    	
    	int i=intArray1.length-1;
    	int j=intArray2.length-1;
    	
    	while (i>=0 || j>=0) {
    		int i1 = (i>=0) ? Character.digit(intArray1[i], 10) : 0;
    		int i2 = (j>=0) ? Character.digit(intArray2[j],10) : 0;
    		
    		int sum = i1+i2+carryOn;
    		
    		if (sum>=10) {
    			carryOn = 1;
    		} else {
    			carryOn = 0;
    		}
    		
    		results.append(sum%10);
    		i--;
    		j--;
    	}
    	
    	if (carryOn>0) {
    		results.append(1);
    	}
    	
    	return results.reverse().toString();
    }
    
    /**
     * verify if parentheses matches
     * @param str
     * @param startPos
     * @param pOpen
     * @return
     */
    public static boolean doesParenthesesMatch(String str, int startPos, int pOpen) {
    	if (startPos == str.length()) {
    		return pOpen == 0;
    	}
    	
    	if (str.substring(startPos, startPos+1).equals("(")) {
    		pOpen+=1;
    	} if (str.substring(startPos, startPos+1).equals(")")) {
    		pOpen-=1;
    	}
    	
    	if (pOpen<0) {
    		return false;
    	}
    	
    	return doesParenthesesMatch(str, startPos+1, pOpen);
    }
    
    /**
     * Given a Tuple for eg. (a, b, c).. 
     Output : (*, *, *), (*, *, c), (*, b, *), (*, b, c), (a, *, *), (a, *, c), (a, b, *), (a, b, c)
     */
    public static void printTuple(String str) {
    	char[] cArray = str.toCharArray();
    	int num = 1<<cArray.length;
    	
    	for (int i=0; i<num; i++) {
    		int pos = cArray.length-1;
    		int bit = i;
    		System.out.print("(");
    		while (pos>=0) {
    			if ((bit & 1) == 1) {
    				System.out.print(cArray[pos] + ",");
    			} else {
    				System.out.print("*,");
    			}
    			bit>>=1;
    			pos--;
    		}
    		System.out.println(")");
    	}   	
    }
    
    /**
     * find longest common substring between two strings
     * @param first
     * @param second
     * @return
     */
    public static int longestSubstr(String first, String second) {
        if (first == null || second == null || first.length() == 0 || second.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int fl = first.length();
        int sl = second.length();
        int[][] table = new int[fl][sl];

        for (int i = 0; i < fl; i++) {
            for (int j = 0; j < sl; j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    if (i == 0 || j == 0) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    } if (table[i][j] > maxLen) {
                        maxLen = table[i][j];
                    }
                }
            }
        }
        return maxLen;
    }
    
    public static int countBinary(int number) {
       int count = 0;
       while(number != 0) {
    	  if ((number & 1)==1) {
    		  count++;
    	  }
    	  number = number >> 1;
       }
    	return count;
    }
    
    //not complete
    public static int findKthElementInTwoSortedArray(int[] array1, int[] array2, int k) {
    	int i = k/2;
    	int j = k-i;
    	int steps = k/4;
    	
    	while (steps>0) {
    		if (array1[i-1]>array2[j-1]) {
    			i=i-steps;
    			j=j+steps;
    		} else {
    			i=i+steps;
    			j=j-steps;
    		}
    		steps = steps/2;
    	}
    	
    	if (array1[i-1]>array2[j-1]) {
    		return array1[i-1];
    	} else {
    		return array2[j-1];
    	}
    	
    }
    
    //check in dictionary
    public static boolean printWords(String str, List<String> store, Set<String> dictionary) {
		if(str.length() == 0) {
			return true;
		}
		for(int i = 1; i <= str.length(); i++) {
			String curWord = str.substring(0, i);
			if(dictionary.contains(curWord) && printWords(str.substring(i), store, dictionary)) {
				store.add(curWord);
				return true;
			}
		}
		return false;
	}
    
    public static void main(String[] args) {
    	
    	String str = "sharperneedle";
		Set<String> dict = new HashSet<String>(Arrays.asList("sharp, sharper, needle"));
		List<String> store = new ArrayList<String>();
		System.out.println(InterviewQuestions.printWords(str, store, dict));
    	Collections.reverse(store);
    	for (String s : store) {
    		System.out.print(s);
    	}
    	/*System.out.println(InterviewQuestions.longestSubstr("ABABA", "BABAB"));
    	System.out.println(InterviewQuestions.countBinary(3));
    	
    	int[] array1 = {1,3,4,5,8};
    	int[] array2 = {2,6,4,5,9};
    	
    	System.out.println(InterviewQuestions.findKthElementInTwoSortedArray(array1, array2, 3));
    	
    	String str = "iamverynotwell";
    	List<String> store = new ArrayList<String>();
    	Set<String> dictionary = new HashSet<String>();
    	dictionary.add("very");
    	dictionary.add("i");
    	dictionary.add("am");
    	dictionary.add("not");
    	dictionary.add("no");
    	dictionary.add("well");
    	System.out.println(InterviewQuestions.printWords(str, store, dictionary));
    	Collections.reverse(store);
    	for (String s : store) {
    		System.out.print(s);
    	}*/
    }
}
