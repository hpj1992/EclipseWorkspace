package leetcode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1,2,1};
		System.out.println("Total Maximum Possible Weight:"+getMaxWeight(heights));
		
	}
	
	public static int getMaxWeight(int[] heights)
	{
		int max = 0;
		int[] maxRightSide = new int[heights.length];
		for(int i= heights.length - 1;i>=0;i--)
		{
			if(heights[i]>max)
			{
				max = heights[i];
			}
			maxRightSide[i] = max;
				
		}
		int maxLeft = heights[0];
		int maxWeight = 0;
		int curWeight = 0;
		for(int i=1;i<heights.length;i++)
		{
			curWeight+=Math.min(maxLeft, maxRightSide[i]);
			if(heights[i] == maxRightSide[i])
			{
				if(maxWeight < curWeight)
					maxWeight = curWeight;
				
				curWeight = 0;
			}
			maxLeft = Math.max(heights[i], maxLeft);
		}
		if(curWeight > maxWeight)
			maxWeight = curWeight;
		return maxWeight;
	}
	
	

}
