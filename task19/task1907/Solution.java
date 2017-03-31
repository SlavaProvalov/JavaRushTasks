package com.javarush.task.task19.task1907;

/* 
Считаем слово

Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.
*/
// TODO 1907

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        int worldCount = 0;
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
        }
        String result = sb.toString();
        String[] strings = result.split("\\p{Punct}");
        fileReader.close();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("world")) {
                worldCount++;
            }

        }
        System.out.println(worldCount);
    }
}
