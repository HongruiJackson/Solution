package com.jackson.solution.question;

/**
 * 344. 反转字符串
 * https://leetcode.cn/problems/reverse-string/description/
 */
public class Question344 {
    public void reverseString(char[] s) {
        int end = s.length-1;
        int start = 0;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start--;
            end--;
        }
    }
}
