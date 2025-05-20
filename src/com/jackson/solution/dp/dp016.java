package com.jackson.solution.dp;

// 3032. 统计各位数字都不同的数字个数 II
// https://leetcode.cn/problems/count-numbers-with-unique-digits-ii/description/?envType=problem-list-v2&envId=dynamic-programming
// 给你两个 正整数 a 和 b ，返回 闭区间 [a, b] 内各位数字都不同的数字个数。
public class dp016 {

    public int numberCount(int a, int b) {

        return fromOneCount(b)-fromOneCount(a);
    }

    // 统计从[1,num]的各位数字都不同的数字个数
    public int fromOneCount(int data) {
        // 先转成字符串，便于遍历
        String num = String.valueOf(data);
        // 数字的位数
        int digitsNumber = num.length();
        // 满足条件的个数
        int sum = 0;
        // 1. 将本位-1的数求出来，即已知的个数求出来
        // 例如，如果是一个两位数，那么可以确定的就是9个一位数是满足条件的  
        //      --> [1,15] --> [1,9]-[10,15]
        //      如果是一个三位数，那么可以确定的就是9个一位数+9*(10-1)个两位数是满足条件的 
        //      --> [1,870] --> [1,9][10,99]-[100,875]
        //      如果是一个四位数，那么可以确定的就是9个一位数+9*(10-1)个两位数+9*(10-1)*(10-2)个是满足条件的
        //      --> [1,1202] --> [1,9][10,99][100,999]-[1000,1202]

        // 1.1 当数字大于两位的时候，才会用到累乘，故先要把个位的数字加了
        if (digitsNumber > 1) {
            sum+=9;
        }
        int historyData = 9; // 累乘缓存
        for (int i = 2; i < digitsNumber; i++) {
            sum+=historyData*(11-i);
            historyData = historyData*(11-i);
        }

        // 2. 之后来处理本位的数
        // 以先前的[1,870] 为例 ，现在[1,9][10,99]的个数已经全部处理完了
        // 现在只需要处理[100,875]的部分
        // 而这部分也能先分成[100,799][800,875]的部分
        // 2.1 先看[100,799]的部分，也就是最高位的部分，之后8就定下来了，故需要有一个地方统计用过的数字
        for (int i = 0; i < digitsNumber; i++) {

        }


        return sum;
    }

}
