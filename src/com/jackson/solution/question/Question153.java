package com.jackson.solution.question;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class Question153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while (low < high) {
            mid = low + (high-low)/2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid +1;
            }
        }
        return nums[low];
    }
}
