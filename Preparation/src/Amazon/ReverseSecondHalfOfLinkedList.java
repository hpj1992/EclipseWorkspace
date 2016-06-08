package Amazon;

public class ReverseSecondHalfOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		ListNode ans = new ReverseSecondHalfOfLinkedList().reverseSecondHalfOfLinkedList(a);
		while(ans != null)
			{
			System.out.print(ans.val + " -> ");
			ans = ans.next;
			}
		
	}
	
	public ListNode reverseSecondHalfOfLinkedList(ListNode list)
	{
		if(list == null)
			return null;
		ListNode slow = list;
		ListNode fast = list;
		while(fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast.next != null)
			slow = slow.next;
		
		ListNode prev = slow;
		slow = slow.next;
		prev.next = null;
		
		while(slow != null)
		{
			ListNode temp = slow;
			slow = slow.next;
			temp.next = prev;
			prev = temp;			
		}
		return prev;
	}
}
