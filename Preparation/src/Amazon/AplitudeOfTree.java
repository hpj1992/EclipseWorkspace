package Amazon;

public class AplitudeOfTree {
/*
 *     5
       /   \
    8        9
   /  \     /  \ 
12   2  	8   4
          /    /
        2    5
 */
	public static void main(String[] args)
	{
	
		
	}
	
	public static int GetAmplitude(TreeNode root,int min,int max)
	{
		if(root == null)
		{
			return max-min;
		}
		else
		{
			if(root.val > max)
				max = root.val;
			if(root.val < min)
				min = root.val;
			int fromLeft = GetAmplitude(root.left, min, max);
			int fromRight = GetAmplitude(root.right, min, max);
			return Math.max(fromLeft, fromRight);
		}
		
	}
}
