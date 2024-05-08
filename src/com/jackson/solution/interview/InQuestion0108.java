package com.jackson.solution.interview;

/**
 * 0108. 零矩阵
 * https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class InQuestion0108 {
    public void setZeroes(int[][] matrix) {
        int[] colSituation = new int[matrix[0].length];
        int[] rowSituation = new int[matrix.length];
        for (int i = 0;i<matrix.length;i++) {
            rowSituation[i]=1;
        }
        for (int i = 0;i<matrix[0].length;i++) {
            colSituation[i]=1;
        }

        for (int i = 0;i<matrix.length;i++) {
            for (int j = 0;j<matrix[0].length;j++) {
                if (matrix[i][j]==0) {
                    colSituation[j] = 0;
                    rowSituation[i] = 0;

                }
            }
        }
        for(int i=0;i<matrix.length;i++) {
            if (rowSituation[i]==0) {
                for (int j = 0;j<matrix[0].length;j++) matrix[i][j]=0;
            }
            else {
                for (int j = 0;j<matrix[0].length;j++) {
                    if(colSituation[j]==0) matrix[i][j]=0;
                }
            }
        }
    }
}
