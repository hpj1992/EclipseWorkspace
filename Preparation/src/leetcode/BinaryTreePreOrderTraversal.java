package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreOrderTraversal {

	public static void main(String[] args)
	{
		ArrayList<Integer> ans = new ArrayList<Integer>();
		//getPreorderList(new TreeNode(), ans);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(8);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(7);
		TreeNode e = new TreeNode(1);
		TreeNode f = new TreeNode(9);
		d.left = e;
		e.right = f;
		b.left = a;
		b.right = c;
		a.left = d;
		getPreOrderListIterative(b);
/*			b8						
		a5		c3
	d7
  e1      
  	f9
 */
	}
	
	public static void getPreorderList(TreeNode node,ArrayList<Integer> ans)
	{
		if(node == null)
			return;
		
		ans.add(node.val);
		getPreorderList(node.left, ans);
		getPreorderList(node, ans);
		
		
	}
	
	public static  List<Integer> getPreOrderListIterative(TreeNode root)
	{
		List<Integer> pre = new LinkedList<Integer>();
        if(root==null) return pre;
        Stack<TreeNode> tovisit = new Stack<TreeNode>();
        tovisit.push(root);
        while(!tovisit.empty()) {
            TreeNode visiting = tovisit.pop();
            pre.add(visiting.val);
            if(visiting.right!=null) tovisit.push(visiting.right);
            if(visiting.left!=null) tovisit.push(visiting.left);
        }
        return pre;
		
	}
}
