package com.test1.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNum {
    //数组找到两个数的下表等于target
    public int[] twoSum(int [] nums,int target){
        Map<Integer,Integer> dict=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(dict.containsKey(target-nums[i])){
                return new int [] {dict.get(target-nums[i]),i};
            }
            dict.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int target=9;
        int [] nums={2,7,11,15};
        SumOfTwoNum sum=new SumOfTwoNum();
        int [] result= sum.twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }

}
