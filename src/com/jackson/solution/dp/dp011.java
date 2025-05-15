package com.jackson.solution.dp;

// LCS 01. 下载插件
// https://leetcode.cn/problems/Ju9Xwi/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp011 {

    public int leastMinutes(int n) {
        // 贪心的策略：当插件的数量大于当前下载的速度时，速度翻倍
        int wide = 1;
        int time = 0;
        while(wide < n) {
            wide = wide * 2;
            time++;
        }
        return time+1;
    }

}
