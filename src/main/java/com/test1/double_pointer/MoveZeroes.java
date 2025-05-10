package com.test1.double_pointer;

import java.util.Arrays;

public class MoveZeroes {
    public int [] moveZeroes(int [] nums){
        //快慢指针交换
        if(nums==null ||nums.length==0){
            return nums ;
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j++]=tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] nums={0,1,0,3,12};
        MoveZeroes movez=new MoveZeroes();
        System.out.println(Arrays.toString(movez.moveZeroes(nums)));
    }
}
