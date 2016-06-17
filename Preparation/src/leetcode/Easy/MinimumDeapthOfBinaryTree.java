package leetcode.Easy;

public class MinimumDeapthOfBinaryTree {
	public int minDepth(TreeNode root) {
        int height = 0;
		if(root == null)
			return 0;
		
		if(root.right != null && root.left != null)
		{
			int right = minDepth(root.right);
			int left =  minDepth(root.left);
			height = Math.min(right, left) + 1;
		}
		else if(root.right != null && root.left == null)
			height = minDepth(root.right)+1;
		else if(root.left != null && root.right == null)
			height = minDepth(root.left) + 1;
			else
			    return 1;
	
		return height;
    }
	public static void main(String[] args)
	{
		System.out.println("hello");
	}
	
	
}
