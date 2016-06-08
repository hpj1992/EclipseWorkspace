package CTCI_8;

import java.util.Arrays;

public class StairsCount {
	
	//Child can hop 1,2 and 3 steps. Count total number of possible steps to reach Nth step.

	public static void main(String[] args)
	{
		int N = 2;
		System.out.println("Total no of possible steps : "+ countWays(N));
	}
	
	public static int countWays(int total)
	{
		int[] memoTable = new int[total+1];
		Arrays.fill(memoTable, -1);
		return countWays(total,memoTable);
	}
	
	public static int countWays(int count, int[] memoTable)
	{
		if(count < 0)
			return 0;
		else if(count == 0)
			return 1;
		else if( memoTable[count] > -1)
			return memoTable[count];
		else
		{
			memoTable[count] = countWays(count-1,memoTable) + countWays(count-2,memoTable) + countWays(count-3,memoTable);
			return memoTable[count];
		}
	}
	
	// DP Technique: Memoization.
	//This is bottom up approach. We first formed base conditions values and it was used subsequently. Time complexity : O(N*3) , 3 because we only had 3 options to hop.If boy can hope J steps at a time, complexity would be O(N*J).
	//In case of Top Down recursive approach complexity would be O(3^N) because multiple values would be computed even though it was computed earlier. We used memoization to optimize this and use the values already computed.
	
	
	//Twists:
	/*
	 *  1)What is kth steps is broken ?
		2)Find total count and also print the series of steps.
		
		Ans1: Just add base condition along withelse if. It simply menas that you can not reach Nth steps from there. else if(count==k) return 0;*/
	
}
