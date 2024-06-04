package com.jackson.solution.question;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/description/
 */
public class Question27 {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        int length = nums.length;
        for (;fast < length ; fast++) {
            // 如过fast指针所在位置的值不等于val，就将其移动到慢指针的位置
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;

    }


}
