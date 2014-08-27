package com.interview.leetcode;

import java.util.Stack;

/**

	Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
	
	For "(()", the longest valid parentheses substring is "()", which has length = 2.
	
	Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 * @author shuchun.yang
 *
 */
public class LongestValidParentheses {
	public static void main(String[] args) {
		LongestValidParentheses l = new LongestValidParentheses();
		
		String s = "(()()";
		System.out.println(l.longestValidParentheses(s));
		
		s = "(())";
		System.out.println(l.longestValidParentheses(s));
		
		s =")()())";
		System.out.println(l.longestValidParentheses(s));
		
		s ="()(()())";
		System.out.println(l.longestValidParentheses(s));
	}
	
	public int longestValidParentheses(String s) {
        if (s==null||s.length()<2) {
        	return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int lastValidIndex = 0;
        int maxLength = 0;
        
        char[] pArray = s.toCharArray();
        
        for (int i=0; i<pArray.length; i++) {
        	char curr = pArray[i];
        	if (curr=='(') {
        		stack.push(i);
        	} else {
        		//)))) case
        		if (stack.isEmpty()) {
        			lastValidIndex = i+1;
        		} else {
        			stack.pop();
        			// () or (()) case, last ) in the string, you always need to start calculate from the lastValidIndex 
        			if (stack.isEmpty()) {
        				maxLength = Math.max(maxLength, i-lastValidIndex+1);
        			// (()() the second last ) in the string, you need to calculate from the top element in the stack
        			} else {
        				maxLength = Math.max(maxLength, i-stack.peek());
        			}
        		}
        	}
        }
        return maxLength;
    }
}
