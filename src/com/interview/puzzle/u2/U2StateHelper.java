package com.interview.puzzle.u2;

import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;

public class U2StateHelper {   
    public static boolean contains (String[] array, String value) {
    	for (String tValue : array) {
    		if (tValue.equalsIgnoreCase(value)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static String[] processFrom (String[] from, String[] persons) {
    	Set<String> newFromSet = new HashSet<String>();
		for (String fromPerson : from) {
			if(!contains(persons, fromPerson)) {
				newFromSet.add(fromPerson);
			}
		}
    	String[] newFrom = new String[newFromSet.size()];    	
    	newFromSet.toArray(newFrom);
    	return newFrom;
    }
      
    public static String[] processTo (String[] to, String[] persons) {
    	String[] newTo = Arrays.copyOf(to, to.length+persons.length);
    	int index = to.length;
    	for (String person : persons) {
    		newTo[index++] = person;    		
    	}
    	return newTo;
    }
    
    public static void main (String[] args) {
    	String[] str1 = new String[]{"1","2","3","4"};
    	String[] str2 = new String[]{};
    	
    	String[] str3 = new String[]{"1","2","3"};
    	String[] str4 = new String[]{"4","5"};
    	
    	System.out.println(Arrays.toString(U2StateHelper.processFrom(str1, str2)));
    	
    	System.out.println(Arrays.toString(U2StateHelper.processFrom(str3, str4)));
    }
}
