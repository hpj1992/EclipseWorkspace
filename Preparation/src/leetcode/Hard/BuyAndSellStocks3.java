package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
Follow this : http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/

 */
public class BuyAndSellStocks3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stocks = { 1,2,4,2,5,7,2,4,9,0 };
		System.out.println(getMaxProfit3(stocks));
	}

	public static int getMaxProfit3(int[] values) {
		//Here we can not apply the same log as previous problems. We can execute transactions only twice.
		// So logc would be to find mximum profit starting from both the ends. And maintain two array for that.
		//Each value in that array will represtn max sum in left and right direction accordingly.
		int[] left= new int[values.length];
		int[] right = new int[values.length];
		
		int min = values[0];
		int i = 0;
		for(i=1;i<values.length - 1;i++)
		{
			min = Math.min(min, values[i]);
			left[i] = Math.max(left[i-1], values[i] - min);
		}
		
		int max = values[values.length-1];
		for(i=values.length-2;i>=0;i--)
		{
			max = Math.max(max, values[i]);
			right[i] = Math.max(right[i+1], max - values[i]);
		}
		int profit = 0;
		for(i=0;i<left.length;i++)
		{
			profit = Math.max(profit, left[i] + right[i]);
		}
		return profit;
	}
}

