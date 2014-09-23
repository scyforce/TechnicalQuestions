package com.interview.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);		
		int testCases = s.nextInt();
		s.nextLine();
		String[] array = new String[testCases];
		int index=0;
		while (testCases>0) {
			array[index] = s.nextLine();
			index = index + 1;
			testCases--;
		}
		s.close();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (String line : array) {
			if (line.length()%2!=0) {
				System.out.println(-1);
			} else {
				map.clear();
				int middle = line.length()/2;
				String firstString = line.substring(0, middle);
				String secondString = line.substring(middle, line.length());
				
				for (int i=0; i<middle; i++) {
					char firstC = firstString.charAt(i);
					if (map.get(firstC)==null) {
						map.put(firstC, 1);
					} else {
						map.put(firstC,map.get(firstC)+1);
					}				
				}
				int result = 0;
				for (int i=0; i<middle; i++) {
					char secondC = secondString.charAt(i);
					if (map.get(secondC)!=null&&map.get(secondC)>0) {
						map.put(secondC, map.get(secondC)-1);
					} else {
						result = result + 1;
					}				
				}
				System.out.println(result);				
			}		
			testCases--;
		}		
	}
}
