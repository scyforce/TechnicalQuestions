package com.interview.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        File input = new File("/Users/shuchun.yang/Dropbox/TechnicalQuestions/data/hackerrank/1.txt");
        BufferedReader reader = new BufferedReader(new FileReader(input));
        int lines = Integer.parseInt(reader.readLine());
        boolean isFirstLine = true;
        
        boolean[] result = new boolean[26];       
        boolean[] currentResult = new boolean[26];  
        
        while (lines>0) {
            String line = reader.readLine();
            if (isFirstLine) {
            	for (int i=0; i<line.length(); i++) {
            		char c = line.charAt(i);
            		result[c-'a'] = true;
            	}
            	isFirstLine = false;
            } else {           	
            	for (int i=0; i<line.length(); i++) {
            		char c = line.charAt(i);
            		currentResult[c-'a'] = true;
            	}
            	
            	for (int i=0; i<result.length; i++) {
            		result[i] = result[i]&&currentResult[i];
            	}
            	
            	for (int i=0; i<currentResult.length; i++) {
            		currentResult[i] = false;
            	}
            }
            
            lines--;         
            
        }       
        reader.close();     
        
        for (int i=0; i<result.length; i++) {
        	if (result[i]) {
        		System.out.println(Character.toChars('a'+i));
        	}
        }     

    }
}