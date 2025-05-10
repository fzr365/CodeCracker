package com.test1.substring;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxSlidingWindows {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //使用双端单调递减队列解决问题
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int [] ret = new int[n - k + 1];
        int idx=0;
        for(int i=0;i<n;i++){
            //在n-k+1处取得
            while(!deque.isEmpty()&&deque.peek()<i-k+1){
                deque.poll();
            }
            //符合单调
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            //放值
            if(i>=k-1){
                ret[idx++] = nums[deque.peek()];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxSlidingWindows msw = new MaxSlidingWindows();
        int [] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(msw.maxSlidingWindow(nums, k)));
    }
}
