package Amazon;

import java.util.LinkedList;



public class MergeTwoListInSortedOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void mergeTwoList(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null)
			return;

		ListNode ans = new ListNode(-1);
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				ans.next = list1;
				list1 = list1.next;
			} else if (list1.val > list2.val)
				ans.next = list2;
			list2 = list2.next;

			ans = ans.next;
		}
		ans.next = list1 == null ? list2 : list1;
	}
}
