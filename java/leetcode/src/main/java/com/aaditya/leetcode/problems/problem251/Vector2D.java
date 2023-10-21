package com.aaditya.leetcode.problems.problem251;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    private final Iterator<List<Integer>> upperIterator;
    private Iterator<Integer> lowerIterator;

    public Vector2D(List<List<Integer>> vec2d) {
        upperIterator = vec2d.iterator();
        if (upperIterator.hasNext()) {
            lowerIterator = upperIterator.next().iterator();
        } else {
            lowerIterator = Collections.emptyIterator();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list.add(list4);
        Vector2D vector2D = new Vector2D(list);
        while (vector2D.hasNext()) {
            System.out.println(vector2D.next());
        }
    }

    @Override
    public Integer next() {
        return lowerIterator.next();
    }

    @Override
    public boolean hasNext() {
        if (lowerIterator.hasNext()) {
            return true;
        } else {
            // To account for empty nested lists, we need to keep skipping upper lists until we either hit the end of
            // the upper list or we have an element in the lower list.
            while (upperIterator.hasNext() && !lowerIterator.hasNext()) {
                lowerIterator = upperIterator.next().iterator();
            }
            return lowerIterator.hasNext();
        }
    }
}

/*
  Your Vector2D object will be instantiated and called as such:
  Vector2D i = new Vector2D(vec2d);
  while (i.hasNext()) v[f()] = i.next();
 */
