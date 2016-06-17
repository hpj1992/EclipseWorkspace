package leetcode.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		if(root == null)
			return new ArrayList<List<Integer>>();
		else
		{
			List<List<Integer>> ans = new ArrayList<List<Integer>>();
			List<Integer> second = null;
			Queue<TreeNode> previous = new  LinkedList<TreeNode>();
			previous.add(root);
			while(previous.size()>0)
			{
				List<TreeNode> newPrevious = new ArrayList<TreeNode>();
				second =  new ArrayList<Integer>();
				while(previous.size() > 0)
				{
					TreeNode node = previous.poll();
					second.add(node.val);
					if(node.left != null)
					newPrevious.add(node.left);
					if(node.right != null)
						newPrevious.add(node.right);
				}
				ans.add(second);
				previous.addAll(newPrevious);
			
			}
			 Collections.reverse(ans);
			 return ans;
		}
	}

}
