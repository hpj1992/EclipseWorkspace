package leetcode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null && l2==null)
	            return null;
	        if(l1==null)
	            return l2;
	        if(l2==null)
	            return l1;
	            ListNode ans = new ListNode(-1);
	            ListNode headFirst = ans;
	            while(l1!=null && l2!=null)
	            {
	                int val = 0;
	                if(l1.val > l2.val)
	                {
	                    ans.next = l2;
	                    l2 = l2.next;
	                }
	                else
	                {
	                    ans.next = l1;
	                    l1 = l1.next;
	                }
	                ans.next.next = null; // This is very important step.
	                ans = ans.next;
	            }
	            
	            if(l1!=null)
	                ans.next = l1;
	            else
	                ans.next = l2;
	                
	            return headFirst.next;
	        
	    }

}
