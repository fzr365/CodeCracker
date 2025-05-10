package com.test1.matrix;

import java.util.ArrayList;

public class SpiralOrder {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        //模拟绕环
        int m = matrix.length;
        int n = matrix[0].length;
        int a=0,b=n-1,c=0,d=m-1;
        ArrayList<Integer> ret = new ArrayList<>();
        while(true){
            //就是模拟的过程
            for(int i=a;i<=b;i++){
                ret.add(matrix[c][i]);
            }
            c++;
            if(c>d) break;
            for(int i=c;i<=d;i++){
                ret.add(matrix[i][b]);
            }
            b--;
            if(a>b) break;
            for(int i=b;i>=a;i--){
                ret.add(matrix[d][i]);
            }
            d--;
            if(c>d) break;
            for(int i=d;i>=c;i--){
                ret.add(matrix[i][a]);
            }
            a++;
            if(a>d) break;
        }
        return ret;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder.spiralOrder(matrix));
    }
}
