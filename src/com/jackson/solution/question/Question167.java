package com.jackson.solution.question;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class Question167 {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int end = numbers.length-1;
        int total = 0;
        while (front < end) {
            total = numbers[front]+numbers[end];
            if ( total == target) break;
            else if (total > target) end--;
            else front++;
        }
        return new int[] {front+1,end+1};
    }
}
