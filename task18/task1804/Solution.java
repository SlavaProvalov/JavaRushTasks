package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты

Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
        FileInputStream streamOne = new FileInputStream(filePath);

        Map<Integer, Integer> map = new HashMap<>();
        int generalCounter = Integer.MAX_VALUE;

        while (streamOne.available() > 0) {
            int count = 0;
            FileInputStream streamTwo = new FileInputStream(filePath);
            int tempByte = streamOne.read();
            if (map.containsKey(tempByte)) {
                continue;
            }
            while (streamTwo.available() > 0) {
                int data = streamTwo.read();
                if (data == tempByte) {
                    count++;
                }
            }
            map.put(tempByte, count);
            if (count < generalCounter) {
                generalCounter = count;
            }
            streamTwo.close();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == generalCounter) {
                System.out.print(entry.getKey() + " ");

            }
        }
        streamOne.close();
    }
}
