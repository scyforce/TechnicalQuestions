package com.interview.leetcode;

/**
 *  Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

	You should preserve the original relative order of the nodes in each of the two partitions.
	
	For example,
	
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
 * @author shuchun.yang
 */
public class PartitionList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		
		l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6;
		
		ListNode l7 = new ListNode(1);
		ListNode l8 = new ListNode(2);
		l7.next = l8;
		
		PartitionList p = new PartitionList();
		p.partition(l7, 2);
		
	}
	
	
	//the idea is loop through the list, if found less than x do not move, if greater than x insert to the end
	public ListNode partition(ListNode head, int x) {
        if (head==null||head.next==null) {
        	return head;
        }
		
		ListNode finalHead = head;
        ListNode last = head;        
        int length = 1;
        while (last.next!=null) {
        	last = last.next;
        	length = length + 1;
        }		
        //count
        int index = 0;
        ListNode previous = null;
        while (index<length) {
        	if (head.val>=x) {
        		//store next element
        		ListNode temp = head.next;
        		//move current to last
        		last.next = head;
        		//set current.next to null
        		head.next = null;
        		//move last to current
        		last = head;
        		//set new head
        		head = temp;
        		//if all previous all larger than x, then move finalHead to the next element
        		if (previous==null) {
        			finalHead = head;
        		} else {
        			//if reach the end, do not set previous
        			if (head!=null) {
        				previous.next = temp;
        			}        			
        		}
        	} else {
        		//if current is less than x, keep the position and move on
        		previous = head;
        		head = head.next;
        	}     
        	index++;
        }
        return finalHead;		
    }
}
