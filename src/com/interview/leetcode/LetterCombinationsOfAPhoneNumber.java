package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
    Given a digit string, return all possible letter combinations that the number could represent.

	A mapping of digit to letters (just like on the telephone buttons) is given below.
	
	1       2(abc)  3(def)
	4(ghi)  5(jkl)  6(mno)
	7(pqrs) 8(tuv)  9(wxyz)
	
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	Note:
	Although the above answer is in lexicographical order, your answer could be in any order you want.
 
 * @author shuchun.yang
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
		ArrayList<String> results = l.letterCombinations("234");
		System.out.println(Arrays.toString(results.toArray()));
	}
	
	public ArrayList<String> letterCombinations(String digits) {
        String[] letters = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		ArrayList<String> results = new ArrayList<String>();
		
		if (digits==null||digits.length()==0) {
			results.add("");
			return results;
		}
		
		combination(letters, results, new StringBuilder(), 0, digits);
		return results;
    }
	
	public void combination(String[] letters, ArrayList<String> results, StringBuilder sb, int level, String digits) {
		if (level==digits.length()) {
			results.add(sb.toString());
			return;
		}
		
		int currentDigit = digits.charAt(level)-'0';
		for (int i=0; i<letters[currentDigit].length(); i++) {
			sb.append(letters[currentDigit].charAt(i));
			combination(letters, results, sb, level+1, digits);
			sb.deleteCharAt(sb.length()-1);
		}	
	}
}
