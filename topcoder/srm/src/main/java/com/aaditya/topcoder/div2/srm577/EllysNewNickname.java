package com.aaditya.topcoder.div2.srm577;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aramesh on 4/6/17.
 */
public class EllysNewNickname {

    public static int getLength(String nickname) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < nickname.length()) {
            if (vowels.contains(nickname.charAt(i))) {
                stringBuilder.append(nickname.charAt(i));
                while (i < nickname.length() && vowels.contains(nickname.charAt(i))) {
                    i++;
                }
            } else {
                stringBuilder.append(nickname.charAt(i));
                i++;
            }
        }
        return stringBuilder.toString().length();
    }

    public static void main(String[] args) {
        System.out.println(getLength("aaabayc"));
    }
}
