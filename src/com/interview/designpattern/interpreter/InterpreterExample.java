package com.interview.designpattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/*
 * Interpreter pattern is used when some context needs to be interpreted. 
 * 
 * expression ::= plus | minus | variable | number
   plus ::= expression expression '+'
   minus ::= expression expression '-'
   variable  ::= 'a' | 'b' | 'c' | ... | 'z'
   digit = '0' | '1' | ... | '9'
   number ::= digit | digit number
   
   each variable needs to be interpretered
 */
public class InterpreterExample {
    public static void main(String[] args) {
        String expression = "w x z - +";
        Evaluator sentence = new Evaluator(expression);
        Map<String,Expression> variables = new HashMap<String,Expression>();
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));
        int result = sentence.interpret(variables);
        System.out.println(result);
    }
}
