package com.jackson.solution.question;
/**
 * 1991. 找到数组的中间位置
 * https://leetcode.cn/problems/find-the-middle-index-in-array/
 */
public class Question1991 {
    // 主要是这个定义比较关键，middleIndex是前面的值和等于后面的值和，故应该比较的是index前的值和后面的值
    // 关键就在于如何求出前后面的值
    // 先得到整体的和，再利用减去index-1及前的值就可以得到划分出来的和
    public  int findMiddleIndex(int[] nums) {

        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum +=num;
        } // 求出所有的和
        int leftnum = 0;
        // 然后依次相减
        for(int i = 0; i < length; i++) {
            sum = sum-nums[i]; // 从索引0开始，初始就是减去0之前的值
            if (leftnum == sum) return i;
            else leftnum+=nums[i];
        }
        return -1;

    }
}
