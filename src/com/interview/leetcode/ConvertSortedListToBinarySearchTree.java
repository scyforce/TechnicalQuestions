package com.interview.leetcode;

/**

	Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	
 * @author shuchun.yang
 *
 */
public class ConvertSortedListToBinarySearchTree {
	static ListNode h;
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(3);
		ListNode head3 = new ListNode(4);
		ListNode head4 = new ListNode(5);
		
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		
		ConvertSortedListToBinarySearchTree c = new ConvertSortedListToBinarySearchTree();
		TreeNode r = c.sortedListToBST(head);
		System.out.println(r);
	}
	
	/**
	 * convert a sorted linkedlist 1->2->3->4->5 to a BST
	 *      3
	 *    1   4
	 *     2    5
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp!=null) {
        	temp = temp.next;
        	length++;
        }
        
        if (length==0) {
        	return null;
        }
        h = head;
        return sortedListToBST(0, length-1);
        
    }
	
	public TreeNode sortedListToBST(int start, int end) {
		if (start>end) {
			return null;
		}
		
		int middle = start + (end-start)/2;
		
		TreeNode leftNode = sortedListToBST(start, middle-1);
		TreeNode parent = new TreeNode(h.val);		
		h = h.next;
		TreeNode rightNode = sortedListToBST(middle+1, end);
		
		parent.left = leftNode;
		parent.right = rightNode;
		return parent;
		
	}
}
