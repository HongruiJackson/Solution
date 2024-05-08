package com.jackson.solution.question;
/**
 * 1991. 找到数组的中间位置
 * https://leetcode.cn/problems/find-the-middle-index-in-array/
 */
public class Question1991 {
    public  int findMiddleIndex(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i<length; i++) {
            sum += nums[i];
        }
        int leftsum = 0;
        for (int i = 0; i< length;i++) {
            sum = sum- nums[i]; // 右侧的值
            if(leftsum == sum) {
                return i;
            }
            else {
                leftsum += nums[i];
            }
        }
        return -1;
    }
}
