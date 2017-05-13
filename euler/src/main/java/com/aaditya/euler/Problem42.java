package com.aaditya.euler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem42 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/home/aramesh/git/aramesh117/algorithms/euler/src/main/resources/p042_words.txt"));
        int numTriangle = 0;
        for (String line : lines) {
            List<String> words = Arrays.stream(line.split(",")).map(s -> s.substring(1, s.length() - 1)).collect(Collectors.toList());
            for (String word : words) {
                numTriangle += isTriangularWord(word) ? 1 : 0;
            }
        }
        System.out.println(numTriangle);
    }

    public static boolean isTriangularWord(String word) {
        int value = 0;
        for (int i = 0; i < word.length(); i++) {
            value += word.charAt(i) - 'A' + 1;
        }
        return isTriangular(value);
    }

    public static boolean isTriangular(int n) {
        for (int i = (int) Math.sqrt(2 * n) - 2; i <= (int) Math.sqrt(2 * n) + 2; i++) {
            if (i * (i + 1) == 2 * n) {
                return true;
            }
        }
        return false;
    }
}
