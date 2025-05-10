package com.test1.interest;

import java.util.Arrays;

public class Word {
    public static boolean isStraight(int [] nums){
        Arrays.sort(nums);
        int zeroCount = 0;
        //统计大小王(0)的数量
        for(int num:nums){
            if(num==0){
                zeroCount++;
            }
        }
        int index=zeroCount;
        while(index<nums.length-1){
            //如果有重复数字（除了0），则不是顺子
            if(nums[index]==nums[index+1]){
                return false;
            }
            //计算相邻的数字间隔，用0的数量去填补
            zeroCount-=(nums[index+1]-nums[index]-1);
            if(zeroCount<0){
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
           int [] nums1={1,2,5,7,9};
           int [] nums2={1,3,4,0,0};
           Word solution = new Word();
           System.out.println(solution.isStraight(nums1));
           System.out.println(solution.isStraight(nums2));
    }
}
