package com.interview.designpattern.chainofresponsibility;

/*
 * The main idea of Chain of Responsibility design pattern is to build a chain of processing unit, 
 * 
 * each unit handle the request if threshold is satisfied. Since a chain is built, 
 * 
 * if one unit is not satisfied, it's next unit will be tested, and so on. Each request will be process along the chain.
 */
abstract class Chain {
    public static int One = 1;
    public static int Two = 2;
    public static int Three = 3;
    protected int Threshold;
 
    protected Chain next;
 
    public void setNext(Chain chain) {
        next = chain;
    }
 
    public void message(String msg, int priority) {
        //if the priority is less than Threshold it is handled
    	if (priority <= Threshold) {
            writeMessage(msg);
        }
 
        if (next != null) {
            next.message(msg, priority);
        }
    }
 
    abstract protected void writeMessage(String msg);
}
