package com.test1.array;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //分块，计算前缀积，后缀积，相乘即可
        int n=nums.length;
        int [] left=new int[n];
        int [] right=new int[n];
        int [] ret=new int[n];
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            ret[i]=left[i]*right[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        ProductExceptSelf p=new ProductExceptSelf();
        int [] nums={1,2,3,4};
        int[] ret=p.productExceptSelf(nums);
        System.out.println(Arrays.toString(ret));
    }
}
