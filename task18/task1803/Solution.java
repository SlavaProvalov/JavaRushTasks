package com.javarush.task.task18.task1803;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
        FileInputStream stream1 = new FileInputStream(filePath);

        Map<Integer, Integer> map = new HashMap<>();
        int generalCounter = 0;

        while (stream1.available() > 0) {
            int count = 0;
            FileInputStream stream2 = new FileInputStream(filePath);
            int tempByte = stream1.read();
            if (map.containsKey(tempByte)) {
                continue;
            }
            while (stream2.available() > 0) {
                int data = stream2.read();
                if (data == tempByte) {
                    count++;
                }
            }
            map.put(tempByte, count);
            if (count > generalCounter) {
                generalCounter = count;
            }
            stream2.close();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == generalCounter) {
                System.out.print(entry.getKey() + " ");

            }
        }
        stream1.close();
    }
}
