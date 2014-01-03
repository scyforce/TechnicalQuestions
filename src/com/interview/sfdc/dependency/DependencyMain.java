package com.interview.sfdc.dependency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DependencyMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		try {
			File input = new File("data/dependency.dat");
			reader = new BufferedReader(new FileReader(input));
			String line = "";
			DependencyManager manager = new DependencyManager();
			while ((line = reader.readLine())!=null) {
				System.out.println(line);
				if (!manager.isEndLine(line)) {
					String message = manager.executeCommand(line);
					if (!"".equals(message)) {
						System.out.print(message);
					}
				}					
			}		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reader.close();
		}

	}

}
