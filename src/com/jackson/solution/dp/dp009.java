package com.jackson.solution.dp;

// LCP 07. 传递信息
// https://leetcode.cn/problems/chuan-di-xin-xi/?envType=problem-list-v2&envId=dynamic-programming
public class dp009 {

    public int numWays(int n, int[][] relation, int k) {
        // 这里的动态规划也很有价值，也是一种很灵活的思想
        // 其对状态的定义：定义动态规划的状态 dp[i][j] 为经过 i 轮传递到编号 j 的玩家的方案数
        // 用广度去思考，求解的内容是方案数
        // 某一轮的到达某个结点的方案数，一定与上一轮相关，
        // 例如：第0轮的初始状态：1, 0, 0
        // 假设：第1轮成为了状态：0, 1, 1  就代表了0为起始点，连通到了1,2
        // 假设：1和2也连通到了0，那么理应有：2, 0,0
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < k; i++) {
            int[] temp = new int[n];
            for(int[]re : relation) {
                temp[re[1]]+=dp[re[0]];
            }

            dp = temp;
        }

        return dp[n-1];
    }


//------------------------------------------------------------
//    // 深度优先解法
//
//    int ways;
//    int target;
//    int finalK;
//
//    public int numWays(int n, int[][] relation, int k) {
//        // 深度优先3轮，查看节点情况
//        ways = 0; // 方案数
//        target = n-1; // 最终编号
//        finalK = k; // 遍历几次
//        // 记录有向连通情况
//        int[][] road = new int[n][n];
//        for(int i=0; i<relation.length; i++) {
//            road[relation[i][0]][relation[i][1]] = 1;
//        }
//
//        dfs(road,0,0);
//
//        return ways;
//
//    }
//
//    public void dfs(int[][]road, int index, int step) {
//        if(step==finalK-1) {
//            if(road[index][target] == 1) {
//                ways++;
//            }
//            return;
//        }
//        step++;
//        for(int i = 0; i <road.length; i++) {
//
//            if(road[index][i] == 1) {
//                dfs(road, i,step);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int n = 3;
//        int k = 5;
//        int[][] relation = {
//                {0, 1},
//                {0, 2},
//                {2, 1},
//                {1, 2},
//                {1, 0},
//                {2, 0}
//        };
//
//        dp009 dp009 = new dp009();
//        dp009.numWays(n,relation,k);
//        System.out.println(dp009.ways);
//    }

}
