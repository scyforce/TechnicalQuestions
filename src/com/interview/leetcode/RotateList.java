package com.interview.leetcode;

/**

	Given a list, rotate the list to the right by k places, where k is non-negative.
	
	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.

 * @author shuchun.yang
 *
 */
public class RotateList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		RotateList r = new RotateList();
		ListNode result = r.rotateRight(head, 6);
		result.print();
	}
	
	public ListNode rotateRight(ListNode head, int n) {
         if (head==null||head.next==null) {
        	 return head;
         }
         
         //find the length of the list 
         ListNode current = head;
         int length = 0;
         while (current!=null) {
        	 length = length+1;
        	 current = current.next;
         }
         
         //calculate the number of rotation times
         n = n % length;
         if (n==0) {
        	 return head;
         }
         
         //move to the nth to rightmost node
         current = head;
         while(n>0 && current!=null) {
        	 current = current.next;
        	 n--;
         }
         
         //move start to the right place
         ListNode start = head;
         while(current.next!=null) {
        	 start = start.next;
        	 current = current.next;
         }
          
         /*
          * n = 2
          * original 1->2->3->4->5 after move,
          * current = oldEnd = 5, start = newEnd = 3
          * 
          */
         ListNode oldEnd = current;
         ListNode end = start;
         start = start.next;
         
         oldEnd.next = head;
         end.next = null;
         
         return start;
    }
}
