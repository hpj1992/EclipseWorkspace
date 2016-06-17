package leetcode.Medium;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
		inorderTraversal(b);
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;

	    while(cur!=null || !stack.empty()){
	        while(cur!=null){
	            stack.add(cur);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        list.add(cur.val);
	        cur = cur.right;
	    }

	    return list;

	}
}
