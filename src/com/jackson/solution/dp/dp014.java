package com.jackson.solution.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 509. 斐波那契数
// https://leetcode.cn/problems/fibonacci-number/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp014 {
    public int fib(int n) {
        // 运用模运算节省空间
        int[] dp = new int[2];
        dp[1] = 1;
        for(int i = 2; i<n+1; i++) {
            dp[i%2] = dp[0]+dp[1];
        }
        return dp[n%2];
    }

}
