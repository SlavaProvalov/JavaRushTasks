package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        String[] months = {"DECEMBER", "JANUARY", "FEBRUARY",
                "MARCH", "APRIL", "MAY",
                "JUNE", "JULY", "AUGUST",
                "SEPTEMBER", "OCTOBER", "NOVEMBER"};
        map.put("Stallone", new Date("JUNE 1 1980"));
        for (int i = 0; i < 9; i++) {
            char a = 1040;
            map.put("" + (char)(a + i) + (char) (a + i + 2) + (char) (a + i + 4) + (char) (a + i + 7),
                    new Date("" + months[i] + " " + i + " " + (1950 + i * 3)));
        }

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date dateOfBirth = pair.getValue();
            long month = dateOfBirth.getMonth();
            if (month > 4 && month < 8) {
                iterator.remove();
            }

        }

    }

   /* public static void main(String[] args) {
        HashMap<String,Date> map = createMap();
        for (Map.Entry<String, Date> entry : map.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("--------------------------------------------------------");
        removeAllSummerPeople(map);

        for (Map.Entry<String, Date> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }*/
}
