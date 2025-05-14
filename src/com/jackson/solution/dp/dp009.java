package com.jackson.solution.dp;

// LCP 07. 传递信息
// https://leetcode.cn/problems/chuan-di-xin-xi/?envType=problem-list-v2&envId=dynamic-programming
public class dp009 {

    // 深度优先解法

    int ways;
    int target;
    int finalK;

    public int numWays(int n, int[][] relation, int k) {
        // 深度优先3轮，查看节点情况
        ways = 0; // 方案数
        target = n-1; // 最终编号
        finalK = k; // 遍历几次
        // 记录有向连通情况
        int[][] road = new int[n][n];
        for(int i=0; i<relation.length; i++) {
            road[relation[i][0]][relation[i][1]] = 1;
        }

        dfs(road,0,0);

        return ways;

    }

    public void dfs(int[][]road, int index, int step) {
        if(step==finalK-1) {
            if(road[index][target] == 1) {
                ways++;
            }
            return;
        }
        step++;
        for(int i = 0; i <road.length; i++) {

            if(road[index][i] == 1) {
                dfs(road, i,step);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        int[][] relation = {
                {0, 1},
                {0, 2},
                {2, 1},
                {1, 2},
                {1, 0},
                {2, 0}
        };

        dp009 dp009 = new dp009();
        dp009.numWays(n,relation,k);
        System.out.println(dp009.ways);
    }

}
