package leetcode.Easy;

import Amazon.TreeNode;
public class BalancedBinaryTree {

	public static void main(String[] args)
	{
		
	}
	
	public static boolean isBalanced(TreeNode root)
	{
		return !(getHeight(root) == -1);
	}
	
	public static int getHeight(TreeNode root)
	{
		if(root == null)
			return 0;
		else
		{
			int left = getHeight(root.left);
			int right = getHeight(root.right);
			if(Math.abs(left-right) > 1)
				return -1;
			else
				return (Math.max(left, right)+1);
		}
	}
}
