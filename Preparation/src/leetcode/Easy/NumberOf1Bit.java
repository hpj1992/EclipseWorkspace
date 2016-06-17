package leetcode.Easy;

public class NumberOf1Bit {

	public static int getNumberOf1Bit(int number)
	{
		int ans = 0;
		while(number != 0)
		{
			ans = ans + (number & 1);
			number = number>>>1;
		}
		return ans;
	}
}
