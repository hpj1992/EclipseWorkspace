package leetcode.Medium;

import Amazon.ListNode;

class AddTwoNumbers_2 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode();
		int[] one = { 1, 8 };
		int[] two = { 0 };
		for (int i = 0; i < one.length; i++) {
			if (i == 0)
				l1.val = one[i];
			else
				l1.next = (new ListNode(one[i]));
		}
		for (int i = 0; i < two.length; i++) {
			if (i == 0)
				l2.val = two[i];
			else
				l2.next = (new ListNode(two[i]));
		}
		ListNode ans = addTwoNumbers(l1, l2);
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;

		ListNode ansList = null;
		ListNode tempAns = ansList;

		while (l1 != null && l2 != null || carry ==1 ) {
			int curSum = 0;
			curSum += l1 != null ? l1.val : 0;
			curSum += l2 != null ? l2.val : 0;
			curSum += carry;
			if (curSum > 9) {
				carry = curSum / 10;
				curSum = curSum % 10;

			} else {

				carry = 0;
			}
			if (ansList != null) {
				ListNode next = new ListNode(curSum);
				ansList.next = next;
				ansList = ansList.next;
			} else {
				ansList = new ListNode(curSum);
				tempAns = ansList;
			}
			if(l1!=null) l1 = l1.next;
			if(l2!=null) l2 = l2.next;
		}
		if (carry > 0) {

			ListNode next = new ListNode(carry);
			ansList.next = next;
		}
		if (ansList == null)
			ansList = new ListNode(0);


		return tempAns;
	}
}
