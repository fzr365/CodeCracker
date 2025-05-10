package com.test1;

import java.util.HashMap;
import java.util.Map;

public class ValidKuohao {
    private static final Map<Character,Character> map=new HashMap<Character,Character>(){
        {
            put('{', '}');
            put('[', ']');
            put('(', ')');
            put('?', '?');
        }
    };


}
