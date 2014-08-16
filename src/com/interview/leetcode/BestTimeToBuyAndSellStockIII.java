package com.interview.leetcode;

/**

	Say you have an array for which the ith element is the price of a given stock on day i.
	
	Design an algorithm to find the maximum profit. You may complete at most two transactions.
	
	Note:
	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 * @author shuchun.yang
 *
 */
public class BestTimeToBuyAndSellStockIII {
	public static void main(String[] args) {
		int[] prices = {1,2,3,4,0,100,101};
		BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
		System.out.println(b.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
		if (prices==null||prices.length<2) {
			return 0;
		}
		
		//key idea: for each price of the day, divide into two range [0, i] and [i+1, n] then find out the maxProfit in this two range.
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		
		int lowestPrice = prices[0];
		for (int i=1; i<prices.length; i++) {
			lowestPrice = Math.min(lowestPrice, prices[i]);
			left[i] = Math.max(left[i-1], prices[i]-lowestPrice);
		}
		
		int highestPrice = prices[prices.length-1];
		for (int i=prices.length-2; i>=0; i--) {
			highestPrice = Math.max(highestPrice, prices[i]);
			right[i] = Math.max(right[i+1], highestPrice-prices[i]);
		}
		
		int maxProfit = 0;
		for (int i=0; i<prices.length; i++) {
			maxProfit = Math.max(maxProfit, left[i]+right[i]);
		}
		
		return maxProfit;		
	}
}
