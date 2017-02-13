package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        Iterator<Integer> integerIterator = set.iterator();
        while (integerIterator.hasNext()) {
            Integer integer = integerIterator.next();
            if (integer > 10) {
                integerIterator.remove();
            }
        }
        return set;
    }

    /*public static void main(String[] args) {
        HashSet<Integer> set = createSet();
        for (Integer integer : set) {
            System.out.print(integer + "\t");
        }
        System.out.println();
        removeAllNumbersMoreThan10(set);
        for (Integer integer : set) {
            System.out.print(integer+"\t");
        }
    }*/
}
