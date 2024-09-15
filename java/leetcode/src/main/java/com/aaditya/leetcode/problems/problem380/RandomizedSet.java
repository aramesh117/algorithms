package com.aaditya.leetcode.problems.problem380;

import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private final Random rand = new Random();

    // maps from value -> index.
    private final HashMap<Integer, Integer> contents;
    // maps from index -> value
    private final HashMap<Integer, Integer> indexMapper;

    public RandomizedSet() {
        contents = new HashMap<>();
        indexMapper = new HashMap<>();
    }

    public boolean insert(int val) {
        if (contents.containsKey(val)) {
            return false;
        } else {
            int index = contents.size();
            contents.put(val, index);
            indexMapper.put(index, val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (contents.containsKey(val)) {
            // Find the current index, remove it, and insert last index so the size becomes N - 1
            int currentIndex = contents.get(val);
            int lastIndex = contents.size() - 1;
            int lastElement = indexMapper.get(lastIndex);

            if (val != lastElement) {
                contents.remove(val);
                indexMapper.remove(lastIndex);
                contents.put(lastElement, currentIndex);
                indexMapper.put(currentIndex, lastElement);
            } else {
                contents.remove(val);
                indexMapper.remove(lastIndex);
            }

            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return indexMapper.get(rand.nextInt(contents.size()));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(4));
        System.out.println(obj.remove(4));
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.getRandom());
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new RandomizedSet(); boolean
 * param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */