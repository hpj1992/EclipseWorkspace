package leetcode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class ContainsDuplicate3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		// 1,2,3,4,5,6
		if(nums.length <= 1)
			return false;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(nums[0], 1);
		for(int i=1;i<nums.length;i++)
		{
			for(int j:map.keySet())
			{
				if(Math.abs(nums[i] - j) <= t && Math.abs(i-map.get(j)) <= k)
				{
					return true;
				}
			}
			if(!map.containsKey(nums[i]))
			map.put(nums[i],i);
		}
		return false;
	}
	
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
	}
}
 