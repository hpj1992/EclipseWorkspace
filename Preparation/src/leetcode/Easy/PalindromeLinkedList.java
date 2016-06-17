package leetcode.Easy;

public class PalindromeLinkedList {
	public static void main(String[] args)
	{
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(1);
		c.next = d;
		b.next = c;
		a.next = b;
		System.out.println(isLinkedListPalindrome2(a));
	}

	public static boolean isLinkedListPalindrome2(ListNode node)
	{
		if(node == null)
			return false;
		if(node.next == null)
			return true;
		
		ListNode fast = node;
		ListNode reverse = new ListNode(node.val);
		while(fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			node = node.next;
			ListNode newNode = new ListNode(node.val);
			newNode.next = reverse;
			reverse = newNode;
		}
		
		//Check for even number of nodes in linked list
		if(fast.next != null)
			node = node.next;
		
		while(node != null)
		{
			if(node.val != reverse.val)
				return false;
			node = node.next;
			reverse = reverse.next;
		}
		return true;
	}
	
	/*public static boolean isLinkedListPalindrome(ListNode head)
	{ // integer logic will not work as it might include negative numbers
		 if(head == null)
				return true;
			if(head.next == null)
				return true;
			if(head.next.next == null)
			    return head.val == head.next.val;
			
			int reverse = 0;
			ListNode fast = head;
			
			while(fast !=null && fast.next.next != null)
			{
				reverse = reverse*10 + head.val;
				    fast = fast.next.next;
				
				head = head.next;
			}
			if(fast.next != null) // even numbers of element in list 
			{
				reverse = reverse*10 + head.val;
				
			}
			head = head.next;
			
			//reverse = reverse / 10;
			while(head != null && reverse > 0)
			{
				if(head.val != reverse%10)
					return false;
				head = head.next;
				reverse = reverse / 10;
			}
			
			return true;		
	}*/
}
