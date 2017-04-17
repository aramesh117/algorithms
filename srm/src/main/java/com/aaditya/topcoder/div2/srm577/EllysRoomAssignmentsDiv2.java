package com.aaditya.topcoder.div2.srm577;

import java.util.ArrayList;
import java.util.Collections;

public class EllysRoomAssignmentsDiv2 {
    public static double getProbability(String[] ratings) {
        StringBuilder fullRatings = new StringBuilder();
        for (String rating1 : ratings) {
            fullRatings.append(rating1);
        }
        String allRatings = fullRatings.toString();
        ArrayList<Integer> intRatings = new ArrayList<>();
        String[] allRatingsSplit = allRatings.split(" ");
        int ellysRating = Integer.parseInt(allRatingsSplit[0]);
        for (String rating : allRatingsSplit) {
            intRatings.add(Integer.parseInt(rating));
        }
        Collections.sort(intRatings, Collections.<Integer>reverseOrder());
        int numPlayers = intRatings.size();
        int numRooms = numPlayers % 20 == 0 ? numPlayers / 20 : numPlayers / 20 + 1;
        if (numRooms == 1) {
            return 1.0;
        } else {
            int index = Collections.binarySearch(intRatings, ellysRating, Collections.<Integer>reverseOrder());
            // Elly IS the highest.
            if (index == 0) {
                return 1.0;
            }
            if (index < numRooms) {
                return 0.0f;
            }
            return 1.0 / numRooms;

        }
    }
}
