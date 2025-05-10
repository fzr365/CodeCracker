package com.test1.sliding_windows;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p){
        //先计数再匹配
        List<Integer> ret = new ArrayList<Integer>();
        //计数
        int [] cnt = new int[26];
        for(int i=0;i<p.length();i++){
            cnt[p.charAt(i)-'a']++;
        }
        //寻数
        int l=0;
        for(int r=0;r<s.length();r++){
            cnt[s.charAt(r)-'a']--;
            while(cnt[s.charAt(r)-'a']<0){
                cnt[s.charAt(l)-'a']++;
                l++;
            }
            if(r-l+1==p.length()){
                ret.add(l);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAnagrams f = new FindAnagrams();
        System.out.println(f.findAnagrams(s, p));
    }
}
