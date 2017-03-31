package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами

Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, «span«.
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, n, r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) {
            builder.append((fileReader.readLine()));
        }
        fileReader.close();

        String data = builder.toString().replaceAll((">\\p{Blank}+<"), "><");

        String tagName = args[0];

        ArrayList<Integer> indexList = new ArrayList<>();
        ArrayList<String> tagTypeList = new ArrayList<>();


        String openTagWithAttributes = String.format("<%s ", tagName);
        String openTagWithoutAttributes = String.format("<%s>", tagName);
        String closeTag = String.format("</%s>", tagName);
        int end = data.length() - tagName.length() - 2;
        for (int i = 0; i < end; i++) {
            String sub = data.substring(i, i + tagName.length() + 2);
            if (sub.equals(openTagWithoutAttributes)) {
                indexList.add(i);
                tagTypeList.add(openTagWithoutAttributes);
            } else if (sub.equals(openTagWithAttributes)) {
                indexList.add(i);
                tagTypeList.add(openTagWithAttributes);
            } else if ((sub + ">").equals(closeTag)) {
                indexList.add(i);
                tagTypeList.add(closeTag);
            }
        }

        int tagCounter = 0;
        int count = 0;
        while (tagCounter < indexList.size()) {
            for (int i = tagCounter; i < indexList.size(); i++) {
                if (tagTypeList.get(i).equals(openTagWithAttributes) ||
                        tagTypeList.get(i).equals(openTagWithoutAttributes)) {
                    count++;
                } else if (tagTypeList.get(i).equals(closeTag)) {
                    count--;
                }
                if (count == 0) {
                    System.out.println(data.substring(indexList.get(tagCounter), indexList.get(i) + tagName.length() + 3));
                    tagCounter++;
                    break;
                }
                if (count == -1) {
                    count = 0;
                    tagCounter++;
                    continue;

                }
            }
        }

    }
}
