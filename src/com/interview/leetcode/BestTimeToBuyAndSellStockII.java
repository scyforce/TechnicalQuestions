package com.interview.leetcode;

/**

	Say you have an array for which the ith element is the price of a given stock on day i.
	
	Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
	However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 * @author shuchun.yang
 *
 */
public class BestTimeToBuyAndSellStockII {
	public static void main(String[] args) {
		int[] prices = {2,1,4,3,20};
		BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
		System.out.println(b.maxProfitII(prices));
	}
	
	public int maxProfitII(int[] prices) {
		//input prices must have more than one value
	    if (prices==null || prices.length<2) {
            return 0;
        }
        int maxProfit = 0;
        int previous = prices[0];
        for (int i=1; i<prices.length; i++) {
            int delta = prices[i]-previous;
            if (delta>0) {
                maxProfit += delta;
            }
            previous = prices[i];
        }
        return maxProfit;
    }
}
