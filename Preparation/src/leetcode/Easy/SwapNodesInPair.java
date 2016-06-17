package leetcode.Easy;

public class SwapNodesInPair {

	public static void main(String[] args)
	{
		
	}
	
	public ListNode swap(ListNode head)
	{
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode current = dummy;
		
		while(current.next != null && current.next.next != null)
		{
			ListNode first = dummy.next;
			ListNode second = first.next;
			current.next = second;
			first.next = second.next;
			second.next = first;
			current = first;
			first = first.next;
			
		}
		
		return dummy.next;
	}
	
	//Recursive
	public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
