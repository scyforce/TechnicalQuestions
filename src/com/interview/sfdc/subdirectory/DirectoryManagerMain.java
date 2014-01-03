package com.interview.sfdc.subdirectory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryManagerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File input = new File("/Users/shuchun.yang/Documents/workspace/Interview Prepartion/data/prog5.dat");
			File output = new File("/Users/shuchun.yang/Documents/workspace/Interview Prepartion/data/prog5.out");
			if (!output.exists()) {
				output.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(input));
		    BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			String line = "";
			DirectoryManager dirManager = new DirectoryManager("root");
			while ((line = reader.readLine())!=null) {
			    writer.write(String.format("Command: %s\n", line));
				String[] commandArgs = line.split("\\s+");
				String message = dirManager.executeCommand(commandArgs);
				writer.write(message);
				writer.flush();				
			}
			if (reader!=null) {
				reader.close();
			}
			if (writer!=null) {
				writer.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("file not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
