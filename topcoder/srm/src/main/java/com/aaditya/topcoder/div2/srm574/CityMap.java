package com.aaditya.topcoder.div2.srm574;

import java.util.HashMap;
import java.util.Map;

public class CityMap {
    public static String getLegend(String[] cityMap, int[] POIs) {
        int[] frequencies = new int[26];
        for (String aCityMap : cityMap) {
            for (int j = 0; j < cityMap[0].length(); j++) {
                if (aCityMap.charAt(j) != '.') {
                    frequencies[aCityMap.charAt(j) - 'A']++;
                }
            }
        }
        Map<Integer, Character> freqMapping = new HashMap<>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != 0) {
                freqMapping.put(frequencies[i], (char) (i + 'A'));
            }
        }
        StringBuilder stringBuilder = new StringBuilder(POIs.length);
        for (int poi : POIs) {
            stringBuilder.append(freqMapping.get(poi));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(getLegend(new String[]{"M....M",
                "...R.M",
                "R..R.R"},
        new int[]{3, 4}));
    }
}
