package com.interview.leetcode;

/**

	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	
	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.

 * @author shuchun.yang
 *
 */
public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
		ListNode newHead = r.deleteDuplicates(head);
		System.out.println(newHead);
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) {
        	return head;
        }
        //safeguard
        ListNode newHead = new ListNode(0);
        ListNode current = head;
        ListNode previous = newHead;
        newHead.next = current;
        
        while(current!=null&&current.next!=null) {
        	ListNode next = current.next;
        	if (next.val == current.val) {
        		//next until current and next value are different
        		while (next!=null && next.val==current.val) {
        			next = next.next;
        		}
        		//set previous point to next
        		previous.next = next;
            //if value is not the same, set previous point to current
        	} else {
        		previous = current;
        	}
        	//current should point to next
        	current = next;
        }
        
        return newHead.next;
    }
}
