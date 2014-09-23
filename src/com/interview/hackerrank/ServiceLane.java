package com.interview.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class ServiceLane {
	public static void main(String[] args) throws IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		/*File input = new File("/Users/shuchun.yang/Dropbox/TechnicalQuestions/data/hackerrank/serviceLine.txt");
	    BufferedReader s = new BufferedReader(new FileReader(input));*/
		Scanner s = new Scanner(System.in);
        String[] line1 = s.nextLine().split(" ");
        int freeWayLength = Integer.parseInt(line1[0]);
        int testCases = Integer.parseInt(line1[1]);
        
        String[] serviceLanes = s.nextLine().split(" ");
        
        while (testCases>0) {
            String[] startEnd = s.nextLine().split(" ");
            int start = Integer.parseInt(startEnd[0]);
            int end = Integer.parseInt(startEnd[1]);
            
            int width = Integer.MAX_VALUE;
            for (int i=start; i<=end; i++) {
                int current = Integer.parseInt(serviceLanes[i]);
                if (current<width) {
                    width = current;
                }
            }
            System.out.println(width);
            testCases--;
        }
	}
}
