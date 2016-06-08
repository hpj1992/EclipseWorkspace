package Amazon;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
