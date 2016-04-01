package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public static void main(String[] args) {
		int[] que = { 2, 7, 11, 15 };
		int[] ans = twoSum(que, 9);
		for (int i : ans)
			System.out.print(i + " ");

	}

	static int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		ArrayList<Integer> list = new ArrayList<Integer>(nums.length);
		for (int i : nums)
			list.add(i);
		for (int i = 0; i < list.size(); i++) {
			int cur = list.get(i);
			int toSearch = target - cur;

			List<Integer> temp = list.subList(i + 1, list.size());

			if (temp.contains(toSearch)) {
				ans[0] = i;
				ans[1] = temp.indexOf(toSearch) + i + 1;
				break;
			}

		}

		return ans;
	}
}