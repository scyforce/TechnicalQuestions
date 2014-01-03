package com.interview.sfdc.jumble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JumbleMain {
public static void main(String[] args) {		
		
		try {
			File input = new File("data/prog4.dat");
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line = "";
			Jumble jumble = new Jumble();
			boolean startMatch = false;
			while ((line = reader.readLine())!=null) {
				//System.out.println(line);				
				if (jumble.isSeparator(line)) {
					startMatch = true;
					continue;
				} else {
					if (startMatch) {
						System.out.println(jumble.match(line));
					} else {
						jumble.buildDictionary(line);
					}
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
