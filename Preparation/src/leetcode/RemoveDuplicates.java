package leetcode;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicates {

	

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		while (head.next != null) {
			if (head.val == head.next.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}
	public ListNode deleteDuplicates2(ListNode head) {
		 if (head == null || head.next == null)
				return head;

			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			while (head.next != null) {
			ListNode temp = head.next;
				
				while(temp!=null && head.val == temp.val )
					temp = temp.next;
					
				if(temp!=null)
				{
				head.next = temp;
				head = head.next;
				}
				else
				{
					head.next = null;
				}
				
			}
			return dummy.next;
	}
}
