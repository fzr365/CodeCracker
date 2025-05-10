package com.test1.interest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordProcessing {
    public String[] wordChain(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        String lastChar = words[0].substring(words[0].length() - 1);
        boolean[] used = new boolean[words.length];
        used[0] = true;
        int index = 1;
        while (index < words.length) {
            boolean found = false;
            for (int i = 1; i < words.length; i++) {
                if (!used[i]) {
                    // 第一个字母
                    String firstChar = words[i].substring(0, 1);
                    // 如果字母相等
                    if (firstChar.equals(lastChar)) {
                        result.add(words[i]);
                        // 更新最后一个字母
                        lastChar = words[i].substring(words[i].length() - 1);
                        used[i] = true;
                        found = true;
                        index++;
                        break;
                    }
                }
            }
            // 如果查找不到
            if (!found) {
                lastChar = shiftChar(lastChar);
            } else {
                // 只有找到匹配单词时才增加index
                index++;
            }
        }
        return result.toArray(new String[0]);
    }

    // 顺延函数
    private String shiftChar(String c) {
        char ch = c.charAt(0);
        if (ch == 'z') {
            ch = 'a';
        } else {
            ch++;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        WordProcessing wp = new WordProcessing();
        String[] words = {"words", "frog", "sde"};
        String[] result = wp.wordChain(words);
        System.out.println(Arrays.toString(result));
    }
}