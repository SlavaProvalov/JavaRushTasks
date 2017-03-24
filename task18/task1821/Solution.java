package com.javarush.task.task18.task1821;

/* 
Встречаемость символов

Программа запускается с одним параметром — именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
‘,’=44, ‘s’=115, ‘t’=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new HashMap<>();

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(args[0]);

            while (fileInputStream.available() > 0) {
                Character data = (char) fileInputStream.read();
                map.put(data, map.containsKey(data) ? map.get(data) + 1 : 1);
            }
            fileInputStream.close();

            for (int i = 0; i < 256; i++) {
                Character character = (char) i;
                if (map.containsKey(character)) {
                    System.out.println(character + " " + map.get(character));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }

    }
}
