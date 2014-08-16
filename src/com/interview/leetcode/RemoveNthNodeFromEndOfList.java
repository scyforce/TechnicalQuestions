package com.interview.leetcode;

/**

	Given a linked list, remove the nth node from the end of list and return its head.
	
	For example,
	
	   Given linked list: 1->2->3->4->5, and n = 2.
	
	   After removing the second node from the end, the linked list becomes 1->2->3->5.
	   
	Note:
	Given n will always be valid.
	Try to do this in one pass.

 * @author shuchun.yang
 *
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) {
        	return null;
        }
        
        ListNode node = head;
        
        while (n>0) {
        	node = node.next;
        	n--;
        }
        
        ListNode newHead = head;
        ListNode previous = null;
        //move node to end.next of the list
        while (node!=null) {
        	previous = head;
        	head = head.next;
        	node = node.next;        	
        }
        
        //if the deleted one is the first element in the list
        if (previous==null) {
        	newHead = head.next;
        } else {
        	//set previous node to the one after the deleted node
            ListNode newNext = head.next;
            previous.next = newNext;
        }    
        return newHead;        
    }
}
