package com.test1.array;

public class LuckyNum {
    public int findLucky(int [] arr){
        int [] numArr=new int[501];
        for(int i:arr){
            numArr[i]++;
        }
        for(int i=numArr.length-1;i>=1;i--){
            if(numArr[i]==i){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
       int [] arr={1,2,2,3,3,3};
       LuckyNum lucky=new LuckyNum();
       System.out.println(lucky.findLucky(arr));
    }
}
