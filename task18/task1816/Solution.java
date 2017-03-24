package com.javarush.task.task18.task1816;

/* 
Английские буквы

В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.
*/

import java.io.FileInputStream;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {


        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if ((data >= 65 && data <= 90) ||
                    (data >= 97 && data <= 122)) {
                count++;
            }
        }
        System.out.println(count);
        fileInputStream.close();


    }
}
