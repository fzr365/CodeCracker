package com.test1.hash;
import java.util.HashSet;
import java.util.Set;
public class LongestSeq {
    public int longestConsecutive(int [] nums){
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int maxLength =0;
        for(int num:set){
            //判断是否为连续序列的起点
            if(!set.contains(num-1)){
                int cur=num;
                int curlength=1;
                //往后延伸
                while(set.contains(cur+1)){
                    cur++;
                    curlength++;
                }
                maxLength=Math.max(maxLength,curlength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int [] nums={100,4,200,1,3,2};
        LongestSeq longestSeq=new LongestSeq();
        System.out.println(longestSeq.longestConsecutive(nums));
    }


}
