package com.aaditya.topcoder.div2.srm574;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


/**
 */
public class TheNumberGameDiv2 {
    public static int minimumMoves(int A, int B) {
        String a = String.valueOf(A);
        String b = String.valueOf(B);
        if (!isPossible(a, b)) {
            return -1;
        }
        Map<Integer, Integer> distance = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(A);
        distance.put(A, 0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int[] moves = {curr / 10, Integer.parseInt(new StringBuilder(String.valueOf(curr)).reverse().toString())};
            for (int move : moves) {
                if (distance.get(move) == null) {
                    distance.put(move, distance.get(curr) + 1);
                    queue.add(move);
                }
            }
        }
        return distance.get(B);
    }

    public static boolean isPossible(String A, String B) {
        return A.contains(B) || A.contains(new StringBuilder(B).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(minimumMoves(218181918, 9181));
    }
}
