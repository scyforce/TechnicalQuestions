package com.interview.leetcode;

/**
	
	Reverse a given linkedlist
	
	e.g: 1->2->3->4->5 5->4->3->2->1

 * @author shuchun.yang
 *
 */
public class ReverseLinkedList {
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
		
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode head = r.reverse(l1);
		head.print();
	}
	
	public ListNode reverse(ListNode head) {
		if (head==null || head.next==null) {
			return head;
		}
		
		ListNode previous = new ListNode(0);
		previous.next = head;
		
		ListNode last = head;
		ListNode current = last.next;
		while(current!=null) {
			last.next = current.next;
			current.next = previous.next;
			previous.next = current;
			current = last.next;
		}
		
		return previous.next;
	}
}
