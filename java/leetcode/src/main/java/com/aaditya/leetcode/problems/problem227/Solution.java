package com.aaditya.leetcode.problems.problem227;

class Solution {
    public static int calculate(String s) {
        int result = 0;
        int currentProduct = 1;
        int currentNumber = 0;
        int currentSign = 1;
        boolean mult = true;
        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                currentNumber = 10 * currentNumber + s.charAt(i) - '0';
            } else {
                if (s.charAt(i) == '+') {
                    result += currentSign * (mult ? currentProduct * currentNumber : currentProduct / currentNumber);
                    currentProduct = 1;
                    currentSign = 1;
                    mult = true;
                } else if (s.charAt(i) == '-') {
                    result += currentSign * (mult ? currentProduct * currentNumber : currentProduct / currentNumber);
                    currentProduct = 1;
                    currentSign = -1;
                    mult = true;
                } else if (s.charAt(i) == '*') {
                    currentProduct = (mult ? currentProduct * currentNumber : currentProduct / currentNumber);
                    mult = true;
                } else {
                    currentProduct = (mult ? currentProduct * currentNumber : currentProduct / currentNumber);
                    mult = false;
                }
                currentNumber = 0;
            }
            if (i == s.length() - 1) {
                result += currentSign * (mult ? currentProduct * currentNumber : currentProduct / currentNumber);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2 + 1"));
        System.out.println(calculate("2 + 1 + 3"));
        System.out.println(calculate("2 + 1 - 3"));
        System.out.println(calculate("2"));
        System.out.println(calculate("0 + 1"));
        System.out.println(calculate("1 * 2 * 3 + 4*2 + 1234"));
        System.out.println(calculate("3/1"));
        System.out.println(calculate("4/3 "));
        System.out.println(calculate("8/4"));
        System.out.println(calculate("1/2"));
        System.out.println(calculate("1"));
        System.out.println(calculate("4/3 + 2"));
    }
}