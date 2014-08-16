package com.interview.designpattern.iterator;

class RecordCollection implements IContainer{
	private String recordArray[] = {"first","second","third","fourth","fifth"};
 
	public IIterator createIterator(){
		RecordIterator iterator = new RecordIterator();
		return iterator;
	}
 
	private class RecordIterator implements IIterator{
		private int index;
 
		public boolean hasNext(){
			if (index < recordArray.length)
				return true;
			else
				return false;
		}
 
		public Object next(){
			if (this.hasNext())
				return recordArray[index++];
			else
				return null;
		}
	}
}
