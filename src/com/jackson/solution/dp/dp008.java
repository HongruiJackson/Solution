package com.jackson.solution.dp;

// 面试题 17.16. 按摩师
// https://leetcode.cn/problems/the-masseuse-lcci/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp008 {

    public int massage(int[] nums) {
        // 直接想dp我没有太想得出来，但是将递归的情况列出来，寻找之间的关系，再用dp就比较好解了
        int length = nums.length;
        if(length==0) {
            return 0;
        }
        if(length==1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[length-1] = nums[length-1];
        dp[length-2] = nums[length-2];

        for(int i=length-3; i >= 0; i--) {
            if(i==length-3){
                dp[i] = nums[i] + dp[i+2];
            } else {
                dp[i] = nums[i] + Math.max(dp[i+2], dp[i+3]);
            }
        }
        return Math.max(dp[0],dp[1]);

    }



// 递归解法会超时----------------------------------------------------------------
//    public int massage(int[] nums) {
//
//        int int1 = 0;
//        int int2 = 0;
//        if(nums.length > 0) {
//            int1 = maxTime(nums, 0);
//        }
//        if(nums.length > 1) {
//            int2 = maxTime(nums, 1);
//        }
//        return Math.max(int1, int2);
//    }
//
//    public int maxTime(int[] nums, int start) {
//        int current = nums[start];
//        int twoInt = 0;
//        int threeInt = 0;
//        if((start+2)<nums.length) {
//            twoInt = maxTime(nums, start+2);
//        }
//        if((start+3)<nums.length) {
//            threeInt = maxTime(nums, start+3);
//        }
//
//        return current + Math.max(twoInt, threeInt);
//    }

}
