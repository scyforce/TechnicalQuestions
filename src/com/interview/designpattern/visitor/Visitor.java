package com.interview.designpattern.visitor;

/*
 * Visitor pattern is a design pattern commonly used in the parser of a compiler, such as Eclipse JDT AST Parser.
 * 
 * Basically, there are two interfaces - Visitor and Element - in Visitor pattern.
 */
interface Visitor {
	public void visit(City city);
	public void visit(Museum museum);
	public void visit(Park park);
}
