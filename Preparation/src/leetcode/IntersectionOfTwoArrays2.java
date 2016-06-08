package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = {1,2,2,1};
		int[] two = {2,2};
		for(int a: intersection(one,two))
		{
			System.out.print(a+" ");
		}
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer,Integer> unique = new HashMap<Integer,Integer>();
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
        if(nums1 != null && nums2 != null && nums1.length > 0 && nums2.length > 0)
        {
        	for(int i=0;i<nums1.length;i++)
        		arr1.add(nums1[i]);
        	for(int i=0;i<nums2.length;i++)
        	{
        		if(arr1.contains(nums2[i]))
        		{
        			if(unique.containsKey(nums2[i]))
        			{
        				unique.put(nums2[i],unique.get(nums2[i])+1);
        			}
        			else
        			{
        				unique.put(nums2[i], 1);
        			}
        			arr1.remove(nums2[i]);
        			
        		}
        		
        	}
        	ArrayList<Integer> ans = new ArrayList<Integer>();
        	for(Integer key:unique.keySet())
        	{
        		for(int i=0;i<unique.get(key);i++)
        		{
        			ans.add(key);
        		}
        	}
        	
        	int[] ans2 = new int[ans.size()];
        	for(int i=0;i<ans2.length;i++)
        	{
        		ans2[i] = ans.get(i);
        	}
        	return ans2;
        	
        }
        return new int[0];
    }
}

