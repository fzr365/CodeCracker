package com.test1.matrix;

import java.util.Arrays;

public class Rotate {
    public void rotate(int[][] matrix) {
       //先上下反转，再主对角线反转
        int n = matrix.length;
        //上下
        for(int i = 0; i < n/2; i++) {
            for(int j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        //主对角线反转
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Rotate rotate = new Rotate();
        rotate.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
