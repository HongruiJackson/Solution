package com.jackson.solution.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 151. 反转字符串的单词
 */
public class Question151 {

    public String reverseWords(String s) {
        Pattern compile = Pattern.compile("\\S+");
        Matcher matcher = compile.matcher(s);
        ArrayList<String> stringArrayList = new ArrayList<>();
        while (matcher.find()) {
            stringArrayList.add(matcher.group());
        }
        Collections.reverse(stringArrayList);
        return String.join(" ", stringArrayList);
    }

    @Test
    public void test() {
        String s =  "  hello world  ";
        System.out.println(reverseWords(s));


    }
}
