package com.ll.Frequency_5;

/*
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
    	  if (prices.length == 0){
              return 0;
          }
          int min = prices[0];
          int maxProfit = 0;
          for (int i = 1; i < prices.length; i++){
        	  min = Math.min(min, prices[i]);
        	  maxProfit = Math.max(maxProfit, prices[i] - min);
          }
          
          return maxProfit;
    }
    
    
    public int maxProfit2(int[] prices) {
    	if (prices.length == 0){
    		return 0;
    	}
    	int maxProfit = 0;
    	for (int i = 1; i < prices.length; i++){
    		int different = prices[i] - prices[i - 1];
    		if (different > 0){
    			maxProfit += different;
    		}
    	}
    	return maxProfit;
    }
    
    
	public int maxProfit3(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		// find maxProfit from left to i
		int min = prices[0];
		left[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}

		// find maxProfit from right to i
		int max = prices[prices.length - 1];
		right[prices.length - 1] = 0;
		for (int i = prices.length - 2; i > 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}
		
		//get result
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(left[i] + right[i], profit);
		}

		return profit;

	}
    
}
