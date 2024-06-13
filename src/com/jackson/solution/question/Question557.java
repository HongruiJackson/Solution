package com.jackson.solution.question;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * 557.反转字符串中的单词III
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */
public class Question557 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        List<String> list = new java.util.ArrayList<>(Arrays.stream(strings).map(string -> new StringBuffer(string).reverse().toString()).toList());
        StringJoiner stringJoiner = new StringJoiner(" ");
        list.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }

    @Test
    public void test() {
        String string = "Let's take LeetCode contest";
        System.out.println(reverseWords(string));
    }
}
