package Mock;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class PathSum {
	 public boolean hasPathSum(TreeNode root, int sum) {
	        if(root == null)
	            return false;
	            
	        if(root.val == sum)
	            return true;
	            
	        return isContainsSum(root,sum);
	        
	    }
	    
	    public static boolean isContainsSum(TreeNode root,int sum)
	    {
	        if(root == null || sum < 0)
	            return false;
	        
	        if(root.left == null && root.right == null && root.val == sum)
	        {
	            return true;
	        }
	        else
	        {
	            return ( isContainsSum(root.left,sum-root.val) || isContainsSum(root.right, sum-root.val));
	        }
	    }
}
