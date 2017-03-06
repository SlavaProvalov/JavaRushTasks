package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Запись в файл с консоли

1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /* D:\JAVA\JavaRushIdeaPlugin\JavaRushTasks\2.JavaCore\src\com\javarush\task\task13\task1319\FileToWrite */
        String filePath = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            list.add(s);
            if (s.equals("exit")) {
                break;
            }

        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        for (String string : list) {
            bufferedWriter.write(string + "\n");
        }

        reader.close();
        bufferedWriter.close();
    }
}
