package com.test1.array;

import java.util.Arrays;

public class Rotate {
    public void rotate(int[] nums, int k) {
        //3次反转
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }
    //每次对称反转
    private void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate.rotate(nums,k);
        //打印数组
        System.out.println(Arrays.toString(nums));

    }
}
