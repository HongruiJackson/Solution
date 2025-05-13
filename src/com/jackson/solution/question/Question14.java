package com.jackson.solution.question;

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/description/
 */
public class Question14 {
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = 200;
        for (int i = 0; i<strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        int index = -1;
        for (int j = 0; j < minLength; j++) {
            char character = strs[0].charAt(j);
            int flag = 0;
            for(int i = 1; i<strs.length; i++) {
                if (strs[i].charAt(j) != character) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                index = j;
            } else {
                break;
            }
        }

        if (index == 0) {
            return "";
        }
        return strs[0].substring(0,index+1);

//        int min = 300;
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String str : strs) {
//            if (str.length() < min) min = str.length();
//        }
//        // 利用最短的长度
//        for (int i = 0;i<min;i++) {
//            char eqCh = strs[0].charAt(i);
//            int flag = 1;
//            for (int j = 1; j<strs.length;j++) {
//                if (strs[j].charAt(i) != eqCh) {
//                    flag = 0;
//                    break;
//                }
//            }
//            if (flag == 1) stringBuilder.append(eqCh);
//            else break;
//        }
//        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"ab", "a"};
        String string = longestCommonPrefix(strings);
    }
}

