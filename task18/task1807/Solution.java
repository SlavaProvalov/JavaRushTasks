package com.javarush.task.task18.task1807;

/* 
Подсчет запятых

С консоли считать имя файла.
Посчитать в файле количество символов ‘,‘, количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ‘,‘.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream fileReader = new FileInputStream(filename);
        int count = 0;
        while (fileReader.available() > 0) {
            int symbol = fileReader.read();
            if ((char) symbol == ',') {
                count++;
            }
        }
        System.out.println(count);
        fileReader.close();
    }
}
