package com.jackson.solution.question;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;

/**
 * 283.移动零
 * https://leetcode.cn/problems/move-zeroes/description/
 */
public class Question283 {
    public void moveZeroes(int[] nums) {
        // 数组长度
        int length = nums.length;
        // 快慢指针
        int slow=0,fast = 0;
        while (fast < nums.length-1) {
            fast++;
            if (nums[slow] != 0 && nums[fast] !=0){
                slow++;
            } else if (nums[slow] != 0 && nums[fast]==0) {
                slow = fast;
            } else if (nums[slow] == 0 && nums[fast] !=0) {
                int temp = nums[fast];
                nums[fast] = 0;
                nums[slow] = temp;
                slow++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    // 双指针的优化
    // 如果数组没有0，那么快慢指针始终指向同一个位置，每个位置自己和自己交换；如果数组有0，快指针先走一步，此时慢指针对应的就是0，所以要交换。
    public void moveZeroes2(int[] nums) {
        // 数组长度
        int length = nums.length;
        // 快慢指针
        int slow=0,fast = 0;
        while (fast < length) {
            if (nums[fast]!=0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test() {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
