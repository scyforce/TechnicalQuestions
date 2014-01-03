package com.interview.sfdc.morse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MorseTranslatorMain {
	public static boolean isMorseLine(String line) {
    	return line.startsWith(".") || line.startsWith("-");
    }
	
	public static boolean isStarLine(String line) {
		return line.startsWith("*");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		
		try {
			File input = new File("data/prog3.dat");
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line = "";
			MorseTranslator translator = new MorseTranslator();
			boolean isPreviousLineStar = false;
			while ((line = reader.readLine())!=null) {
				if(isStarLine(line)) {
					isPreviousLineStar = true;
					continue;
				} else if (isPreviousLineStar) {
					if (isMorseLine(line)) {
						System.out.print(translator.match(line));						
					} else {
						translator.buildContext(line);
					}
				} else {
					System.out.println(line);
					translator.readInput(line);
				}   	
			}		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
