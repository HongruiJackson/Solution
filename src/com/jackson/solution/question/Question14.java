package com.jackson.solution.question;

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/description/
 */
public class Question14 {
    public String longestCommonPrefix(String[] strs) {
        int min = 300;
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            if (str.length() < min) min = str.length();
        }
        // 利用最短的长度
        for (int i = 0;i<min;i++) {
            char eqCh = strs[0].charAt(i);
            int flag = 1;
            for (int j = 1; j<strs.length;j++) {
                if (strs[j].charAt(i) != eqCh) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) stringBuilder.append(eqCh);
            else break;
        }
        return stringBuilder.toString();
    }
}

