package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class LowestCommonElemt {

	public static void main(String[] args)
	{
		
	}
	
	public static int solution(int[] A, int[] B)
	{
		Arrays.sort(A);
		Arrays.sort(B);
		int i=0,j=0;
		while(i<A.length && j<B.length)
		{
			if(A[i] == B[i])
				return A[i];
			else if(A[i] < B[j])
				i++;
			else
				j++;
		}
		return -1;
		
	}
}
