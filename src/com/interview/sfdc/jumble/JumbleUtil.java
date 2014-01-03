package com.interview.sfdc.jumble;

import java.util.Arrays;
import java.util.List;

public class JumbleUtil {
    public static boolean equals(String s1, String s2) {
    	if (s1==null || s2==null) {
    		return false;
    	}   	
    	if (s1.length()==s2.length()) {
    		char[] c1 = s1.toCharArray();
    		char[] c2 = s2.toCharArray();
    		Arrays.sort(c1);
    		Arrays.sort(c2);
    		String newS1 = new String(c1);
    		String newS2 = new String(c2);   		
    		if (newS1.equals(newS2)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static String output(List<String> words) {
    	StringBuilder sb = new StringBuilder();
    	if (words.isEmpty()) {
    		sb.append("NOT A VALID WORD\n");
    	} else {
    		for (String word : words) {
    			sb.append(word+"\n");
    		}
    	}
    	sb.append("******");
    	return sb.toString();
    }
    
    public static void main(String[] args) {
    	String s1 = "tarpa";
    	String s2 = "aptrb";
    	
    	System.out.println(JumbleUtil.equals(s1, s2));
    }
}
