package com.test1.interest;

public class Stap {
    public static int jump(int[] nums){
        int n=nums.length;
        int maxReach=0;
        int end=0;
        int jumps=0;
        for(int i=0;i<n-1;i++){
            maxReach=Math.max(maxReach,i+nums[i]);
            if(i==end){
                end=maxReach;
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int [] num1={2,3,1,1,4};
        System.out.println(jump(num1));
        int [] num2={2,3,0,1,4};
        System.out.println(jump(num2));
    }
}
