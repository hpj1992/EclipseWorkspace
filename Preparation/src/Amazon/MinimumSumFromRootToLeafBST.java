package Amazon;

public class MinimumSumFromRootToLeafBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getMinSum(TreeNode root)
	{
		if(root == null)
			return 0;
		
		if(root.right == null && root.left != null)
			return getMinSum(root.left) + root.val;
		else if(root.left == null && root.right != null)
			return getMinSum(root.right) + root.val;
		return Math.min(getMinSum(root.left),getMinSum(root.right)) + root.val;
	}
}
