package leetcode.Easy;

public class RemoveElement_27 {

	public static void main(String[] args)
	{
		
	}
	
	public static int removeElement(int[] nums,int val)
	{
		int swapped = 0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]!=val)
			{
				nums[swapped++] = nums[i];
			}
		}
		return swapped;
	}
}


