package com.javarush.task.task18.task1818;

/* 
Два в одном

Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);

        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        while (fileInputStream2.available() > 0) {
            fileOutputStream.write(fileInputStream2.read());
        }
        fileInputStream2.close();
        while (fileInputStream3.available() > 0) {
            fileOutputStream.write(fileInputStream3.read());
        }
        fileInputStream3.close();
        fileOutputStream.close();

    }
}
