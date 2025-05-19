package com.jackson.solution.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2900. 最长相邻不相等子序列 I
// https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-i/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp013 {
    // 这道题动态规划没有做出来，这里是官方的题解，自己用了贪心的方式去做
    // public List<String> getLongestSubsequence(String[] words, int[] groups) {
    //        List<String> ans = new ArrayList();
    //        ans.add(words[0]);
    //        for(int i = 1; i < groups.length; i++) {
    //            if(groups[i-1] != groups[i]) {
    //                ans.add(words[i]);
    //            }
    //        }
    //        return ans;
    //    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        // 动态规划定义状态：
        //dp[i]表示以第i个元素结尾的最长满足条件的子序列长度。
        //prev[i]记录在最长子序列中，第i个元素的前一个元素下标
        int[] dp = new int[n];
        int[] prev = new int[n];
        int maxLen = 1, endIndex = 0;

        // 初始化：
        //每个元素自身构成长度为1的子序列，因此dp[i]初始化为1。
        //prev[i]初始化为-1，表示没有前驱。
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            int bestLen = 1;
            int bestPrev = -1;
            for (int j = i - 1; j >= 0; j--) {
                // 对于每个元素i，遍历其之前的所有元素j（从i-1到0）。
                //如果groups[i] != groups[j]，则检查是否可以将i接在j的子序列后面，即比较dp[j] + 1是否大于当前记录的dp[i]。
                if (groups[i] != groups[j] && dp[j] + 1 > bestLen) {
                    // 更新dp[i]为最大值，并记录对应的前驱j到prev[i]。
                    bestLen = dp[j] + 1;
                    bestPrev = j;
                }
            }
            dp[i] = bestLen;
            prev[i] = bestPrev;
            // 在遍历过程中，维护maxLen和endIndex，分别表示最长子序列的长度及其末尾下标。
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = endIndex; i != -1; i = prev[i]) {
            res.add(words[i]);
        }
        Collections.reverse(res);
        return res;
    }

}
