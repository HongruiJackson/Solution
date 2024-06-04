package com.jackson.solution.question;

import java.util.Arrays;

/**
 * 561. 数组拆分
 * https://leetcode.cn/problems/array-partition/
 */
public class Question561 {

    public int arrayPairSum(int[] nums) {
        int total = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i+=2) {
            total+=nums[i];
        }
        return total;
    }
}
