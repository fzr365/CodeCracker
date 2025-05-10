package com.test1.interest;

import java.util.*;

public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param planks int整型 一维数组
     * @return bool布尔型
     */
    public boolean canFormSquare(int[] planks) {
        // int n=planks.length;
        // int sum=0;
        // for(int i=0;i<n;i++){
        //     sum+=planks[i];
        // }
        // return sum%n==0?sum/4:false;

        //先考虑边界吧
        int n=planks.length;
        if(n<4){
            return false;
        }
        int sum=0;
        for(int plank:planks){
            sum+=plank;
        }

        if(sum%4!=0){
            return false;
        }

        //木板的边界
        int muban=sum/4;
        Arrays.sort(planks);

        //用回溯来做
        int[] hui=new int[4];
        return huisu(n-1,planks,hui,muban);
    }

    //回溯
    private boolean huisu(int nn,int [] planks,int[] hui,int muban){
        if(nn<0){
            //肯定没办法再回溯了
            return true;
        }
        int the=planks[nn];
        //遍历去组合木板看能不能拼成功
        for(int i=0;i<4;i++){
            //根据叠起来的木板长度是否大于阈值来判断
            if(hui[i]+the<=muban){
                hui[i]+=the;
                if (huisu(nn-1,planks,hui,muban)){
                    //拼成功
                    return true;
                }
                hui[i]-=the;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.canFormSquare(new int[]{1,1,2,2,2}));
    }
}


