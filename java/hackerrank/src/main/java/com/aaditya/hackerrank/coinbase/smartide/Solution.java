package com.aaditya.hackerrank.coinbase.smartide;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final Pattern multiLine = Pattern.compile("(/\\*.*?\\*/)|(//.*?(\\n|$))", Pattern.DOTALL);
    private static final Pattern leadingWhiteSpace = Pattern.compile("\\n\\s*");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder fullText = new StringBuilder();
            while (scanner.hasNextLine()) {
                fullText.append(scanner.nextLine() + "\n");
            }
            Matcher matcher = multiLine.matcher(fullText);
            while (matcher.find()) {
                System.out.println(leadingWhiteSpace.matcher(matcher.group().trim()).replaceAll("\n"));
            }
        }
    }
}
