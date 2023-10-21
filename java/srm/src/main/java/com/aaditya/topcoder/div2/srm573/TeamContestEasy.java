package com.aaditya.topcoder.div2.srm573;

import java.util.Arrays;

public class TeamContestEasy {
    public static final int worstRank(int[] strength) {
        int ourStrength = strength[0] + strength[1] + strength[2] - Math.min(Math.min(strength[0], strength[1]), strength[2]);
        int[] otherteams = Arrays.copyOfRange(strength, 3, strength.length);
        if (otherteams.length > 0) {
            Arrays.sort(otherteams);
            int i = otherteams.length / 3;
            int j = otherteams.length - 1;
            int rank = 1;
            while (i < j) {
                if (otherteams[i] + otherteams[j] > ourStrength) {
                    rank++;
                    i++;
                    j--;
                } else {
                    i += 2;
                }
            }
            return rank;
        } else {
            return 1;
        }
    }
}
