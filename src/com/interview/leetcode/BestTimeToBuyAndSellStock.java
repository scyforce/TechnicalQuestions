package com.interview.leetcode;

/**

	Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction 
	
	(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 * @author shuchun.yang
 *
 */
public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = {2,3,4,5};
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		System.out.println(b.maxProfit(prices));
	}
	
	
	public int maxProfit(int[] prices) {
		if (prices==null || prices.length<2) {
            return 0;
        }
        
        int lower = prices[0];
        int profit = 0;
        for (int i=1; i<prices.length; i++) {
            lower = Math.min(lower, prices[i]);
            profit = Math.max(profit, prices[i]-lower);
        }
        return profit;
	}
}
