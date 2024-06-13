package com.jackson.solution.question;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode.cn/problems/pascals-triangle/description/
 */
public class Question118 {

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> wholeList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j==0) integerArrayList.add(1);
                else integerArrayList.add(wholeList.get(i-1).get(j)+wholeList.get(i-1).get(j-1));
            }
            integerArrayList.add(1);
            wholeList.add(integerArrayList);
        }

        return wholeList;
    }
}
