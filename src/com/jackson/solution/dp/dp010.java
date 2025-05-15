package com.jackson.solution.dp;

// 746. 使用最小花费爬楼梯
// https://leetcode.cn/problems/min-cost-climbing-stairs/?envType=problem-list-v2&envId=dynamic-programming
public class dp010 {

    public int minCostClimbingStairs(int[] cost) {
        // 这道题跟按摩师那道题有点像
        // 首先需要明确的是，无论是什么方案，开销的结束都应该落在最后的索引n-1和n-2的位置
        // 当任一节点确认的时候，便可以得到前面情况
        // 从后往前推就可以用动态规划了

        // 题的条件->数组长度大于等于2
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        // 其他情况
        int[] dp = new int[cost.length];
        dp[cost.length-1] = cost[cost.length-1];
        dp[cost.length-2] = cost[cost.length-2];
        for(int i = cost.length-3; i >= 0; i--) {
            dp[i] = cost[i]+Math.min(dp[i+1],dp[i+2]);
        }

        // 返回0,1的最小值
        return Math.min(dp[0], dp[1]);
    }

}
