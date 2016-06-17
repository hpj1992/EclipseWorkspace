package leetcode.Easy;

import java.util.HashMap;

public class MajorityElement {

	public static int getMajorityElement(int[] nums)
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++)
		{
			int value;
			if(map.containsKey(nums[i]))
			{
				value = map.get(nums[i])+1;
				
			}
			else
			{
				value = 1;
			}
			if(value > nums.length/2)
					return nums[i];
			map.put(nums[i], value);
		}
		return -1;
			
	}
}
