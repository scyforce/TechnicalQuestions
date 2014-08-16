package com.interview.leetcode;

/**

	Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	
	Follow up:
	Can you solve it without using extra space?

 * @author shuchun.yang
 *
 */
public class LinkedListCycleII {
	//find the start of the loop
	public ListNode detectCycle(ListNode head) {
		if (head==null) {
			return null;
		}
		ListNode current = head;
		ListNode fast = head;
		
		while (fast.next!=null && fast.next.next!=null) {
			current = current.next;
			fast = fast.next.next;
			//there is a loop
			if (current==fast) {
				break;
			}
		}
		
		//no loop
    	if (fast.next==null || fast.next.next==null) {
    		return null;
    	}
    	
    	current = head;
    	while (current != fast) {
    		current = current.next;
    		fast = fast.next;
    	}
		return current;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(3);
		ListNode head3 = new ListNode(4);
		ListNode head4 = new ListNode(5);
		ListNode head5 = new ListNode(6);
		
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		
		LinkedListCycleII l = new LinkedListCycleII();
		System.out.println(l.detectCycle(head));
		
	}
}
