package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution {
    public static HashSet<String> createSet() {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            char a = (char) (i + 1072);
            char b = (char) (i + 1075);
            char c = (char) (i + 1077);
            set.add("Л" + a + b + c);
        }
        return set;
    }

    public static void main(String[] args) {
        HashSet<String> set = createSet();
        for (String s : set) {
            System.out.println(s);
        }
    }
}
