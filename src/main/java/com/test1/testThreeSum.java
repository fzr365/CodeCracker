package com.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testThreeSum {
    public List<List<Integer>> threeSum(int [] nums){
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> ret=new ArrayList<>();
        for(int k=0;k<nums.length-2;k++){
            if(nums[0]>0) break;
            if(k>0&&nums[k]==nums[k-1]) continue;
            int i=k+1,j=nums.length-1;
            while(i<j) {
                int sum = nums[k] + nums[i] + nums[j];
                //去重并判断情况
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    ret.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args){
        testThreeSum test=new testThreeSum();
        int [] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> result=test.threeSum(nums);
        System.out.println(result);
    }
}
