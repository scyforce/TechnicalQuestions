package com.interview.evernote.buildmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.interview.sfdc.dependency.DependencyManager;

public class BuildManagerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File input = new File("/Users/shuchun.yang/Dropbox/InterviewQuestions/data/evernote/buildmanager.dat");
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line = "";
			BuildManager build = new BuildManager();
			while ((line = reader.readLine())!=null) {
				System.out.println(line);
				build.parseLine(line);			
			}		
			
			build.print();
			System.out.println("END");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
