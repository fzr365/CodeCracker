package com.test1.substring;

import java.util.HashMap;
import java.util.Map;

public class NumIsK {
    public int subarraySum(int[] nums, int k) {
        //使用前缀和解决
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ret=0;
        map.put(0,1);
        for(int x:nums){
            sum+=x;
            ret+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        NumIsK numIsK = new NumIsK();
        int [] nums = {1,1,1};
        System.out.println(numIsK.subarraySum(nums,2));
    }
}
