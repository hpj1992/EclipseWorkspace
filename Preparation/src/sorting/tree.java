package sorting;

public class tree {
	
	public static void main(String[] args)
	{
		/*TreeNode test7=new TreeNode(7, null, null);
		TreeNode test8=new TreeNode(8, null, null);
		TreeNode test5=new TreeNode(5, null, null);
		TreeNode test9=new TreeNode(9, null, null);
		TreeNode test4=new TreeNode(4, test7, test8);
		TreeNode test6=new TreeNode(6, test5, test9);
		
		TreeNode test10=new TreeNode(10, test4, test6);
		test10.print(test10);*/
	}
	
	
}

class TreeNode2
{
	int root;
	TreeNode left;
	TreeNode right;
	
	public TreeNode2(int data)
	{
		this.root=data;
		this.left=null;
		this.right=null;
	}
	
	public void insertChild(int data)
	{
		
	}
	
	public void print(TreeNode tree)
	{
		if(tree==null)
		{
			return;
		}
		System.out.println(tree.root);
		print(tree.left);
		print(tree.right);
	}

}
