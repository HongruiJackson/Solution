package com.jackson.solution.question;

/**
 * 498. 对角线遍历
 * https://leetcode.cn/problems/diagonal-traverse/description/
 */
public class Question498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int iMax = mat.length-1;
        int jMax = mat[0].length-1;
        int[] arr = new int[(iMax+1) * (jMax+1)];
        int index=0;
        for (int k = 0; k <= (iMax+jMax); k++) {
            if (k%2 == 0) {
                for (int i = k; i>=0; i-- ) {
                    if (i<=iMax && (k-i)<=jMax) arr[index++] = mat[i][k-i];
                }
            }
            else {
                for (int i=0; i<=k; i++) {
                    if (i<=iMax && (k-i)<=jMax) arr[index++] = mat[i][k-i];
                }
            }
        }

        return arr;
    }
}
