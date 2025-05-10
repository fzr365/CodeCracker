package com.test1.double_pointer;

public class MaxArea {
    public int maxArea(int [] height){
        //本质向内收缩
        int left=0,right=height.length-1;
        int mx=0;
        while(left<right){
            mx=Math.max(Math.min(height[left],height[right])*(right-left),mx);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        int [] height={1,8,6,2,5,4,8,3,7};
        MaxArea maxa=new MaxArea();
        System.out.println(maxa.maxArea(height));


    }
}
