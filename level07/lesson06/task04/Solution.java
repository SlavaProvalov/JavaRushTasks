package com.javarush.test.level07.lesson06.task04;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;


/* 10 строчек в начало списка
1. Создай список строк в методе main.
2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 5;
        list.add(reader.readLine());
        for (int i = 0; i < x - 1; i++) {
            list.add(0, reader.readLine());
        }
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.get(list.size() - 1));

    }
}
