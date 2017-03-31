package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки

Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова — подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
//        -----------------TEST--------------
//        String fileName = "D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1922\\testFile";
//        -----------------------------------
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            int count = 0;
            String str = fileReader.readLine();
            for (String word : words) {
                if (str.contains(word)) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(str);
            }
        }
        fileReader.close();
    }
}
