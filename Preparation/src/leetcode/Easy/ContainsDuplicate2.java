package leetcode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean containsNearbyDuplicate(int[] arr, int k) {
        if( arr != null && arr.length != 0)
		{
			HashMap<Integer,Integer> indexes = new HashMap<Integer,Integer>();
			for(int i=0;i<arr.length;i++)
			{
				if(indexes.containsKey(arr[i]))
				{
					int last = indexes.get(arr[i]);
					if(Math.abs(last - i)  <= k)
						return true;
				}
				indexes.put(arr[i], i);
			}
			
		}
		else
		{
		return false;
		}
		return false;
        
    }
	public boolean containsNearbyDuplicateEfficient(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }

}
