package com.javarush.task.task19.task1906;

/* 
Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.

Пример:
второй байт, четвертый байт, шестой байт и т.д.

Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        if (fileIn.isEmpty() || fileOut.isEmpty()) {
            throw new IllegalArgumentException();
        }
        reader.close();
        FileReader fileReader = new FileReader(fileIn);
        FileWriter fileWriter = new FileWriter(fileOut);
        int count = 1;
        while (fileReader.ready()) {
            int data = fileReader.read();
            if (count % 2 == 0) {
                fileWriter.write(data);
            }
            count++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
