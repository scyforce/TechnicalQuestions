package com.interview.designpattern.prototype;

/*
 * Prototype design pattern is used when very similar objects frequently are required. 
 * Prototype pattern clones objects and set the changed feature. This way less resources are consumed. 
 */
interface Prototype {
  void setSize(int x);
  void printSize();
}