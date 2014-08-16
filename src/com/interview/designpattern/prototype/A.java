package com.interview.designpattern.prototype;

//a concrete class
class A implements Prototype, Cloneable {
  private int size;

  public A(int x) {
      this.size = x;
  }

  @Override
  public void setSize(int x) {
      this.size = x;
  }

  @Override
  public void printSize() {
      System.out.println("Size: " + size);
  }


  @Override
  public A clone() throws CloneNotSupportedException {
      return (A) super.clone();
  }
}