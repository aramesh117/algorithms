package com.aaditya.leetcode.problems.problem125;

class Solution {
    public boolean isPalindrome(String s) {
        String replaced = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        System.out.println(replaced);
        int i = 0, j = replaced.length() - 1;
        while (i <= j) {
            if (replaced.charAt(i) == replaced.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }

}