package leetcode.Medium;

public class CountingBits {

	public static int[] getBitscount(int number)
	{
		int[] ans = new int[number+1];
		for(int i=0;i<number;i++)
		{
			ans[i] = ans[i/2] + (i&1);
		}
		return ans;
	}
}
