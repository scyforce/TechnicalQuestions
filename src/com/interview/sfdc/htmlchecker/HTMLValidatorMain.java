package com.interview.sfdc.htmlchecker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLValidatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File input = new File("data/prog2.dat");
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line = "";
			
			int lineNumber = 1;			
			int testCase = 0;
			HTMLValidator validator = new HTMLValidator();
			String message = "";
			while ((line = reader.readLine())!=null) {
				line = validator.preprocessLine(line);			
				if (validator.isStartLine(line)) {
					if (message.equals("OK")) {
						message = validator.checkEndTag(line, lineNumber-1);
						String ouput = String.format("Test Case %d\n", testCase) + message + "\n";	                	
	                	System.out.println(ouput);
					}	
					message = "OK";
					lineNumber = 1;
					validator.resetValidator();
					testCase++;
					continue;
				}
				
				if (message.equals("OK")) {
	                message = validator.parse(line, lineNumber++);
	                if (!message.equals("OK")) {
	                	String ouput = String.format("Test Case %d\n", testCase) + message + "\n";	                	
	                	System.out.println(ouput);
	                }
				}
			}
			if (reader!=null) {
				reader.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("file not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
