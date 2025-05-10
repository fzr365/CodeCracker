package com.test1.substring;

public class MinWindow {
    public String minWindow(String s, String t) {
        //使用字符数组解决
        char [] s1=s.toCharArray();
        int m=s1.length;
        int retleft=-1;
        int retright=m;
        int [] cnts = new int[128];
        int [] cntt=new int[128];
        //cntt代表字符串t中每个字符c出现的次数
        for(char c:t.toCharArray()){
            cntt[c]++;
        }
        int left=0;
        //cnts代表字符串s中每个字符出现的次数
        for(int right=0;right<m;right++){
            cnts[s1[right]]++;
            while(isCovered(cnts,cntt)){
                //更小的覆盖子串
                if(right-left<retright-retleft){
                    retleft=left;
                    retright=right;
                }
                //向右移动遍历
                cnts[s1[left]]--;
                left++;
            }
        }
        return retleft<0?"":s.substring(retleft,retright+1);
    }

    //通过统计字符出现次数的字典判断是否cover
    private boolean isCovered(int [] cnts,int [] cntt){
        for(int i='A';i<='Z';i++){
            if(cnts[i]<cntt[i]){
                return false;
            }
        }

        for(int i='a';i<='z';i++){
            if(cnts[i]<cntt[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindow mw = new MinWindow();
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(mw.minWindow(s, t));
    }
}
