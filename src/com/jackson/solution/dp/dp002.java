package com.jackson.solution.dp;

import java.util.ArrayList;
import java.util.List;

// 118. 杨辉三角
// https://leetcode.cn/problems/pascals-triangle/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp002 {

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> wholeList = new ArrayList<>();
        int[][] ints = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            integerArrayList.add(1);
            ints[i][0] = 1;
            for (int j = 1; j < i; j++) {
                integerArrayList.add(ints[i-1][j]+ints[i-1][j-1]);
            }
            integerArrayList.add(1);
            ints[i][i] = 1;
            wholeList.add(integerArrayList);
        }

        return wholeList;
    }

}
