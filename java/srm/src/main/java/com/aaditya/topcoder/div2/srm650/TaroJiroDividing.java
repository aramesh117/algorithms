package com.aaditya.topcoder.div2.srm650;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaroJiroDividing {
    public static int getNumber(int A, int B) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        while(A % 2 == 0) {
            a.add(A);
            A /= 2;
        }
        a.add(A);
        while(B % 2 == 0) {
            b.add(B);
            B /= 2;
        }
        b.add(B);
        return intersection(a, b).size();
    }

    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new TreeSet<T>();
        for (T x : setA)
            if (setB.contains(x))
                tmp.add(x);
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(getNumber(8,4));
    }
}
