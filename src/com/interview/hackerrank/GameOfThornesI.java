package com.interview.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class GameOfThornesI {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans;
        
        Map<Character, Integer> results = new HashMap<Character, Integer>();
        for (int i=0; i<inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (results.get(c)!=null) {
                results.put(c, results.get(c)+1);
            } else {
                results.put(c,1);
            }
        }
        
        int numberOfOdds = 0;
        for (Entry<Character,Integer> result : results.entrySet()) {
            int number = result.getValue();
            if (number%2!=0) {
                numberOfOdds = numberOfOdds+1;
            }
        }
        
        // Assign ans a value of s or no, depending on whether or not inputString satisfies the required condition
        System.out.println(numberOfOdds>1?false:true);
        myScan.close();
	}
}
