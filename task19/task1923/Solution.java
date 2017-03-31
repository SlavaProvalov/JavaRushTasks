package com.javarush.task.task19.task1923;

/* 
Слова с цифрами

В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] argss) throws IOException {//TODO
//        ----------------------TEST------------------
        String[] args = {"D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\testFileIn",
                "D:\\JAVA\\JavaRushIdeaPlugin\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\testFileOut"};
//        --------------------------------------------
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");
            for (int i = 0; i < words.length; i++) {
                if (!words[i].matches("^\\D+$")) {
                    if (!builder.toString().isEmpty()) {
                        builder.append(" ");
                    }
                    builder.append(words[i]);
                }
            }
        }
        fileWriter.write(builder.toString());
        fileReader.close();
        fileWriter.close();

    }
}
