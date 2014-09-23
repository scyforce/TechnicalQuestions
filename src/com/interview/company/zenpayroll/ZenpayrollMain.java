package com.interview.company.zenpayroll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class ZenpayrollMain {
	public static void main(String[] args) throws ParseException {
		if (args.length!=1) {
			System.err.println("Please provide input filePath");
			System.exit(-1);
		}
		
		String filePath = args[0];
		try {
			File input = new File(filePath);
			File output = new File("output.txt");
			if (!output.exists()) {
				output.createNewFile();
			}
			
			BufferedReader reader = new BufferedReader(new FileReader(input));
			BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			String line = "";		
			DataParser parser = new DataParser();
			DataDisplayer displayer = new DataDisplayer();
			while ((line = reader.readLine())!=null) {
				Company company = parser.parseCompanyInfo(line);
				displayer.addCompany(company);
			}
			String result = displayer.getResults();
			writer.write(result);
			System.out.println("output.txt is created under " + output.getAbsolutePath());
			
			if (reader!=null) {
				reader.close();
			}
			if (writer!=null) {
				writer.close();
			}
		} catch (FileNotFoundException e) {
			System.err.println("file not found!");
			e.printStackTrace();			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}
}
