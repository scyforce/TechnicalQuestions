package com.interview.leetcode;

/**

	Given a linked list, determine if it has a cycle in it.
	
	Follow up:
	Can you solve it without using extra space?

 * @author shuchun.yang
 *
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head==null) {
			return false;
		}
		ListNode current = head;
		ListNode fast = head;
		
		while (fast.next!=null && fast.next.next!=null) {
			current = current.next;
			fast = fast.next.next;
			if (current==fast) {
				return true;
			}
		}
		
		return false;
	}
}
