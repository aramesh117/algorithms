package com.aaditya.topcoder.div2.srm649;

import java.util.HashSet;
import java.util.Set;

public class DecipherabilityEasy {
    public static String check(String s, String t) {
        Set<String> possibles = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            possibles.add(s.substring(0, i) + s.substring(i + 1));
        }
        if (possibles.contains(t)) {
            return "Possible";
        }
        return "Impossible";
    }

    public static void main(String[] args) {

    }
}
