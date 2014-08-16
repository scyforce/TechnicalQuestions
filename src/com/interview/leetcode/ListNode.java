package com.interview.leetcode;

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
      val = x;
	  next = null;
   }
   @Override
   public String toString() {
	   return val + "";
   }
   
   public void print() {
	   ListNode head = this;
	   while (head!=null) {
		   System.out.print(head.val + " ");
		   head = head.next;
	   }
   }
}