package leetcode;

public class BuyAndSellStocks1 {
	public static void main(String[] args) {
		int[] stocks = { 1, 2, 4 };
		System.out.println(getMaxProfit(stocks));
	}

	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 */
	public static int getMaxProfit(int[] values) {
		// We are allowed to compute only one transaction. So we will find min
		// and max value and will return the differrence.
		if (values == null || values.length <= 1)
			return 0;
		int min = values[0];
		int profit = 0;
		for (int i = 1; i < values.length; i++) {
			profit = Math.max(profit, values[i] - min);
			min = Math.min(min, values[i]);
		}
		return profit;
	}

}
