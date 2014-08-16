package com.interview.designpattern.prototype;

//when we need a large number of similar objects
public class PrototypeExample {
  public static void main(String args[]) throws CloneNotSupportedException {
      A a = new A(1);

      for (int i = 2; i < 10; i++) {
          Prototype temp = a.clone();
          temp.setSize(i);
          temp.printSize();
      }
  }
}
