package com.jackson.solution.dp;

// 面试题 16.17. 连续数列
// https://leetcode.cn/problems/contiguous-sequence-lcci/?envType=problem-list-v2&envId=dynamic-programming
public class dp007 {

    public int maxSubArray(int[] nums) {
        // 判断最大值，是用不含自己的子数列的最大值加上自己，与自己进行比较
        int numLength = nums.length;
        int maxFront = nums[0];
        int maxFinal = nums[0];
        for(int i=1; i<numLength; i++) {
            maxFront = Math.max(maxFront+nums[i],nums[i]);
            maxFinal = Math.max(maxFinal, maxFront);
        }
        return maxFinal;

    }

}
