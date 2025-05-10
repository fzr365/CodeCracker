package com.test1.sliding_windows;

import java.util.HashMap;
import java.util.Map;

public class NoDupMaxString {
    public int lengthOfLongestSubstring(String s) {
        //使用哈希表更新指针寻址的方式
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i=-1;
        int ret=0;
        for(int j=0;j<s.length();j++){
            char c=s.charAt(j);
            if(map.containsKey(c)){
                i=Math.max(i,map.get(c));
            }
            map.put(c,j);
            ret=Math.max(ret,j-i);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        NoDupMaxString n=new NoDupMaxString();
        System.out.println(n.lengthOfLongestSubstring(s));
    }
}
