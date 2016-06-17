package leetcode.Easy;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        else
        {
            sum = sum - root.val;
            if(root.left == null && root.right == null && sum == 0)
                return true;
            else
                return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
        }
    }

}
