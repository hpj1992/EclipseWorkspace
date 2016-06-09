package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> unique = new HashSet<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums1 != null && nums2 != null && nums1.length > 0 && nums2.length > 0)
        {
        	for(int i=0;i<nums1.length;i++)
        		unique.add(nums1[i]);
        	for(int i=0;i<nums2.length;i++)
        	{
        		if(unique.contains(nums2[i]) && !result.contains(nums2[i]))
        		{
        			result.add(nums2[i]);
        		}
        	}
        	
        	int[] toReturn = new int[result.size()];
        	for(int i=0;i<result.size();i++)
        	{
        		toReturn[i] = result.get(i);
        	}
        	return toReturn;
        	
        }
        return new int[0];
    }
}
