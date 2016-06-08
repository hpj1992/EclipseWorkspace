package Amazon;

public class DetectLoopInLinkedList {

	public static boolean isContainsLoop(ListNode node)
	{
		if(node == null)
			return false;
		ListNode slow = node;
		ListNode fast = node;
		while(fast.next != null && fast.next.next!= null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
			{
				return true;
			}
		}
		return false;
	}
}
