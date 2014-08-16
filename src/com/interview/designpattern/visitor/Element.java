package com.interview.designpattern.visitor;

interface Element {
	public void accept(Visitor visitor);
}