package leetcode;

public class DeleteNodeInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void deleteNode(ListNode node) {
		if (node != null) {
			ListNode temp = node.next;
			node.val = temp.val;
			node.next = temp.next;
		}

	}

}
