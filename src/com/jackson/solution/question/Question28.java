package com.jackson.solution.question;

import org.junit.Test;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */
public class Question28 {
    public int strStr(String haystack, String needle) {
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();

        int[] next = new int[needle.length()];

        int i = 0;
        int j = -1;
        next[i] = j;
         while (i<needle.length()-1) {
             if (j == -1 || needleCharArray[i]==needleCharArray[j]) {
                 i++;
                 j++;
                 next[i] = j;
             } else {
                j = next[j];
             }
         }

         i = 0;
         j = 0;
         while (i <haystack.length() && j < needle.length()) {
             if (j==-1 || haystackCharArray[i]==needleCharArray[j]) {
                 i++;
                 j++;
             } else {
                 j = next[j];
             }
         }

         if (j == needle.length()) {
             return i-j;
         } else return -1;

    }

    @Test
    public void test() {
        System.out.println(strStr("sadbutsad", "sad"));
    }
}
