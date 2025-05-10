package com.test1.interest;

public class PaLou {

    public static int climbStairs(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        int [] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n1=10;
        int n2=20;
        System.out.println(climbStairs(n1));
        System.out.println(climbStairs(n2));

    }
}
