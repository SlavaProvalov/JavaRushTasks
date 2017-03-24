package com.javarush.task.task18.task1809;

/* 
Реверс файла

Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        int[] buffer = new int[fileInputStream.available()];

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = fileInputStream.read();
        }
        for (int i = buffer.length - 1; i >= 0; i--) {
            fileOutputStream.write(buffer[i]);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
