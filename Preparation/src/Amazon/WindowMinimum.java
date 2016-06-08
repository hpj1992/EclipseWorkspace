package Amazon;

import java.util.ArrayDeque;
import java.util.Collections;

public class WindowMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prob = {4,2,11,12,-5};
		for(int i:getWindowMinimum(prob, 2))
		{
			System.out.println(i);
		}

	}
	
	public static int[] getWindowMinimum(int[] arr,int window)
	{
		if(arr == null || window > arr.length || window <= 0)
			return new int[0];
		
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		int[] ans = new int[arr.length - window + 1];
		int j = 0;
		for(int i=0;i<arr.length;i++)
		{
			while(q.size() > 0 && q.peek() < i - window + 1)
			{
				q.poll();
			}
			
			while(q.size() > 0 && arr[q.peek()] > arr[i])
			{
				q.pollLast();
			}
			
			q.add(i);
			if( i >= window - 1)
			{
				ans[j++] = arr[q.peek()];
			}
			
		}
		return ans;
	}
}
