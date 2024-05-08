package com.jackson.solution.question;

/**
 * 48. 旋转矩阵
 * https://leetcode.cn/problems/rotate-image/
 */
public class Question48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int temp = 0;
        // 沿主对角线进行翻转
        for(int i = 0; i < length; i++) { // 行遍历
            for (int j = i+1; j<length;j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 沿中心轴进行翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length/2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-1-j];
                matrix[i][length-1-j] = temp;
            }
        }
    }
}
