package com.jackson.solution.question;

/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
public class Question5 {
    public String longestPalindrome(String s) {
        // 获取字符串长度
        int len = s.length();

        // 记录最长回文子串的头和长度
        int begin = 0;
        int maxLen = 1;

        // 转换为字符数组
        char[] charArray = s.toCharArray();

        // dp bool数组
        boolean [][] dp = new boolean[len][len];
        // 长度为1认为是回文子串
        for (int i = 0; i<len;i++) {
            dp[i][i] = true;
        }


        // 回文串长度的for
        for (int L = 2; L <= len;L++) {
            // 回文串的起始位置for
            for (int start = 0; start < len; start++) {
                // 回文串的末尾的索引位置
                int end = start + L -1;

                // 右边界越界，则退出本次循环
                if (end >= len) {
                    break;
                }

                // 当头尾相等的时候
                if (charArray[start] != charArray[end]) {
                    dp[start][end] = false;
                } else {
                    if (L <= 3) { // 当长度小于等于3时，看头尾就可以知道是否为回文串
                        dp[start][end] = true;
                    } else { // 大于3看子串
                        dp[start][end] = dp[start+1][end-1];
                    }
                }

                // 记录回文的起始和长度
                if (dp[start][end] && end-start+1 >maxLen) {
                    begin = start;
                    maxLen = end-start+1;
                }


            }
        }


        return s.substring(begin,begin+maxLen);

    }
}
