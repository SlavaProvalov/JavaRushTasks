package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 5; i++) {
                char a = 1041;
                map.put("" + (char) (a + j) + (char) (a + i + 3) + (char) (a + i + 6),
                        "" + (char) (a + i + 1) + (char) (a + i + 5) + (char) (a + i + 7));
            }
        }
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copyMap = new HashMap<>(map);
        int count = 0;

        for (Map.Entry<String, String> pair : copyMap.entrySet()) {
            String firstName = pair.getValue();
            for (Map.Entry<String, String> entry : copyMap.entrySet()) {
                if (entry.getValue().equals(firstName)) {
                    count++;
                }
            }
            if (count > 1) {
                removeItemFromMapByValue(map, firstName);
                count = 0;
            }
        }

    }


    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    /*public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("------------------------------");
        removeTheFirstNameDuplicates(map);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }*/
}
