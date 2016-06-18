package leetcode.Easy;

import Amazon.TreeNode;

public class LowestCommonAncestorOfBST {

	 public static TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
	        
		 	if(root == null)
		 		return null;
		 	Amazon.TreeNode ans = null;
		 	if(contains(root.left,p) && contains(root.left,q))
		 	{
		 		ans = lowestCommonAncestorBT(root.left, p, q);
		 	}
		 	else if(contains(root.right,p) && contains(root.right,q))
		 	{
		 		ans = lowestCommonAncestorBT(root.right, p, q);
		 	}
		 	else if((contains(root.left,p) && !contains(root.left,q)) ||( contains(root.right,p) && !contains(root.right,q)))
		 	{
		 		ans = root;
		 	}
		 	return ans;
	    }
	 
	 public static boolean contains(TreeNode root,TreeNode element)
	 {
		 if(root == null)
			 return false;
		 if(root.val == element.val)
			 return true;
		 
		 return (contains(root.left,element) || contains(root.right,element));
		 
	 }
	 
	 public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
	        
		 	if(root == null)
		 		return null;
		 	TreeNode ans = null;
		 	if(p.val < root.val && q.val < root.val)
		 	{
		 		ans = lowestCommonAncestorBST(root.left, p, q);
		 	}
		 	else if(p.val > root.val && q.val > root.val)
		 	{
		 		ans = lowestCommonAncestorBST(root.right, p, q);
		 	}
		 	else 
		 	{
		 		ans = root;
		 	}
		 	return ans;
	    }
	 
}
