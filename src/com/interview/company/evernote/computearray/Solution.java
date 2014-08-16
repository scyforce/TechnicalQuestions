package com.interview.company.evernote.computearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	
	
	public static void main(String[] args) throws IOException {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File input = new File("/Users/shuchun.yang/Dropbox/InterviewQuestions/data/evernote/sample3.dat");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		String line = "";
		long lineNumber = 0;
		
		int lines = 0;
		
		List<Integer> intList = new ArrayList<Integer>();
		while ((line = reader.readLine())!=null) {
			line = line.trim();
			if (lineNumber == 0) {
				lines = Integer.parseInt(line);
			} else {	
				if (lines>0) {
					intList.add(Integer.parseInt(line));
				}
				lines--;
			}
			lineNumber++;
			
		}
		
		if (reader!=null) {
			reader.close();
		}
		
		long sum = 1l;
		List<Integer> zeroList = new ArrayList<Integer>();
		for (int i=0; i<intList.size(); i++) {
			if (intList.get(i).intValue() != 0) {
				sum *= intList.get(i).intValue();
			} else {
				zeroList.add(i);
			}
		}
		
		for (int i=0; i<intList.size(); i++) {
			if (zeroList.size()>1) {
				System.out.println(0);
			} else if (zeroList.size()==1){
				if (zeroList.get(0) == i) {
					System.out.println(sum);
				} else {
					System.out.println(0);
				}				
			} else {
				System.out.println(sum/intList.get(i).intValue());
			}			
		}
		
	}

}
