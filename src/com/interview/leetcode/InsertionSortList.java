package com.interview.leetcode;

/**

	Sort a linked list using insertion sort.

 * @author shuchun.yang
 *
 */
public class InsertionSortList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(1);
		
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		InsertionSortList i = new InsertionSortList();
		ListNode newHead = i.insertionSortList(head);
		System.out.println(newHead);
		
	}
	
	/*
	 * insertion sort psuedo code - 
	 * for i <- 1 to length(A)
       		j <- i
    		while j > 0 and A[j-1] > A[j]
        		swap A[j] and A[j-1]
        		j <- j - 1
	 */
	public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null) {
        	return head;
        }
        
        ListNode newHead = new ListNode(head.val);
        ListNode pointer = head.next;
        
        while(pointer!=null) {
        	ListNode innerPointer = newHead;       	
        	ListNode next = pointer.next;        	
        	
        	//if current node val is less than newHead node val, current node is the new head
        	if(pointer.val<=newHead.val) {
        		ListNode oldHead = newHead;
        		newHead = pointer;
        		newHead.next = oldHead;
        	} else {
        		while (innerPointer.next!=null) {
        			if (pointer.val>innerPointer.val&&pointer.val<=innerPointer.next.val) {
        				ListNode oldNext = innerPointer.next;
        				innerPointer.next = pointer;
        				pointer.next = oldNext;
        			}
        			innerPointer = innerPointer.next;
        		}
        		
        		if (innerPointer.next==null && pointer.val>innerPointer.val) {
        			innerPointer.next = pointer;
        			//this is important, otherwise will into dead loop
        			pointer.next = null;
        		}  		
        	}        	
        	pointer = next;
        }   
        return newHead;
    }
}
