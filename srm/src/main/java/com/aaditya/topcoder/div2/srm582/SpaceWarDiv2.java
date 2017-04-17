package com.aaditya.topcoder.div2.srm582;

import java.util.Arrays;

public class SpaceWarDiv2 {
    public static boolean isPossible(int[] magicalGirlStrength, int[] enemies, int F) {
        int enemyIndex = enemies.length - 1;
        for (int i = magicalGirlStrength.length - 1; i >= 0; i--) {
            int numBattles = 0;

            if (enemies[enemyIndex] > magicalGirlStrength[i]) {
                return false;
            }
            while (numBattles < F && enemyIndex >= 0 && enemies[enemyIndex] <= magicalGirlStrength[i]) {
                numBattles++;
                enemyIndex--;
            }

            if (enemyIndex < 0) {
                return true;
            }
        }
        return false;
    }

    public static int minimalFatigue(int[] magicalGirlStrength, int[] enemyStrength, int[] enemyCount) {
        Arrays.sort(magicalGirlStrength);
        int numEnemies = 0;
        for (int anEnemyCount : enemyCount) {
            numEnemies += anEnemyCount;
        }
        int[] enemies = new int[numEnemies];
        int j = 0;
        for (int i = 0; i < enemyStrength.length; i++) {
            for (int k = 0; k < enemyCount[i]; k++) {
                enemies[j] = enemyStrength[i];
                j++;
            }
        }
        Arrays.sort(enemies);
        if (enemies[enemies.length - 1] > magicalGirlStrength[magicalGirlStrength.length - 1]) {
            return -1;
        }
        for (int F = numEnemies / magicalGirlStrength.length; F <= 5000; F++) {
            if (isPossible(magicalGirlStrength, enemies, F)) {
                return F;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] girls = {17, 10, 29, 48, 92, 60, 80, 100, 15, 69, 36, 43, 70, 14, 88, 12, 14, 29, 9, 40};
        int[] enemyStrength = {93, 59, 27, 68, 48, 82, 15, 95, 61, 49, 68, 15, 16, 26, 64, 82, 7, 8, 92, 15};
        int[] enemyCount = {56, 26, 12, 52, 5, 19, 93, 36, 69, 61, 68, 66, 55, 28, 49, 55, 63, 57, 33, 45};
        System.out.println(minimalFatigue(girls, enemyStrength, enemyCount));
    }
}
