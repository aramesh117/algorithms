package com.aaditya.topcoder.div2.srm652;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValueOfString {
    public static int findValue(String s) {
        Set<Character> uniques = new HashSet<>();
        for (char a : s.toCharArray()) {
            uniques.add(a);
        }
        Map<Character, Integer> ks = new HashMap<>();
        for (char a : uniques) {
            int k = 0;
            for (char b : s.toCharArray()) {
                if (b <= a) {
                    k++;
                }
            }
            ks.put(a, k);
        }
        int tot = 0;
        for (char a: s.toCharArray()) {
            int charVal = a - 'a' + 1;
            tot += ks.get(a) * charVal;
        }
        return tot;
    }

    public static void main(String[] args) {
        System.out.println(findValue("zz"));
    }
}
