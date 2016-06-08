package leetcode;

import java.util.Arrays;

public class RangesumQuery {

	int[] sumFromZeroIndex = null;
	int[] o = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public RangesumQuery(int[] nums) {
		sumFromZeroIndex = nums;
		int sum = 0,index = 0;
		o = Arrays.copyOf(nums, nums.length);
		for(int i:nums)
		{
			sum +=i;
			sumFromZeroIndex[index++] = sum;
		}
	}

	public int sumRange(int i, int j) {
		return sumFromZeroIndex[j] - sumFromZeroIndex[i];
	}

}
