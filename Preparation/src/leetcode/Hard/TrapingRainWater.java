package leetcode.Hard;

public clas TrapingRainWater
{
public int trap(int[] height) {

		int[] rightMax = new int[height.length];
		int max = Integer.MIN_VALUE;
		for(int i=height.length-1;i>=0;i--)
		{
			if(max < height[i])
				max =height[i];
			
			rightMax[i] = max;
		}
		int leftMax = 0;
		int total = 0;
		for(int i=0;i<height.length;i++)
		{
			total = total + Math.max((Math.min(leftMax, rightMax[i]) - height[i]),0);
			leftMax = Math.max(leftMax, height[i]);
		}
		
		return total;
	}
    }