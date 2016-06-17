package leetcode.Easy;

import leetcode.ListNode;
public class ReverseLinkedlist {

	public static ListNode reverse(ListNode head)
	{
		ListNode ans = null;
		while(head != null)
		{
			ListNode temp = head;
			if(ans == null)
				ans = temp;
			else
			{
				temp.next = ans;
				ans = temp;
			}
			head = head.next;
		}
		return ans;
	}
}
