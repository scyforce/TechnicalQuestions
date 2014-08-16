package com.interview.designpattern.chainofresponsibility;

class A extends Chain {
    public A(int threshold) { 
        this.Threshold = threshold;
    }
 
    protected void writeMessage(String msg) {
        System.out.println("A: " + msg);
    }
}
