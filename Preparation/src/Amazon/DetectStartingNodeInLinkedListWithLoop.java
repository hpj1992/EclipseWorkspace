package Amazon;


public class DetectStartingNodeInLinkedListWithLoop {

	public static ListNode getFirstNodeInLinkedListWithLoop(ListNode node)
	{
		if(node == null)
			return null;
		ListNode slow = node;
		ListNode fast = node;
		ListNode first = node;
		while(fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
			{
				while(first != slow)
				{
					first = first.next;
					slow = slow.next;
				}
				return first;
			}
		}
		return null;
		
	}
}
