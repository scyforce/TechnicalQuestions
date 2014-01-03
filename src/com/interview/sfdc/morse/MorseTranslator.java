package com.interview.sfdc.morse;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MorseTranslator {
    public Map<String, String> asciiMorseMap;
    public Map<String, List<String>> wordContextMap;
    
    public MorseTranslator() {
    	asciiMorseMap = new HashMap<String, String>();
    	wordContextMap = new HashMap<String, List<String>>();
    }
    
    public static Comparator<String> lengthComparator() {
        return new Comparator<String>() {
          public int compare(String o1, String o2) {  
        	  return o2.length()-o1.length();
          }
        };
    }
  
	public void readInput(String line) {
		Scanner scanner = new Scanner(line).useDelimiter("\\s+");;
		String ascii = scanner.next();
		StringBuilder morse = new StringBuilder();
		while (scanner.hasNext()) {
			morse.append(scanner.next());
		}
		asciiMorseMap.put(ascii, morse.toString());
	}
     
    public void buildContext(String line) {
    	Scanner scanner = new Scanner(line).useDelimiter("\\s+");
    	while (scanner.hasNext()) {
            String morseCode = "";
            String word = scanner.next();
    		for (char ch : word.toCharArray()) {
    			String token = String.valueOf(ch);
    			String morse = asciiMorseMap.get(token);
    			if (morse!=null) {
    				morseCode += morse;
    			}
            }
    		//do not add word if morse code is empty
    		if (!("".equals(morseCode))) {
    			List<String> wordList = wordContextMap.get(morseCode);
    			
        		if (wordList==null) {
        			wordList = new ArrayList<String>();
        			wordContextMap.put(morseCode, wordList); 
        		}      		
        		wordList.add(word);
        		if (morseCode.equals("..--")) {
    				System.out.println(Arrays.toString(wordList.toArray()));
    			}
        		//System.out.println(morseCode + " " + Arrays.toString(wordList.toArray()));
    		}     	
    		System.out.println(word + " " + morseCode);
    	}
    }
    
    public String match(String line) {   	
    	Scanner scanner = new Scanner(line).useDelimiter("\\s+");
        StringBuilder result = new StringBuilder();
        while (scanner.hasNext()) {
        	String morseCode = scanner.next();
        	List<String> wordList = wordContextMap.get(morseCode);
        	if (wordList==null) {
        		System.out.println("BEFORE KEYS - " + Arrays.toString(wordContextMap.keySet().toArray()));  
        		List<String> morseCodeKeys = new ArrayList<String>(wordContextMap.keySet());
        		Collections.sort(morseCodeKeys,lengthComparator());
        		System.out.println("KEYS - " + Arrays.toString(morseCodeKeys.toArray()));       		
        		for (String morseCodeKey : morseCodeKeys) {
        			wordList = wordContextMap.get(morseCodeKey);
        			if (morseCodeKey.contains(morseCode)) {       				
        				result.append(wordList.get(0)+"?\n");
        			}
        		}
        	} else {
        		String word = wordList.get(0);        		
        		if (wordList.size()>1) {
        			Collections.sort(wordList,lengthComparator());
        			Collections.reverse(wordList);
        			System.out.println("WORD - " + Arrays.toString(wordList.toArray()));  
        			word = wordList.get(0) + "!";
        		} 
        		//System.out.println(word+"!!!!!!");
        		result.append(word+"\n");
        	}
        }
    	
    	return result.toString();
    }
	
	public void printMap() {
		System.out.println(asciiMorseMap);
	}
}
