package com.aaditya.topcoder.div2.srm649;

import java.util.Collections;
import java.util.PriorityQueue;

public final class CartInSupermarketEasy {
    public static void main(String[] args) {
        System.out.println(calc(45,5));
    }

    public static int calc(int N, int K) {
        if (K >= N) {
            return (int) (Math.ceil(Math.log(N) / Math.log(2)) + 1.0);
        } else {
            // Always gets the largest element of the queue for splitting.
            PriorityQueue<Integer> sequences = new PriorityQueue<Integer>(N, Collections.reverseOrder());
            // Initialization of the queue.
            sequences.add(N);
            // If the largest element is not 0, then we continue.
            int numMoves = 0;
            while (sequences.peek() != 0) {
                // Take each of the existing sequences by reverse order and perform a move on them.
                // Once they are done, insert them back into sequences.
                PriorityQueue<Integer> newSequences = new PriorityQueue<>(N, Collections.reverseOrder());
                while (!sequences.isEmpty()) {
                    int maxSeq = sequences.poll();
                    if (K > 0) {
                        K--;
                        if (maxSeq % 2 == 0) {
                            newSequences.add(maxSeq / 2);
                            newSequences.add(maxSeq / 2);
                        } else {
                            newSequences.add(maxSeq / 2);
                            newSequences.add(maxSeq / 2 + 1);
                        }
                    } else {
                        newSequences.add(maxSeq - 1);
                    }
                }
                sequences.addAll(newSequences);
                newSequences.clear();
                numMoves++;
            }
            return numMoves;
        }
    }
}
