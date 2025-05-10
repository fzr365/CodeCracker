package com.test1.array;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        //线性时间复杂度解决
        int ret=nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i]+=Math.max(nums[i-1],0);
            ret=Math.max(ret,nums[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
