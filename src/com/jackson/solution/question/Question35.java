package com.jackson.solution.question;

/**
 * 35. 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/description/
 */
public class Question35 {
    public int searchInsert(int[] nums, int target) {
        // 首先是要进行查找，有没有这个值
        int low = 0; //头部
        int high = nums.length-1; // 尾部位置
        int mid = 0; // 中间位置初始化
        while(low<=high) {
            mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) low = mid+1;
            else high = mid-1;
        }
        // 如果没有这个值的时候，该值的位置，为什么是low，因为当low==high的时候说明两个指针重合
        // 代表没有找到该值，而此时进入循环，很明显mid值是小于target的，此时就会移动low指针，即应该存在的位置
        return low;
    }
}
