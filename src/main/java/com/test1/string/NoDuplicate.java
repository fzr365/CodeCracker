package com.test1.string;

import java.util.HashMap;
import java.util.Map;

public class NoDuplicate {
    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer> dict=new HashMap<>();
        int i=-1;
        int ret=0;
        for(int j=0;j<s.length();j++){
            char c=s.charAt(j);
            if(dict.containsKey(c)){
                i=Math.max(i,dict.get(c));
            }
            dict.put(c,j);
            ret=Math.max(ret,j-i);
        }
        return ret;
    }

    public static void main(String[] args) {
        NoDuplicate solution=new NoDuplicate();
        String test="abcabcbb";
        int result=solution.lengthOfLongestSubstring(test);
        System.out.println(result);
    }

}
