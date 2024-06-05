package com.jackson.solution.question;

import org.junit.Test;

/**
 * 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 */
public class Question209 {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;

        int min = Integer.MAX_VALUE;
        int left = 0; int right = 0;
        int sum = 0;

        while (right < length) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }

        return min==Integer.MAX_VALUE?0:min;


    }

    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    @Test
    public void test() {
        int[] ints = {2,3,5,9};
        System.out.println(minSubArrayLen2(7, ints));
    }
}
