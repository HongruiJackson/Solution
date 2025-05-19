package com.jackson.solution.dp;

// 1137. 第 N 个泰波那契数
// https://leetcode.cn/problems/n-th-tribonacci-number/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp015 {
    // 这道题和斐波那契数列是一个道理
    public int tribonacci(int n) {
        int mod = n%3;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 1;
        for (int i =3; i<n+1; i++) {
            dp[i%3] = dp[0]+dp[1]+dp[2];
        }

        return dp[mod];
    }

}
