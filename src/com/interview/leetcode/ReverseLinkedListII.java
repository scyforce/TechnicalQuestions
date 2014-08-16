package com.interview.leetcode;

/**

	Reverse a linked list from position m to n. Do it in-place and in one-pass.
	
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	
	return 1->4->3->2->5->NULL.
	
	Note:
	Given m, n satisfy the following condition:
	1 ² m ² n ² length of list.

 * @author shuchun.yang
 *
 */
public class ReverseLinkedListII {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ReverseLinkedListII r = new ReverseLinkedListII();
		ListNode head = r.reverseBetween(l1, 2, 3);
		head.print();
	}
	
	/*
	 * Idea: 
	 * 
	 * find previous node to mth node
	 * reverse until nth node
	 * 
	 * either head or previous.next
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null) {
        	return head;
        }
        
        //safe guard
        ListNode previous = new ListNode(0);
        previous.next = head;
        
        ListNode last = head;
        
        //find (m-1)th node and mth node
        for (int i=0; i<m-1; i++) {
        	previous = last;
        	last = last.next;
        }
        
        //reverse times
        int times = n-m;
        
        //start from (m+1)th node
        ListNode current = last.next;
        for (int i=0; i<times; i++) {
        	last.next = current.next;
        	current.next = previous.next;
        	previous.next = current;
        	current = last.next;
        }
        
        return (m==1) ? previous.next : head;     
    }
}
