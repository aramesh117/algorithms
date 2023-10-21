package com.aaditya.codefights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PressingButtons {
    public static String[] pressingButtons(String buttons) {
        Map<Integer, List<Character>> mapping = new HashMap<>();
        mapping.put(2, Arrays.asList('a', 'b', 'c'));
        mapping.put(3, Arrays.asList('d', 'e', 'f'));
        mapping.put(4, Arrays.asList('g', 'h', 'i'));
        mapping.put(5, Arrays.asList('j', 'k', 'l'));
        mapping.put(6, Arrays.asList('m', 'n', 'o'));
        mapping.put(7, Arrays.asList('p', 'q', 'r', 's'));
        mapping.put(8, Arrays.asList('t', 'u', 'v'));
        mapping.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        // Essentially a cartesian product of the sets.
        List<String> builders = new ArrayList<>();
        for (int i = 0; i < buttons.length(); i++) {
            List<String> newList = new ArrayList<>();
            for (char c : mapping.get(buttons.charAt(i) - '0')) {
                if (builders.isEmpty()) {
                    newList.add(String.valueOf(c));
                } else {
                    for (String intermediate : builders) {
                        newList.add(intermediate + c);
                    }
                }
            }
            builders = newList;
        }
        Collections.sort(builders);
        return builders.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pressingButtons("234")));
    }

}
