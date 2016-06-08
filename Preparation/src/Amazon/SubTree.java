package Amazon;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SubTree {

	public static boolean isSubTree(TreeNode t1,TreeNode t2)
	{
		if(t1 == null || t2 == null)
			return false;
		if(t1.val == t2.val)
			return checkRecursively(t1, t2);
		else 
			return isSubTree(t1.left, t2) || isSubTree(t1.right, t2.left);
	}
	
	public static boolean checkRecursively(TreeNode t1,TreeNode t2)
	{
		if(t1 == null && t2 == null)
			return true;
		else if(t1.val == t2.val)
			return checkRecursively(t1.left, t2.left) && checkRecursively(t1.right, t2.right);
		else
			return false;
	}
}
