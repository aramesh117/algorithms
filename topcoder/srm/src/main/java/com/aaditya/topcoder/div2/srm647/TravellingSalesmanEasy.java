package com.aaditya.topcoder.div2.srm647;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TravellingSalesmanEasy {
    public static int getMaxProfit(int M, int[] profit, int[] city, int[] visit) {
        // Construct the mapping from city to ordered profit.
        Map<Integer, PriorityQueue<Integer>> cityToProfitMap = new HashMap<>();
        for (int i = 0; i < profit.length; i++) {
            int currentCity = city[i];
            if (cityToProfitMap.containsKey(currentCity)) {
                cityToProfitMap.get(currentCity).add(profit[i]);
            } else {
                PriorityQueue<Integer> newQueue = new PriorityQueue<>(64, Collections.reverseOrder());
                newQueue.add(profit[i]);
                cityToProfitMap.put(currentCity, newQueue);
            }
        }
        int maxProfit = 0;
        for (int visitedCity : visit) {
            PriorityQueue<Integer> queueForCity = cityToProfitMap.get(visitedCity);
            if (queueForCity != null && !queueForCity.isEmpty()) {
                maxProfit += queueForCity.poll();
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(getMaxProfit(2,
                new int[]{3, 10},
                new int[]{1, 1},
                new int[]{2, 1}));
    }
}
