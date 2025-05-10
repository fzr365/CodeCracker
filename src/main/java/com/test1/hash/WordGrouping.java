package com.test1.hash;

import java.util.*;

public class WordGrouping {
    public List<List<String>> groupAnagrams(String [] strs){
        Map<String,List<String>> dict=new HashMap<>();
        for(String str:strs){
            char [] s=str.toCharArray();
            Arrays.sort(s);
            //多值映射
            dict.computeIfAbsent(new String(s),k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(dict.values());
    }

    public static void main(String[] args) {
        String [] string=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        WordGrouping wordgroup = new WordGrouping();
        System.out.println(wordgroup.groupAnagrams(string));
    }
}
