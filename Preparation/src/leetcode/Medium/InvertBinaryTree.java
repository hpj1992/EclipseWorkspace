package leetcode.Medium;

import leetcode.TreeNode;

public class InvertBinaryTree {
	public static void main(String[] args)
	{
		String s = "12345";
	}
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null)
			return null;
		TreeNode invertedRight = invertTree(root.right);
		TreeNode invertedLeft = invertTree(root.left);
		root.left = invertedRight;
		root.right = invertedLeft;
		return root;
    }
}
