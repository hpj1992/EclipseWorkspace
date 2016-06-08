package leetcode;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.

   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class ClimbingStairs {

	public static void main(String[] args)
	{
		
	}
	
	public static int getCount(int total)
	{
		if(total == 0 || total ==1)
			return 1;
		
		int[] ans = new int[total];
		
		for(int i=2;i<total;i++)
		{
			ans[i] = ans[i-1] + ans[i-2];
		}
		
		return ans[total-1];
			
	}
}
