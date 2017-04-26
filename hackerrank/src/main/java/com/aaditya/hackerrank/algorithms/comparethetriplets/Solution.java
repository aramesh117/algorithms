package com.aaditya.hackerrank.algorithms.comparethetriplets;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a0 = in.nextInt();
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            int b0 = in.nextInt();
            int b1 = in.nextInt();
            int b2 = in.nextInt();
            // Write Your Code Here
            int alice = 0;
            int bob = 0;
            alice += a0 > b0 ? 1 : 0;
            alice += a1 > b1 ? 1 : 0;
            alice += a2 > b2 ? 1 : 0;
            bob += b0 > a0 ? 1 : 0;
            bob += b1 > a1 ? 1 : 0;
            bob += b2 > a2 ? 1 : 0;
            System.out.println(alice + " " + bob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

