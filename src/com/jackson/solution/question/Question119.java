package com.jackson.solution.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角II
 * https://leetcode.cn/problems/pascals-triangle-ii/description/
 */
public class Question119 {

    // 其实组合数是可以做的，但不是去求每一个组合数，而是“顺序”组合数之间的关系


    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex+1;
        ArrayList<List<Integer>> wholeList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j==0) integerArrayList.add(1);
                else integerArrayList.add(wholeList.get(i-1).get(j)+wholeList.get(i-1).get(j-1));
            }
            integerArrayList.add(1);
            if (i == numRows-1) return integerArrayList;
            wholeList.add(integerArrayList);
        }
        return null;
    }

//    public List<Integer> getRow(int rowIndex) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i <= rowIndex ; i++) {
//            if(i> rowIndex / 2) {
//                arrayList.add(arrayList.get(rowIndex-i));
//                continue;
//            }
////            arrayList.add((int)combination(rowIndex,i));
//        }
//        return arrayList;
//    }


//    /**
//     * 排列
//     * @param n 总数
//     * @param m 选数
//     * @return 值
//     */
//    public long arrangement(int n, int m) {
//        long value = 1;
//        for (int i = 0; i < m; i++) {
//            value *= (n-i);
//        }
//        return value;
//    }
//    /**
//     * 组合
//     * @param n 总数
//     * @param m 选数
//     * @return 值
//     */
//    public long combination(int n, int m) {
//        return arrangement(n,m) / arrangement(m,m);
//    }


}
