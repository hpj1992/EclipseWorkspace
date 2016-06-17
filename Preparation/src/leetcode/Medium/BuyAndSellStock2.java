package leetcode.Medium;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class BuyAndSellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getMaxProfit2(int[] values) {
		// He are allowed to engage in multiple transactions but we can not do
		// it at the same time. In previous we were allowed to computer only one
		// transaction.
		// So we need to change the logic.
		// Logic is find all the increasing sequence in array.Get the diff of
		// max and min in that sequences. And do the summ of all the diffs.It
		// will be an answer.
		if (values == null || values.length <= 1)
			return 0;
		int profit = 0;
		int left = 0;
		int i = 0;
		for (i = 0; i < values.length - 1; i++) {
			if (values[i + 1] < values[i]) {
				// beginning of new sequence. ith element would be last element
				// of the previous sequence.
				profit += values[i] - values[left];
				left = i + 1;
			}
		}
		profit += values[i] - values[left];
		return profit;
	}

}
