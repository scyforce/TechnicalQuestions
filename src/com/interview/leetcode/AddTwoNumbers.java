package com.interview.leetcode;

/**
	
	You are given two linked lists representing two non-negative numbers. 
	
	The digits are stored in reverse order and each of their nodes contain a single digit. 
	
	Add the two numbers and return it as a linked list.
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8

 * @author shuchun.yang
 *
 */
public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(5);
		l1.next = l3; l3.next = l4;
		
		ListNode l2 = new ListNode(1);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(5);
		l2.next = l5; l5.next = l6;
		
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode result = a.addTwoNumbers1(l1, l2);
		result.print();
	}
	
	
	
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		if (l1==null||l2==null) {
			return null;
		}
		
		ListNode previous = new ListNode(0);
		ListNode head = previous;
		int sum = 0;
		while (l1!=null||l2!=null) {
			if (l1!=null) {
				sum = sum + l1.val;
				l1 = l1.next;
			}
			
			if (l2!=null) {
				sum = sum + l2.val;
				l2 = l2.next;
			}
			
			head.next = new ListNode(sum%10);
			head = head.next;
			sum = sum / 10;
		}
		
		if (sum>0) {
			head.next = new ListNode(1);
		}
		return previous.next;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//the result is also in reverse order
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null||l2==null) {
        	return null;
        }
        
        ListNode previous = new ListNode(0);
        ListNode head = previous;
        int sum = 0;
        while(l1!=null||l2!=null) {
        	if (l1!=null) {
        		sum = sum + l1.val;
        		l1 = l1.next;
        	}
        	if (l2!=null) {
        		sum = sum + l2.val;
        		l2 = l2.next;
        	}
        	head.next = new ListNode(sum%10);
        	head = head.next;
        	//carry on
        	sum = sum / 10;
        }
        //{5},{5}
        if (sum==1) {
        	head.next = new ListNode(1);
        }
		return previous.next;
    }
}
