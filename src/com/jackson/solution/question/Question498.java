package com.jackson.solution.question;

/**
 * 498. 对角线遍历
 * https://leetcode.cn/problems/diagonal-traverse/description/
 */
public class Question498 {
    public static int[] findDiagonalOrder(int[][] mat) {

        boolean direction = true;
        int[] arr = new int[mat.length * mat[0].length];
        int i = 0;
        int j = 0;
        int index = 0;

        while(index < mat.length * mat[0].length) {
            arr[index++] = mat[i][j];
            if (direction == true) {
                if ((i -1) >= 0 && (j + 1) <mat.length) {
                    i = i -1;
                    j = j + 1;
                } else if((j+1) < mat.length) {
                    j = j + 1;
                    direction = false;
                } else if (i+1 < mat.length) {
                    i = i + 1;
                    direction = false;
                } else {
                    break;
                }
            } else {
                if ((j -1) >= 0 && (i + 1) <mat.length) {
                    j = j -1;
                    i = i + 1;
                } else if((i+1) < mat.length) {
                    i = i + 1;
                    direction = true;
                } else if (j+1 < mat.length) {
                    j = j + 1;
                    direction = true;
                } else {
                    break;
                }
            }
        }

        return arr;
//        int iMax = mat.length-1;
//        int jMax = mat[0].length-1;
//        int[] arr = new int[(iMax+1) * (jMax+1)];
//        int index=0;
//        for (int k = 0; k <= (iMax+jMax); k++) {
//            if (k%2 == 0) {
//                for (int i = k; i>=0; i-- ) {
//                    if (i<=iMax && (k-i)<=jMax) arr[index++] = mat[i][k-i];
//                }
//            }
//            else {
//                for (int i=0; i<=k; i++) {
//                    if (i<=iMax && (k-i)<=jMax) arr[index++] = mat[i][k-i];
//                }
//            }
//        }
//
//        return arr;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2}};
        int[] diagonalOrder = findDiagonalOrder(ints);
    }
}
