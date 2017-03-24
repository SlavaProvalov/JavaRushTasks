package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();//D:\JAVA\JavaRushIdeaPlugin\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1801\Условие.jrtc
        FileInputStream fileInputStream = new FileInputStream(s);
        int max = 0;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data > max) {
                max = data;
            }
        }

        System.out.println(max);
        fileInputStream.close();
    }
}
