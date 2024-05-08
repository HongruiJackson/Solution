package com.jackson.solution.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/description/
 */
public class Question56 {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> resultList = new ArrayList<>();
        List<int[]> intervalsList = Arrays.stream(intervals).sorted((o1, o2) -> o1[0] - o2[0]).toList();
        for (int i = 0; i<intervalsList.size();i++) {
            if (resultList.isEmpty()) resultList.add(intervalsList.get(i));
            else if (intervalsList.get(i)[0]<=resultList.get(resultList.size()-1)[1] && intervalsList.get(i)[0]>=resultList.get(resultList.size()-1)[0]) {
                if (resultList.get(resultList.size()-1)[1] < intervalsList.get(i)[1]) resultList.get(resultList.size()-1)[1] = intervalsList.get(i)[1];
            } else resultList.add(intervalsList.get(i));
        }

        return resultList.toArray(new int[resultList.size()][2]);
    }
}
