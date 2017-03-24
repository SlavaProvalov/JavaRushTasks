package com.javarush.task.task18.task1817;

/* 
Пробелы

В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.
*/

import java.io.FileInputStream;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        double countSpaces = 0;
        double countLetters = 0;
        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 32) {
                countSpaces++;
            }
            countLetters++;
        }
        System.out.println(((double) Math.round((countSpaces / countLetters * 100) * 100)) / 100);
        fileInputStream.close();


    }
}
