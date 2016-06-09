package leetcode;

public class RemoveDuplicated_26 {

	public static void main(String[] args) {
		int[] problem = { 1, 1 }; // 1,2,3,4 111,222,
		int[] ans = removeDuplicates(problem);
		// System.out.println(getLengthAfterRemovingDuplicates(problem));

	}

	public static int[] removeDuplicates(int[] nums) {
		if (nums.length < 2)
			return nums;

		int swapped = 1;

		for (int i = 1; i < nums.length; i++)
			if (nums[i - 1] < nums[i]) {
				nums[swapped] = nums[i];
				swapped++;
			}

		return nums;

	}

	public static int getLengthAfterRemovingDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		else {
			int prev = nums[0];
			int count = 1;
			int length = 1;
			for (int i = 1; i < nums.length; i++) {

				if (nums[i] == prev) {

				} else {
					length++;
					prev = nums[i];
				}
			}
			return length;
		}
	}
}
