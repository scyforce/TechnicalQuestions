package com.interview.sfdc.htmlchecker;

public class HTMLValidatorOutput {
    public static String output(String message, int testCase) {
    	return String.format("Test Case %d\n", testCase) + message + "\n";
    }
    
    public static boolean hasError(String message) {
    	return !"OK".equals(message);
    }
}
