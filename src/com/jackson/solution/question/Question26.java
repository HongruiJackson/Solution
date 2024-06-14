package com.jackson.solution.question;

import org.junit.Test;

import java.util.Arrays;

/**
 * 26.删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 */
public class Question26 {
    public int removeDuplicates(int[] nums) {
        // 数组长度
        int length = nums.length;
        // 快慢指针
        int fast = 0;
        int slow = 0;
        while (fast < length-1) {
            fast++;
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
//        System.out.println(Arrays.toString(nums));
        return slow+1;
    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
