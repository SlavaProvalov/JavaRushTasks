package com.javarush.task.task19.task1925;

/* 
Длинные слова

В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);

        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append((char) reader.read());
        }
        reader.close();

        String[] pars = builder.toString().split("\\s");
        boolean notFirst = false;
        for (int i = 0; i < pars.length; i++) {
            if (pars[i].length() > 6) {
                if (notFirst) {
                    writer.write(",");
                }
                writer.write(pars[i]);
                notFirst = true;
            }

        }
        writer.close();
    }
}
