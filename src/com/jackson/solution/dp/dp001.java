package com.jackson.solution.dp;

// 70. 爬楼梯
// https://leetcode.cn/problems/climbing-stairs/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp001 {

    public int climbStairs(int n) {
        // 每次只能1阶或2阶进行爬楼梯
        // 当我只有1阶楼梯的时候，我只有一种方式爬楼梯，就是用1阶的方式f(1)=1
        // 当我有2阶楼梯的时候，我有两种方式进行爬楼梯，即1+1或者2 f(2)=2
        // 当我与有三阶楼梯的时候，我可以回退一步，注意是最后一步
        // 即我有可能是从第2阶楼梯爬上来的，又或者是从第1阶楼梯爬上来的
        // 所以：3阶应该是 f(3) = f(2)+f(1)
        int[] dp = new int[n];
        int start = 1;
        for (int i = 0; (i< 2) && (i<n); i++) {
            dp[i] = start++;
        }
        for (int i = 2 ; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];

        // 内存可以优化，因为只用到了两个值
    }

}
