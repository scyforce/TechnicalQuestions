package com.interview.leetcode;

import java.util.Stack;

/**

	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	
	Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	
	Some examples:
	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 * @author shuchun.yang
 *
 */
public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens = {"2", "1", "+", "3", "*"};
		EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
		System.out.println(e.evalRPN(tokens));
		
		String[] tokens1 = {"18"};
		
		System.out.println(e.evalRPN(tokens1));
	}
	
	public int evalRPN(String[] tokens) {
        if (tokens==null) {
        	return 0;
        }
        
        if (tokens.length==1) {
        	return Integer.parseInt(tokens[0]);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
        	if (isOperator(token)) {
        		int i2 = stack.pop();
        		int i1 = stack.pop();
        		int result = calculate(token, i1, i2);
        		stack.push(result);
        	} else {
        		stack.push(Integer.parseInt(token));
        	}
        }
        return stack.pop();
    }
	
	public boolean isOperator(String str) {
		return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
	}
	
	private int calculate(String op, int i1, int i2) {
		if ("+".equals(op)) {
			return i1+i2;
		} else if ("-".equals(op)) {
			return i1-i2;
		} else if ("*".equals(op)) {
			return i1*i2;
		} else {
			return i1/i2;
		}
	}
}
