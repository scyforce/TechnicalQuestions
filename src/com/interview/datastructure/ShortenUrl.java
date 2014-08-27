package com.interview.datastructure;

import java.util.HashMap;
import java.util.Map;

public class ShortenUrl {
	public static final int BASE = 62;
	public static final Map<Integer, Character> DIGIT_CHAR_MAP = new HashMap<Integer, Character>();
	public static final char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f',
		'g', 'h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	static {
		for (int i=0; i<BASE; i++) {
			if (i<10) {
				DIGIT_CHAR_MAP.put(i, Character.forDigit(i, 10));
			} else if (i>9 && i<36) {
				DIGIT_CHAR_MAP.put(i, chars[(i-10)%26]);
			} else {
				DIGIT_CHAR_MAP.put(i, Character.toUpperCase(chars[(i-36)%26]));
			}
		}
	}
	
	//base conversion
	public String shorturl(int id) {
		  StringBuilder result = new StringBuilder();
		  while (id > 0) {
		    int digit = id % BASE;
		    result.append(DIGIT_CHAR_MAP.get(digit));
		    id /= BASE;
		  }
		  while (result.length() < 6) {
			  result.append('0');
		  }
		  return result.reverse().toString();
	}
	
	public static void main(String[] args) {
		ShortenUrl url = new ShortenUrl();
	    System.out.println(url.shorturl(121));
	}
}
