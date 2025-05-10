package com.test1.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        //先标记，再清楚即可
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> setx=new ArrayList<>();
        List<Integer> sety=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setx.add(i);
                    sety.add(j);
                }
            }
        }
        for(int i:setx){
            for(int j=0;j<n;j++){
                matrix[i][j]=0;
            }
        }
        for(int j:sety){
            for(int i=0;i<m;i++){
                matrix[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes s=new SetZeroes();
        int [][] matrix= {{1,1,1},{1,0,1},{1,1,1}};
        s.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
