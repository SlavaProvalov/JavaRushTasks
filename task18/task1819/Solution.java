package com.javarush.task.task18.task1819;

/* 
Объединение файлов

Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);

        byte[] buffer = new byte[fileInputStream1.available()];
        int counter = 0;
        while (fileInputStream1.available() > 0) {
            buffer[counter] = (byte) fileInputStream1.read();
            counter++;
        }
        fileInputStream1.close();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        while (fileInputStream2.available() > 0) {
            fileOutputStream.write(fileInputStream2.read());
        }
        fileInputStream2.close();
        fileOutputStream.write(buffer);
        fileOutputStream.close();

    }
}
