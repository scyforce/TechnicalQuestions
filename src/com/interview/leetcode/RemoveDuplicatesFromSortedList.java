package com.interview.leetcode;

/**

	Given a sorted linked list, delete all duplicates such that each element appear only once.
	
	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.

 * @author shuchun.yang
 *
 */
public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		ListNode newHead = r.deleteDuplicates(head);
		System.out.println(newHead);
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {
		//safeguard
        ListNode newHead = new ListNode(0);
        ListNode current = head;
        //ListNode previous = newHead;
        newHead.next = current;
        
        while(current!=null&&current.next!=null) {
        	ListNode next = current.next;
        	if (next.val == current.val) {
        		//next until current and next value are different
        		while (next!=null && next.val==current.val) {
        			next = next.next;
        		}
        		current.next = next;
         	}
        	//current should point to next
        	current = next;
        }
        
        return newHead.next;
   }
}
