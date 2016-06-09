package leetcode;

public class SearchInRotatedSortedArray {

	public static void main(String[] args)
	{
		int[] arr = {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(getIndex(arr,0,arr.length-1,5));
	}
	
	public static int getIndex(int[] arr, int left, int right, int toSearch)
	{
		int mid = (left + right ) / 2;
		
		if(arr.length == 0)
			return 0;
		
		if(toSearch == arr[mid])
			return mid;
		
		if(right < left)
			return -1;
		
		if(arr[left] < arr[mid])
		{
			if(toSearch < arr[mid] && toSearch >= arr[left])
			{
				return getIndex(arr,left,mid-1,toSearch); // Search left
			}
			else
			{
				return getIndex(arr,mid+1,right,toSearch); // Search right
			}
		}
		else if(arr[left] > arr[mid])
		{
			if(toSearch > arr[mid] && toSearch <= arr[right])
			{
				return getIndex(arr,mid+1,right,toSearch); // Search right
			}
			else
			{
				return getIndex(arr,left,mid-1,toSearch); // Search left
			}
		}
		else if(arr[left] == arr[mid])
		{
			// When we have duplicateds
			if(arr[mid] != arr[right])
			{
				return getIndex(arr, mid+1, right, toSearch);
			}
		}
		return -1;
	}
}
