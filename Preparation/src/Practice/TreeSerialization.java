package Practice;


/* 1
   / \
  2   3
     / \
    4   5
    */
//12..34..5..
public class TreeSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		/*TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		c.right = e;
		c.left = d;	*/
		a.right = c;
		a.left = b;
		TreeSerialization ser = new TreeSerialization();
		ser.printNode(a);
		System.out.println(ser.getSerialized(a, new StringBuilder()).toString());
		
		TreeNode res = ser.deserialize(new StringBuilder("12..3.."));
		ser.printNode(res);
	}
	
	public StringBuilder getSerialized(TreeNode node,StringBuilder sb)
	{
		if(node ==null)
			return sb.append(".");
		sb.append(node.value);
		sb = getSerialized(node.left, sb);
		sb = getSerialized(node.right, sb);
		return sb;
	}
	
	public TreeNode deserialize(StringBuilder sb)
	{
		if(sb == null)
			return null;
		if(sb.charAt(0) == '.')
			return null;
		else 
		{
			int value = Character.getNumericValue((sb.charAt(0)));
			TreeNode node = new TreeNode(value);
			node.left = deserialize(sb.deleteCharAt(0));
			node.right = deserialize(sb.deleteCharAt(0));
			return node;
		}
	}
	
	public void printNode(TreeNode node)
	{
		if(node ==null)
		{
			//System.out.print(".");
			return;
		}
		System.out.print(node.value + " ");
		printNode(node.left);
		printNode(node.right);
	}
	
}

class TreeNode
{
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val)
	{
		value = val;
		left = null;
		right = null;
	}
	
}