package com.javarush.task.task18.task1808;

/* 
Разделение файла

Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName3);

        final int size = fileInputStream.available();
        while (fileInputStream.available() > size / 2) {
            int data = fileInputStream.read();
            fileOutputStream1.write(data);
        }
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream2.write(data);
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();

    }
}
