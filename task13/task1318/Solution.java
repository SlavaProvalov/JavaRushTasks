package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/* 
Чтение файла

1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /* D:\JAVA\JavaRushIdeaPlugin\JavaRushTasks\2.JavaCore\src\com\javarush\task\task13\task1318\fileToRead */
        InputStream inputStream = new FileInputStream(reader.readLine());

        reader.close();
        OutputStream outputStream = System.out;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            outputStream.write(data);
        }
        System.out.println();
        inputStream.close();
        outputStream.close();
    }
}