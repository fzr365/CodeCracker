package com.test1.array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //todo1:移动所有位置归位
        int n = nums.length;
        for(int num : nums){
            while(num>0&&num<n&&nums[num-1]!=num){
                int temp = nums[num-1];
                nums[num-1] = num;
                num = temp;
            }
        }
        //todo2:遍历数组查找出来
        for(int i = 0; i < n; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        //都住满
        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        int[] nums = {1,2,0};
        System.out.println(f.firstMissingPositive(nums));
    }
}
