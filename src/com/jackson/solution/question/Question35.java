package com.jackson.solution.question;

/**
 * 35. 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/description/
 */
public class Question35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low<=high) {
            mid = (low+high)/2;
            if (nums[mid]== target) return mid;
            else if(nums[mid] <target) low = mid +1;
            else high = mid -1;
        }
        return low;
    }
}
