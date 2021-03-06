package leetcode.Medium;

import java.util.HashMap;

class Solution {

	public static void main(String[] args) {
		int[] que = { 2, 7, 11, 15 };
		int[] ans = twoSum(que, 9);
		for (int i : ans)
			System.out.print(i + " ");

	}

	public static int[] twoSum(int[] nums, int target) {
	    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    for(int i = 0; i < nums.length; i++){
	        int key = target - nums[i];
	        if(hm.containsKey(key)){
	            return new int[]{hm.get(key) + 1, i + 1};
	        }
	        hm.put(nums[i], i);
	    }
	    return new int[]{0 , 0};
	}
}