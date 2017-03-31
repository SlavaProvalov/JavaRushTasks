package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения

Считать с консоли 2 имени файла — file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();
    public static List<String> listOne = new ArrayList<>();
    public static List<String> listTwo = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
//
        BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));
        while (fileReader1.ready()) {
            listOne.add(fileReader1.readLine());
        }
        while (fileReader2.ready()) {
            listTwo.add(fileReader2.readLine());
        }
        fileReader1.close();
        fileReader2.close();

        int size = listOne.size();

        for (int i = 0; i < size; i++) {
            if (size > i && listTwo.size() > 0) {
                String s1 = listOne.get(i);
                String s2 = listTwo.get(0);
                if (s1.equals(s2)) {
                    lines.add(new LineItem(Type.SAME, s2));
                    listTwo.remove(0);
                } else {
                    if (listTwo.size() > 1) {
                        String temp = s2;
                        s2 = listTwo.get(1);
                        lines.add(s1.equals(s2) ? new LineItem(Type.ADDED, temp) : new LineItem(Type.REMOVED, s1));
                        if (s1.equals(s2)) {
                            listTwo.remove(0);
                            i--;
                        }
                    }
                }
            } else if (size > i && listTwo.size() == 0) {
                String s = listOne.get(i);
                lines.add(new LineItem(Type.REMOVED, s));
            } else if (i >= size && listTwo.size() > 1) {
                String s = listTwo.get(0);
                lines.add(new LineItem(Type.ADDED, s));
                lines.remove(0);
                i--;
            }
        }
    }


    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return String.valueOf(type) + " " + line;

        }

    }
}