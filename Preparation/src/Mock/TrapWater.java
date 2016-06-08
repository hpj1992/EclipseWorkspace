package Mock;

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
  			  5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
/*class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}*/

public class TrapWater {

	public static void main(String[] args) {
		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(new TrapWater().trap(heights));

	}

	public int trap(int[] height) {

		int[] rightMax = new int[height.length];
		int max = Integer.MIN_VALUE;
		for(int i=height.length-1;i>=0;i--)
		{
			if(max < height[i])
				max =height[i];
			
			rightMax[i] = max;
		}
		
		printArray(rightMax);
		int leftMax = 0;
		int total = 0;
		for(int i=0;i<height.length;i++)
		{
			total = total + Math.max((Math.min(leftMax, rightMax[i]) - height[i]),0);
			leftMax = Math.max(leftMax, height[i]);
		}
		
		return total;
	}
	
	public static void printArray(int[] array)
	{
		for(int i:array)
		{
			System.out.print(i+" ");
		}
	}
}
