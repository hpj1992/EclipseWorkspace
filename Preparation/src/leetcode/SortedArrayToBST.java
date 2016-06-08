package leetcode;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class SortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] nums) {

		return getTree(nums,0,nums.length-1);
		
	}
	
	public TreeNode getTree(int[] arr,int start,int end)
	{
		if(start <= end)
		{
			int mid = start + (end - start)/2;
			TreeNode newNode = new TreeNode(arr[mid]);
			newNode.left = getTree(arr,start,mid-1);
			newNode.right = getTree(arr,mid+1,end);
			return newNode;
		}
		return null;
	}

}
