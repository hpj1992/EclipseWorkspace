package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {

	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6};
		System.out.println(containsDuplicate(arr));
	}
	public static boolean containsDuplicate(int[] arr)
	{
		if(arr.length == 0)
			return false;
		
		long vector = 0;
		for(int i:arr)
		{
			if((vector & (1 << i)) > 0)
				return true;
			else
				vector = vector | (1 << i);
		}
		return false;
		
	}
	
	public static boolean checkDuplicate(int[] arr)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:arr)
		{
			if(!set.add(i))
				return true;
		}
		return false;
	}
}
