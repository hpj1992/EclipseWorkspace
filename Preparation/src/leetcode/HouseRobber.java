package leetcode;

/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

	public static void main(String[] args)
	{
		int[] test = {8,6,1,6,1,6,1,1,1,1};
		System.out.println(getMaxCount(test, 0));
		System.out.println(getMaxCountDP(test));
	}
	
	public static int getMaxCount(int[] amounts,int from)
	{
		//NO DP
		int sum=0;
		if(amounts.length==0 || from >=amounts.length)
			return 0;
		else
		{
			int a = amounts[from] + getMaxCount(amounts, from+2);
			int b = getMaxCount(amounts, from+1);
			return Math.max(a, b);
		}
	}
	
	public static int getMaxCountDP(int[] amounts)
	{
		//With DP
		if(amounts.length >= 1)
		{
			if(amounts.length == 1)
				return amounts[0];
			
			int[] sp = new int[amounts.length];
			sp[0] = amounts[0];
			sp[1] = Math.max(amounts[1], sp[0]);
			for(int i=2;i<amounts.length;i++)
			{
				sp[i] = Math.max(amounts[i]+sp[i-2], sp[i-1]);
			}
			return sp[amounts.length-1];
		}
		else
		{
			return 0;
		}
		
	}
}
