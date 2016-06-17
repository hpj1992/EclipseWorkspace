package leetcode.Medium;

import leetcode.ListNode;
public class OddEvenLinkedList {

	public ListNode getOddEvenLinkedList(ListNode head)
	{
		 if (head != null) {

		        ListNode odd = head, even = head.next, evenHead = even; 

		        while (even != null && even.next != null) {
		            odd.next = odd.next.next; 
		            even.next = even.next.next; 
		            odd = odd.next;
		            even = even.next;
		        }
		        odd.next = evenHead; 
		    }
		    return head;
		
	}
}
