package leetcode;

class BinaryTreeLevelOrderTraversal
{
 public List<List<Integer>> levelOrder(TreeNode root) {
         
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
			 return ans;
		}
    }
}