package com.interview.company.twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class Expression {
	public Reader reader;
	public int currentChar;
	
	public Expression(String line) {
		this.reader = new StringReader(line);
	}
	
	public void nextChar() throws IOException {
		this.currentChar = this.reader.read();
		while( this.currentChar == ' ' || this.currentChar == '\t' || 
				this.currentChar == '\n' || this.currentChar == '\r') {
			this.currentChar = this.reader.read();
		}
	}
	
	public int startRule() throws Exception {
		nextChar();
		return matchAdd();
	}
	
	private int matchAdd() throws Exception {
		int iResult = matchMultiply();
		
		while (this.currentChar == '+') {
			nextChar();
			iResult += matchMultiply();
		}
		
		return iResult;
	}
	
	private int matchMultiply() throws Exception {
		int iResult = matchInt();//matchAtom();
		
		while (this.currentChar == '*') {
			nextChar();
			iResult *= matchInt();//matchAtom();
		}
		
		return iResult;
	}
	
	private int matchAtom() throws Exception {
		int iResult = matchInt();
		while (this.currentChar == '(') {
			nextChar();
			iResult = matchAdd();			
			if (this.currentChar == ')') {
				return iResult;
			} else {
			    throw new Exception("Expected )");
			}
		}
		return iResult;
	}
	
	private int matchInt() throws IOException {
		int iValue = -1;
		String sInt = "";
		while (this.currentChar>='0' && this.currentChar<='9') {
			sInt += (char)this.currentChar;
			nextChar();
		}
		
		if (sInt.length() > 0) {
			iValue = Integer.parseInt(sInt);
		}
		return iValue;
	}
	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		Expression solution = null;
		while ((line = reader.readLine())!=null) {
			solution = new Expression(line);
			System.out.println(solution.startRule());
		}
	    
	}

}
