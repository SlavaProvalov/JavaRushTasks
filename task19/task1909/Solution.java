package com.javarush.task.task19.task1909;

/* 
Замена знаков

Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки «.» на знак «!«.
Результат вывести во второй файл.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOut));
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append((char) fileReader.read());
        }
        System.out.println(sb.toString());
        String result = sb.toString().replaceAll("\\.", "!");
        System.out.println(result);
        fileWriter.write(result.toCharArray());

        fileReader.close();
        fileWriter.close();
    }
}
