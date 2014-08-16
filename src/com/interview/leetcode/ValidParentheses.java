package com.interview.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**

	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	
	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 * @author shuchun.yang
 *
 */
public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		System.out.println(v.isValid("{[}]"));
	}
	
	
	public boolean isValid1(String s) {
		if (s==null||s.length()<2) {
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> parentheses = new HashMap<Character, Character>();
		parentheses.put('{', '}');
		parentheses.put('[', ']');
		parentheses.put('(', ')');
		
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (parentheses.containsKey(c)) {
				stack.push(c);
			} else if (parentheses.containsValue(c)) {
				if (!stack.isEmpty() && c==parentheses.get(stack.peek())) {
					stack.pop();
				} else {
					return false;
				}
			}			
		}
		return stack.isEmpty();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean isValid(String s) {
		if (s==null || s.length()<2) {
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> parentheses = new HashMap<Character, Character>();
		
		parentheses.put('{', '}');
		parentheses.put('[', ']');
		parentheses.put('(', ')');
		
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (parentheses.containsKey(c)) {
				stack.push(c);
			} else if (parentheses.containsValue(c)){
				//right parenthese has not yet been pushed to stack
				if (!stack.isEmpty() && parentheses.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}	
		return stack.isEmpty();
    }
}
