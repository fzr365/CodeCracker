package com.test1.matrix;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //使用贪心算法来做
        int m = matrix.length;
        int n = matrix[0].length;
        //倒序查找
        int i=m-1;
        int j=0;
        while(i>=0 && j<n){
            if(matrix[i][j]>target){
                i--;
            }else if(matrix[i][j]<target){
                j++;
            }else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(sm.searchMatrix(matrix, target));
    }
}
