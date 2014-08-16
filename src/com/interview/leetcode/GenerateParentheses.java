package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**

	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	
	For example, given n = 3, a solution set is:
	
	"((()))", "(()())", "(())()", "()(())", "()()()"

 * @author shuchun.yang
 *
 */
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> results = new ArrayList<String>();
		if (n<1) {
			return results;
		}
		
		generateParenthesis(results, "", n, 0, 0);
		
		return results;
    }
	
	public void generateParenthesis(ArrayList<String> results, String str, int n, int open, int close) {
		if (open>n) {
			return;
		}
		
		if (open==n&&close==n) {
			System.out.println(str);
			results.add(str);
		} else {
			generateParenthesis(results, str+"{", n, open+1, close);
			if (open>close) {
				generateParenthesis(results, str+"}", n, open, close+1);
			}
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		ArrayList<String> r = g.generateParenthesis(3);		
		System.out.println(Arrays.toString(r.toArray()));
	}
	
}
