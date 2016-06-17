package leetcode.Medium;
/*Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

public class SingleNumber3 {

	public static int[] getTwoDistinctNumber(int[] problem)
	{
		int diff = 0;
		for(int num:problem)
			diff = diff ^ num;
		
		// At this point we have XORed all the numbers. So all the numbers which are repeating already got removed. And two distint numbers got XORed which is stored in diff currently.
		// So there is a possibility that two distinct number differ in more that 1 bit. In that case we have to select rightmost bit and we can assure
		// this thing by doing below bit operation. And if it is differring by more that 1 bit, in that case also below operation will give correct value.
		diff = diff ^ (diff-1);
		
		/*
		 * if diff = 10101 then diff = 10101 ^ 10100 = 00001
		 * if diff = 1111 then diff = 1111 ^ 1110 = 0001 , when two numbers in more that 1 bits
		 * Lets call this position where bit is set as I
		 */
		
		//Now we will create two set of numbers . One set where this ith position is SET and in other NOT SET.
		// For each set we will again XOR each number. As a result we will have one distinct numbers in each set left which is our answer.
		int[] ans = new int[2];
		for(int num:problem)
		{
			if((diff & num) == 0)
			{
				// ith bit in num is also not set
				ans[0] = ans[0] ^ num;
			}
			else
			{
				//ith bit in number is set
				ans[1] = ans[1] ^ num;
				
			}
		}
		return ans;
		
	}
}
