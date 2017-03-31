package com.javarush.task.task19.task1908;

/* 
Выделяем числа

Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String[] result = sb.toString().split(" ");
        for (int i = 0; i < result.length; i++) {
            if (check(result[i])) {
                fileWriter.write(result[i] + " ");
            }
        }
        fileReader.close();
        fileWriter.close();

    }

    private static boolean check(String s) {
        Pattern pattern = Pattern.compile("\\p{Digit}+");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
