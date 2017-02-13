package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list.add("релог");
        list.add("логгер");
        list.add("лилия");
        list.add("рапорт");
        list.add("структура");
        list.add("эпилог");
        list.add("эпилог");
        list.add("эпилог");
        list.add(reader.readLine());
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains("р") && !s.contains("л")) {
                list.remove(s);
                i--;
            } else if (s.contains("л") && !s.contains("р")) {
                list.add(i + 1, s);
                i++;

            }
        }
        return list;
    }
}