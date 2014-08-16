package com.interview.leetcode;

/**

	Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
	
	If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
	
	You may not alter the values in the nodes, only nodes itself may be changed.
	
	Only constant memory is allowed.
	
	For example,
	Given this linked list: 1->2->3->4->5
	
	For k = 2, you should return: 2->1->4->3->5
	
	For k = 3, you should return: 3->2->1->4->5

 * @author shuchun.yang
 *
 */
public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		//ListNode l3 = new ListNode(4);
		//ListNode l4 = new ListNode(5);
		
		head.next = l1;
		l1.next = l2;
		//l2.next = l3;
		//l3.next = l4;
		
		ReverseNodesInKGroup r = new ReverseNodesInKGroup();
		ListNode newHead = r.reverseKGroup(head, 3);
		System.out.println(newHead);
	}
	
	//idea of reverse is always insert the current node at the first place
	public ListNode reverseInBetween(ListNode previous, ListNode next) {
		//after reverse, last node before next node
		ListNode last = previous.next;
		ListNode current = last.next;
		while (current!=next) {
			last.next = current.next;
			current.next = previous.next;
			previous.next = current;
			current = last.next;			
		}
		return last;
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||head.next==null||k<2) {
        	return head;
        }
        
        //0-1-2-3-4-5
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        //previous need to point to newHead
        ListNode previous = newHead;
        int index = 1;
        while(head!=null) {        	
        	if (index % k==0) {
        		//after first reverseInBetween, newHead will point to current head
        		previous = reverseInBetween(previous, head.next);
        		head = previous.next;
        	} else {
        		head = head.next;
        	} 
        	index = index + 1;
        }
        return newHead.next;
    }
}
