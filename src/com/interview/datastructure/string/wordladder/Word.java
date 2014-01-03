package com.interview.datastructure.string.wordladder;

public class Word {
	
	public String value;
	public Word parent;
	
	public Word(String value, Word parent) {
		super();
		this.parent = parent;
		this.value = value;
	}	
	
	@Override
	public String toString() {
		return value;
	}

}
