package com.interview.designpattern.iterator;

public class IteratorExample {
	public static void main(String[] args) {
		RecordCollection recordCollection = new RecordCollection();
		IIterator iter = recordCollection.createIterator();
 
		while(iter.hasNext()){
			System.out.println(iter.next());
		}	
	}
}
