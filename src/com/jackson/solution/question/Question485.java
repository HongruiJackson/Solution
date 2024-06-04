package com.jackson.solution.question;

import org.junit.Test;

/**
 * 485. 最大连续 1 的个数
 * https://leetcode.cn/problems/max-consecutive-ones/description/
 */
public class Question485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ) {
            int start = i;
            while (start < nums.length && nums[start] != 1) start++;
            i = start;
            while (i < nums.length && nums[i] != 0) i++;
            if (i-start > max) max = i-start;
        }
        return max;
    }

    @Test
    public void test() {
        int[] ints = {1, 1, 0, 1, 1, 1};
        findMaxConsecutiveOnes(ints);
    }
}
