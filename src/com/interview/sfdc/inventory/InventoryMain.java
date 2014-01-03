package com.interview.sfdc.inventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InventoryMain {
    public static void main(String[] args) {
    	try {
			File input = new File("data/prog5.dat");
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line = "";
			InventoryManager manager = new InventoryManager();
			while ((line = reader.readLine())!=null) {
				if (!"*".equalsIgnoreCase(line)) {
					String message = manager.executeOperation(line);
					if (message!=null) {
						System.out.println(message);
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
