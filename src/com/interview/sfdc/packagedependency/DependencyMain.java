package com.interview.sfdc.packagedependency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DependencyMain {
	public static void main(String[] args) {		
		try {
			File input = new File("data/prog6.dat");
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line = "";
			DependencyProcessor processor = new DependencyProcessor();
			while ((line = reader.readLine())!=null) {
				System.out.println(line);
				processor.generatePackageDependency(line);
			}		
			System.out.println(processor.installPackage());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
