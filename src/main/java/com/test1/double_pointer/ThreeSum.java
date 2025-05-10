package com.test1.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int [] nums){
        //左2右1
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> ret=new ArrayList<>();
        for(int k=0;k<nums.length;k++){
            if(nums[0]>0) break;
            if(k>0&&nums[k]==nums[k-1]) continue;
            int i=k+1,j=nums.length-1;
            while(i<j){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    while(i<j&&nums[i]==nums[++i]);
                }else if(sum>0){
                    while(i<j&&nums[j]==nums[--j]);
                }else{
                    ret.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while(i<j&&nums[i]==nums[++i]);
                    while(i<j&&nums[j]==nums[--j]);
                }

            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int [] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSum(nums));
    }
}
