package com.jackson.solution.dp;

// 338. 比特位计数
// https://leetcode.cn/problems/counting-bits/description/?envType=problem-list-v2&envId=dynamic-programming
public class dp005 {

    public int[] countBits(int n) {
        // 其实很容易发现，凡是2的整数次幂，比特数都是为1，这是显然的
        // 故每一个数都可以看成是2的整数次幂加上一个非2的整数次幂的数的和
        // 所以比特数就是1 + 非2的整数次幂的数的比特数
        // 首先 0 肯定为0
        // 1可以看成2的0次幂 + 0；故为1+0的比特数为1
        // 2可以看成2的一次幂 + 0；故为 1 + 0
        // 3可以看成2的一次幂 + 1，即 1 加上 1的比特数 故为2
        // 所以问题的核心变为如何确定一个数是2的整数次幂
        // 这里可以记一下，2的整数次幂的数-1恰好会形成这样的样子 1000 0111，且运算为0便可以判断
        int[] bits  = new int[n+1];
        int highTwo = 0;
        bits[0] = 0;
        for(int i=1; i<=n; i++) {
            if ( (i & (i-1)) == 0) {
                highTwo = i;
            }
            bits[i] = bits[i-highTwo] + 1;
        }
        return bits;

    }

}
