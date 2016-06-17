package leetcode.Easy;

class ListNode2 {
	int val;
	ListNode2 next;

	ListNode2(int x) {
		val = x;
	}
}

public class RemoveNthNodeFromLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] que = { 1, 2 };
		ListNode2 head = null;
		ListNode2 temp = null;
		for (int i = 0; i < que.length; i++) {
			ListNode2 newNode = new ListNode2(que[i]);
			newNode.next = null;
			if (head == null) {
				head = newNode;
				temp = head;
			} else {
				head.next = newNode;
				head = newNode;
			}
		}
		printList(temp);
		removeNthFromEnd(temp, 1);
		printList(temp);
	}

	public static void printList(ListNode2 list) {
		while (list != null) {
			System.out.print(list.val + "==>");
			list = list.next;
		}
		System.out.print("null");
	}

	public static ListNode2 removeNthFromEnd(ListNode2 head, int n) {

		if(head == null){
            return null;
        }

        ListNode2 fast = head;
        ListNode2 slow = head; 
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode2 curr = slow.next;
        slow.next = curr.next;

        return head; 

	}

}
