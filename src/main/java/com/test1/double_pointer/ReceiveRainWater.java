package com.test1.double_pointer;

public class ReceiveRainWater {
    public int trap(int[] height) {
        //左右数组，高度差,因为雨水能接多少就是由于高度最大的来决定的
        int n=height.length;
        int left[]=new int[n];
        int right[] =new int[n];
        int ret=0;
        left[0]=height[0];
        right[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }

        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }

        for(int i=0;i<n;i++){
            ret+=Math.min(left[i],right[i])-height[i];
        }
        return ret;
    }

    public static void main(String[] args) {
      ReceiveRainWater r=new ReceiveRainWater();
      int [] height={0,1,0,2,1,0,1,3,2,1,2,1};
      System.out.println(r.trap(height));
    }
}
