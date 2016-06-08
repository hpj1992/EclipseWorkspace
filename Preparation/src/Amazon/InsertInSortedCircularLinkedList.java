package Amazon;

public class InsertInSortedCircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode addNewNodeInSortedCircularLinkedList(ListNode node,int newNodeData)
	{
		if(node == null)
		{
			ListNode newNode = new ListNode(newNodeData);
			newNode.next = newNode;
			return newNode;
		}
		
		ListNode cur = node;
		while(cur != node)
		{
			if(newNodeData > cur.val && newNodeData < cur.next.val) break; //Ascednding order
			if (cur.val > cur.next.val && (newNodeData < cur.next.val || newNodeData > cur.val))    break; //Descending order
			node = node.next;
		}
		ListNode newNode = new ListNode(newNodeData);
		newNode.next = cur.next;
		cur.next = newNode;
		return newNode;	
	}

}
