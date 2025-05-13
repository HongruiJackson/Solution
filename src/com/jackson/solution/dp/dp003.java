package com.jackson.solution.dp;

import java.util.Arrays;
import java.util.List;

// 118. 杨辉三角 II
// https://leetcode.cn/problems/pascals-triangle-ii/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp003 {

    // 二项式与组合之间的关系
    public List<Integer> getRow(int rowIndex) {
        Integer[] ints = new Integer[rowIndex+1];
        ints[0] = 1;
        int mid = rowIndex/2;
        for (int i = 1; i <= mid; i++) {
            ints[i] = (int) ((long) ints[i-1] * (rowIndex-i+1) / i); // Integer空间不够
        }
        for (int i = mid+1; i <= rowIndex; i++) {
            ints[i] = ints[rowIndex-i]; // 二项式/杨辉三角的对称性，减少计算过程
        }
        return Arrays.asList(ints);
    }

}
