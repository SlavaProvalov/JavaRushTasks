package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            char a = (char) (i + 1041);

            map.put("" + a + (char) (a + 3) + (char) (a + 6), "" + (char)(a + 1) + (char) (a + 5) + (char) (a + 7));
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for (String s : map.values()) {
            if (s.equalsIgnoreCase(name)) {
                count++;
            }
        }

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
        for (String s : map.keySet()) {
            if (s.equalsIgnoreCase(lastName)) {
                count++;
            }
        }
        return count;
    }
}
