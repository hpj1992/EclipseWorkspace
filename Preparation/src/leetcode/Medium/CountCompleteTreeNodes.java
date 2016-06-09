package leetcode;

import javax.swing.border.EtchedBorder;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		a.left = b;
		a.right = c;
		b.left = d;
		CountCompleteTreeNodes node = new CountCompleteTreeNodes();
		int levels = node.getLevel(a);
		System.out.println(levels);
		System.out.println(node.getCount(1, levels, a, 0));
	}
	
	public int getLevel(TreeNode node)
	{
		if(node == null)
			return 0;
		int count = 1;
		while(node.left != null)
		{
			count++;
			node = node.left;
		}
		return count;
		
	}
	
	public int getCount(int currLevel,int maxLevel,TreeNode node,int count)
	{
		if(node == null)
			return 0;
		if(maxLevel == currLevel)
			count++;
		if(node.left != null)
			count = getCount(currLevel+1, maxLevel, node.left, count);
		if(node.right != null)
			count = getCount(currLevel+1,maxLevel,node.right,count);
		return count;
	}
	
	

}
