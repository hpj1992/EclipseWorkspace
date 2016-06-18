package leetcode.Easy;

import Amazon.TreeNode;

public class SymmetricTree {

	public static void main(String[] args)
	{
		
	}
	
	 public boolean isSymmetric(TreeNode root)
		{
		    if(root == null)
		        return true;
		    else
			    return isSame(root.left, root.right);
		}
		
		public boolean isSame(TreeNode left,TreeNode right)
		{
			if(left == null && right == null)
				return true;
			else if(left == null || right == null)
				return false;
			else
			{
				if(left.val==right.val)
				{
					return isSame(left.right, right.left) && isSame(left.left, right.right);
				}
				else
					return false;
			}
		}
}
