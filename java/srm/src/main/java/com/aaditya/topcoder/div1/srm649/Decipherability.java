package com.aaditya.topcoder.div1.srm649;

public class Decipherability {
    public static String check(String s, int K) {
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j) && j - i <= K) {
                    return "Uncertain";
                }
            }
        }
        return "Certain";
    }
}

