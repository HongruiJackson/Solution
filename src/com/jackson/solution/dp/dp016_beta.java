package com.jackson.solution.dp;

import java.util.HashSet;
import java.util.Set;

// 3032. 统计各位数字都不同的数字个数 II
// https://leetcode.cn/problems/count-numbers-with-unique-digits-ii/description/?envType=problem-list-v2&envId=dynamic-programming
// 给你两个 正整数 a 和 b ，返回 闭区间 [a, b] 内各位数字都不同的数字个数。
public class dp016_beta {

    public int numberCount(int a, int b) {
        String num = String.valueOf(a);
        int digitsNumber = num.length();
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        int tempA = a;
        for (int i = 0; i < digitsNumber; i++) {
            // 剩余数字最高位幂
            int pow = pow(10, digitsNumber-1-i);
            // 剩余数字最高位数字
            int d = tempA/pow;
            // 更新剩余数字
            tempA -= d * pow;
            if (set.contains(d)) {
                flag = true;
                break;
            }
            set.add(d);
        }

        // 如果左闭区间是一个满足条件的数，那么会多减掉它本身
        if (flag) {
            return fromOneCount(b)-fromOneCount(a);
        } else {
            return fromOneCount(b)-fromOneCount(a)+1;
        }
    }

    // 统计从[1,num]的各位数字都不同的数字个数
    public int fromOneCount(int data) {
        // 先转成字符串，便于求数字的位数
        String num = String.valueOf(data);
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

        int[] dp = new int[digitsNumber];
        int[] dp2 = new int[digitsNumber];
        dp[0] = 1;
        dp2[0] = 1;
        for (int i = 1; i < digitsNumber; i++) {
            dp[i] = dp[i-1]*(10-i);
            dp2[i] = dp2[i-1]*(10-digitsNumber+i);
        }

        for (int i = 1; i < digitsNumber; i++) {
            sum+=9*dp[i-1];
        }

        // 2. 之后来处理本位的数
        // 以先前的[1,870] 为例 ，现在[1,9][10,99]的个数已经全部处理完了
        // 现在只需要处理[100,875]的部分
        // 而这部分也能先分成[100,799][800,875]的部分
        // 2.1 先看[100,799]的部分，也就是最高位的部分，之后8就定下来了，故需要有一个地方统计用过的数字
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digitsNumber; i++) {
            // 剩余数字最高位幂
            int pow = pow(10, digitsNumber-1-i);
            // 剩余数字最高位数字
            int d = data/pow;
            // 更新剩余数字
            data -= d * pow;
            int j = 0;
            // 统计该位上能用的数字个数
            if (i == 0) { // 最高位不能为0
                j = 1;
            }
            int dNum = 0;
            int times;
            times = d;
            // 最低位校验次数要多一次
            if (i == digitsNumber-1) {
                times++;
            }
            for (; j < times; j++) {
                if(!set.contains(j)) {
                    dNum++;
                }
            }

            sum+=dNum * dp2[digitsNumber-1-i];

            if (set.contains(d)) {
                break;
            }
            set.add(d);
        }


        return sum;
    }

    /**
     * int求幂
     * @param a 底数
     * @param n 指数
     * @return
     */
    public int pow(int a, int n) {
        if (n == 0) return 1;
        return a*pow(a, n-1);
    }

    public static void main(String[] args) {
        int a = 199;
        int b = 574;
        dp016_beta test = new dp016_beta();
        int i1 = test.fromOneCount(a);
        System.out.println(i1);
        int i2 = test.fromOneCount(b);
        System.out.println(i2);
        int i = test.numberCount(a,b);
        System.out.println(i);
    }
}
