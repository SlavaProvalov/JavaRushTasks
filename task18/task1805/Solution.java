package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт

Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений — отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(filePath);

        List<Integer> list = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (!list.contains(data)) {
                list.add(data);
            }

        }

        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        fileInputStream.close();
    }

}

