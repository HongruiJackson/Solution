package com.jackson.solution.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/description/
 */
public class Question56 {
    public static int[][] merge(int[][] intervals) {
//        ArrayList<int[]> resultList = new ArrayList<>();
//        List<int[]> intervalsList = Arrays.stream(intervals).sorted((o1, o2) -> o1[0] - o2[0]).toList();
//        for (int i = 0; i<intervalsList.size();i++) {
//            if (resultList.isEmpty()) resultList.add(intervalsList.get(i));
//            else if (intervalsList.get(i)[0]<=resultList.get(resultList.size()-1)[1] && intervalsList.get(i)[0]>=resultList.get(resultList.size()-1)[0]) {
//                if (resultList.get(resultList.size()-1)[1] < intervalsList.get(i)[1]) resultList.get(resultList.size()-1)[1] = intervalsList.get(i)[1];
//            } else resultList.add(intervalsList.get(i));
//        }
//
//        return resultList.toArray(new int[resultList.size()][2]);

        ArrayList<int[]> resultList = new ArrayList<>();
        List<int[]> list = Arrays.stream(intervals).sorted((o1,o2)->o1[0]-o2[0]).toList();//按照左端排序
        int listSize = list.size();
        int resultListEndIndex = resultList.size()-1;
        // 先进行部分初始化数据
        if (listSize!=0) {
            resultList.add(list.get(0));
            resultListEndIndex++;
        }
        // 开始遍历
        // 永远和结果位置的最后一个值区间进行比较
        for (int i = 1;i<listSize;i++) {
            // 最简单的情况，端点都不重合，左边大于末尾
            if (list.get(i)[0] > resultList.get(resultListEndIndex)[1]) {
                resultList.add(list.get(i));
                resultListEndIndex++;
            }
            // 交集，左端点 == 右端点直接连接的情况
            else if (list.get(i)[0] == resultList.get(resultListEndIndex)[1]) {
                resultList.get(resultListEndIndex)[1] = list.get(i)[1];
            }
            // 交集
            else {
                if (list.get(i)[1] >= resultList.get(resultListEndIndex)[1]) {
                    resultList.get(resultListEndIndex)[1] = list.get(i)[1];
                }
            }


        }
        return list.toArray(new int[resultListEndIndex+1][2]);
    }

    public static void main(String[] args) {
        int[][] ints = {{1,3},{2,6},{8,10},{15,18}};
        merge(ints);
    }
}
