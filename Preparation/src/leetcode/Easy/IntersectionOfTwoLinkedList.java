package leetcode.Easy;

import Amazon.ListNode;

public class IntersectionOfTwoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		ListNode g = new ListNode(7);
		ListNode h = new ListNode(8);
		
		a.next = b;
		b.next = c;
		c.next = d;
		h.next = e;
		e.next = f;
		f.next = c;
		d.next = g;
		System.out.println(getIntersectionOfLinkedList(h,a).val);
		

	}

	public static ListNode getIntersectionOfLinkedList(ListNode root1,ListNode root2)
	{
		if(root1 == null || root2 == null)
			return null;
		else
		{
			int length1 = getLength(root1);
			int length2 = getLength(root2);
			if(length1 > length2)
			{
				while(length2 < length1)
				{
					root1 = root1.next;
					length2++;
				}
			}
			else
			{
				while(length1 < length2)
				{
					root2 = root2.next;
					length1++;
				}
			}
			while(root2 != root1 && root2 != null && root1 != null)
			{
				root2 = root2.next;
				root1 = root1.next;
			}
			if(root1 == root2 && root1 != null && root2 != null)
				return root1;
			else
				return null;
		}
	}
	
	public static int getLength(ListNode root)
	{
		int count = 0;
		while(root != null)
		{
			root = root.next;
			count++;
		}
		return count;
	}
}
