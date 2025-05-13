package com.jackson.solution.dp;

// 121. 买卖股票的最佳时机
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=problem-list-v2&envId=dynamic-programming
public class dp004 {

    public int maxProfit(int[] prices) {
        // 当天的最高利润，为当天的价格减去前面几天的最小价格
        // 不用算第一天的情况
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i<prices.length; i++) {
            if(prices[i] > minPrice) {
                maxProfit = Math.max(prices[i]-minPrice, maxProfit);
            }
            else {
                minPrice = prices[i];
            }

        }

        return maxProfit;

    }

}
