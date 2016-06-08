package leetcode;

public class SingleNumber {

	 public int singleNumber(int[] nums) {
	        int vector = 0;
			for(int i=0;i<nums.length;i++)
				vector = vector ^ nums[i];
			return vector;
	    }
}
