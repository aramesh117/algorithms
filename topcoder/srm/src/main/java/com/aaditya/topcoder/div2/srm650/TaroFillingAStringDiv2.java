package com.aaditya.topcoder.div2.srm650;

public class TaroFillingAStringDiv2 {
    public static int getNumber(String S) {
        int start = 0;
        int end = S.length() - 1;
        while (start < S.length() && S.charAt(start) == '?')
            start++;
        while (end >= 0 && S.charAt(end) == '?')
            end--;
        if (start >= S.length()) {
            return 0;
        }
        String S2 = S.substring(start, end + 1);
        int i = 0;
        int ugliness = 0;
        while (i < S2.length() - 1) {
            if (S2.charAt(i) == '?') {
                char left = S2.charAt(i - 1);
                int streakLength = 0;
                while (S2.charAt(i) == '?') {
                    streakLength++;
                    i++;
                }
                char right = S2.charAt(i);
                ugliness += getUglinessForStreak(left, streakLength, right);
                continue;
            }
            if (S2.charAt(i) == S2.charAt(i + 1)) {
                ugliness++;
            }
            i++;
        }
        return ugliness;
    }

    public static int getStreakLength(String s, int startIndex) {
        int i = startIndex;
        int length = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '?') {
                i++;
                length++;
            } else {
                break;
            }
        }
        return length;
    }


    public static int getUglinessForStreak(char left, int streakLength, char right) {
        if (left == right) {
            if (streakLength % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (streakLength % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public int getUgliness(String s) {
        int ugliness = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                ugliness++;
            }
        }
        return ugliness;
    }

    public static void main(String[] args) {
        System.out.println(getNumber("??"));
    }
}
