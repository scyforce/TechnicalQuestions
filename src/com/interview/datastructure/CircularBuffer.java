package com.interview.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class CircularBuffer {
	private String[] buffer;
	private int currentSize;
	private int start;
	
	public CircularBuffer(int size) {
		this.buffer = new String[size];
	}
	
	public boolean isEmpty() {
		return this.currentSize == 0;
	}
	
	public boolean isFull() {
		return this.currentSize == this.buffer.length;
	}
	
	public void append(String elem) {
		int end = (this.start + this.currentSize)%this.buffer.length;
		buffer[end] = elem;
		
		if (isFull()) {
			this.start = (this.start+1)%this.buffer.length;
		} else {
			this.currentSize++;
		}
	}
	
	//start is the oldest element
	public String remove() {
		String elem = buffer[start];
		this.start = (this.start+1)%this.buffer.length;
		this.currentSize--;
		return elem;
	}
    
    public void list() {
        if (!isEmpty()) { 
        	int end = (this.start + this.currentSize)%this.buffer.length;
            if (start == end) {
                System.out.println(buffer[start]);
            } else if (start < end) {
                for (int i=start; i<=end; i++) {
                    if (this.buffer[i]!=null) {
                        System.out.println(this.buffer[i]);
                    }                    
                }
            } else {
                for (int i=start; i<this.buffer.length; i++) {
                    if (this.buffer[i]!=null) {
                        System.out.println(this.buffer[i]);
                    }
                }
                for (int i=0; i<=end; i++) {
                    if (this.buffer[i]!=null) {
                        System.out.println(this.buffer[i]);
                    }
                }
            }
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File input = new File("/Users/shuchun.yang/Dropbox/InterviewQuestions/data/evernote/sample1.dat");
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line = "";
        long lineNumber = 0;
        
        int lines = 0;
        
        boolean isReadMode = false;
        CircularBuffer solution = null;
        while ((line = reader.readLine())!=null) {
            line = line.trim();
            if (lineNumber == 0) {
                lines = Integer.parseInt(line);             
                solution = new CircularBuffer(lines);                        
            } else {
                if (isReadMode) {
                   lines--;
                   solution.append(line);
                   if (lines==0) {
                       isReadMode = false;
                   }
                } else {
                   if (line.startsWith("A ")) {
                       lines = Integer.parseInt(line.split(" ")[1]);
                       isReadMode = true;
                   } else if (line.startsWith("R ")) {
                       lines = Integer.parseInt(line.split(" ")[1]);
                       for (int i=0; i<lines;i++) {
                           solution.remove();                   
                       }       
                   } else if (line.equals("L")) {
                       solution.list();                  
                   } else if (line.equals("Q")) {
                       System.exit(0);
                   } 
                }
            }
            lineNumber++;
        }     
        if (reader!=null) {
            reader.close();
        }
    }

}

